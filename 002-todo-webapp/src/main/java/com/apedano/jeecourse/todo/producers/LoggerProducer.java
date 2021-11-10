package com.apedano.jeecourse.todo.producers;

import com.apedano.jeecourse.todo.annotations.CarQualifier;
import com.apedano.jeecourse.todo.entity.Car;
import com.apedano.jeecourse.todo.entity.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
public class LoggerProducer {

    @Produces
    public Logger prouduceLogger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger("[PRODUCED] " + injectionPoint.getMember().getDeclaringClass().getName());
    }

    @Produces
    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    @CarQualifier
    private Vehicle produceVehicle() {
        return new Car();
    }

    private void doDispose(@Disposes Vehicle vehicle) {
        log.info("Disposing contextual instance:{}", vehicle);
    }
}
