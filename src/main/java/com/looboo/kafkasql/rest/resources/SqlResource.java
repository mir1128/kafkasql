package com.looboo.kafkasql.rest.resources;

import com.looboo.kafkasql.executor.SqlExecutor;
import com.looboo.kafkasql.rest.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;



@Slf4j
@Path("/")
public class SqlResource {

    @javax.ws.rs.core.Context
    private ServletContext context;

    @POST
    @Path("sql")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse executeSql(final Map<String, String> sql) {
        log.info("execute sql {}", sql);
        SqlExecutor.getInstance().addRequest(() -> null, (error, result) -> {});
        return ApiResponse.ofSuccess(null);
    }
}

