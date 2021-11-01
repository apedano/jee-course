package com.apedano.jeecourse.todo.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggerProducer {

    @Produces
    public Logger prouduceLogger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger("[PRODUCED] " + injectionPoint.getMember().getDeclaringClass().getName());
    }
}
