package com.looboo.kafkasql.rest.resources;

import com.looboo.kafkasql.executor.FutureCallback;
import com.looboo.kafkasql.executor.SqlExecutor;
import com.looboo.kafkasql.rest.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;


@Slf4j
@Path("/")
public class SqlResource {

    @javax.ws.rs.core.Context
    private ServletContext context;

    @POST
    @Path("sql/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse executeSql(@PathParam("name") final String name, final Map<String, String> sql) {
        log.info("execute sql {}", sql);
        FutureCallback<String> cb = new FutureCallback<>();
        SqlExecutor.getInstance().execute(name, sql, cb);

        try {
            return ApiResponse.ofSuccess(cb.get());
        } catch (Exception e) {
            log.warn("execute failed {}", e.getLocalizedMessage());
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

    @POST
    @Path("broker/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse addBoosstrapServer(@PathParam("name") final String name, final Map<String, String> config) {
        log.info("add a broker {}", name);
        FutureCallback<String> cb = new FutureCallback<>();
        SqlExecutor.getInstance().addBroker(name, config, cb);

        try {
            return ApiResponse.ofSuccess(cb.get());
        } catch (Exception e) {
            log.warn("execute failed {}", e.getLocalizedMessage());
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }
}

