package com.apedano.jeecourse.todo.interceptors;

import org.slf4j.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.LocalDateTime;
import java.util.Arrays;

@Audit //the interceptor binding annotation
@Interceptor //to specify that it is an inteceptor class
@Priority(Interceptor.Priority.APPLICATION) //used to trigger the interceptor
public class CheckMethodParameterInterceptor {

    private static final Long REJECTION_PARAMETER = Long.valueOf(666);

    @Inject
    Logger logger;

    @AroundInvoke
    public Object auditCall(InvocationContext invocationContext) throws Exception {
        boolean hasRejectionParameter =Arrays.stream(invocationContext.getParameters())
                .anyMatch(p -> (p instanceof Long) && (long) p == 666);
        if(hasRejectionParameter) {
            logger.warn("The method has the rejection parameter. Call blocked");
            return null;
        }
        logger.info("The method has not the rejection parameter. Call continues");
        return invocationContext.proceed();
    }
}
