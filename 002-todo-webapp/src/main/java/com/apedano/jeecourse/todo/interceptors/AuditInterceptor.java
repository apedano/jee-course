package com.apedano.jeecourse.todo.interceptors;

import org.slf4j.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.client.Invocation;
import java.time.LocalDateTime;

@Audit //the interceptor binding annotation
@Interceptor //to specify that it is an inteceptor class
@Priority(Interceptor.Priority.APPLICATION) //used to trigger the interceptor
public class AuditInterceptor {

    private static final String USER = "myUsername";

    /**
     * Producer
     */
    @Inject
    Logger logger;

    @AroundInvoke
    public Object auditCall(InvocationContext invocationContext) throws Exception {
        logger.info("Audit logger: user [{}] called method [{}] at {}",
                USER,
                invocationContext.getMethod().getName(),
                LocalDateTime.now());
        //if we want to block the execution we should simply return null
        return invocationContext.proceed();
    }


}
