package com.looboo.kafkasql.executor;

import com.looboo.kafkasql.assemble.KafkaSqlDriver;
import com.looboo.kafkasql.kafka.KafkaConsumerConfig;
import com.looboo.kafkasql.kafka.KafkaUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class SqlExecutor implements Runnable {

    final NavigableSet<SqlExecutionRequest> requests = new ConcurrentSkipListSet<>();

    private final ExecutorService executorService;
    private final AtomicBoolean stopping = new AtomicBoolean(false);
    private final AtomicLong requestSeqNum = new AtomicLong();

    private static SqlExecutor instance = new SqlExecutor();

    private Map<String, KafkaSqlDriver> driverMap = new HashMap<>();

    public static SqlExecutor getInstance() {
        if (!instance.stopping.get()) {
            instance.start();
        }
        return instance;
    }

    private SqlExecutor() {
        this.executorService = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1), r -> new Thread(r, "sql-execute-thread"));
    }

    public void start() {
        this.executorService.submit(this);
    }

    public void stop() {
        stopping.set(true);
    }

    @Override
    public void run() {
        log.info("executor starting");
        defaultSqlDriver();

        while (!stopping.get()) {
            tick();
        }

        log.info("executor stopped");
    }

    public boolean connect(String name, Map<String, String> opts) {
        KafkaUtil util = new KafkaUtil(new KafkaConsumerConfig(opts));
        KafkaSqlDriver driver = new KafkaSqlDriver(util);

        driverMap.put(name, driver);
        return true;
    }

    public SqlExecutionRequest addRequest(Callable<Void> action, Callback<Void> callback) {
        return addRequest(0, action, callback);
    }

    public SqlExecutionRequest addRequest(long delayMs, Callable<Void> action, Callback<Void> callback) {
        SqlExecutionRequest req = new SqlExecutionRequest(System.currentTimeMillis() + delayMs, requestSeqNum.incrementAndGet(), action, callback);
        requests.add(req);
        return req;
    }

    private void tick() {
        final long now = System.currentTimeMillis();
        while (true) {
            final SqlExecutionRequest next = peekWithoutException();
            if (next == null) {
                break;
            } else if (now >= next.getAt()) {
                requests.pollFirst();
            }
            try {
                next.action().call();
                next.callback().onCompletion(null, null);
            } catch (Throwable t) {
                next.callback().onCompletion(t, null);
            }
        }

    }

    private SqlExecutionRequest peekWithoutException() {
        try {
            return requests.isEmpty() ? null : requests.first();
        } catch (NoSuchElementException e) {
        }
        return null;
    }

    public void execute(String name, String sql, FutureCallback<String> callback) {
        addRequest(() -> {
            if (!driverMap.containsKey(name)) {
                callback.onCompletion(new RuntimeException("can not find bootstrap server"), null);
                return null;
            }

            KafkaSqlDriver driver = driverMap.get(name);
            String result = driver.parsing(sql);
            callback.onCompletion(null, result);
            return null;
        }, (e, r) ->{});
    }

    public void execute(String name, Map<String, String> requestMap, FutureCallback<String> callback) {
        if (!requestMap.containsKey("sql")) {
            callback.onCompletion(new RuntimeException("can not find sql to execute."), null);
            return ;
        }
        execute(name, requestMap.get("sql"), callback);
    }

    public void addBroker(String name, Map<String, String> config, FutureCallback<String> callback) {
        if (driverMap.containsKey(name)) {
            callback.onCompletion(new RuntimeException("broker already exist."), null);
        }

        KafkaConsumerConfig kafkaConsumerConfig = new KafkaConsumerConfig(config);
        driverMap.put(name, new KafkaSqlDriver(new KafkaUtil(kafkaConsumerConfig)));

        callback.onCompletion(null, "created");
    }

    private void defaultSqlDriver() {
        KafkaConsumerConfig kafkaConsumerConfig = new KafkaConsumerConfig(new HashMap<>());
        driverMap.put("default", new KafkaSqlDriver(new KafkaUtil(kafkaConsumerConfig)));
    }

}





