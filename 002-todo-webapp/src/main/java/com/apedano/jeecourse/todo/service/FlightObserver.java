package com.apedano.jeecourse.todo.service;

import com.apedano.jeecourse.todo.annotations.MyService;
import com.apedano.jeecourse.todo.entity.events.Flight;
import com.apedano.jeecourse.todo.entity.events.TakenOffFlight;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import java.time.LocalDateTime;

@MyService
@Slf4j
public class FlightObserver {

    public void observeJustCreated(@Observes @JustCreatedFlight Flight flight) {
        log.info("New flight observed: {}", flight);
    }

    /**
     * notifyObserver = Reception.IF_EXISTS: an observer method is only called if the current instance of the bean declaring the observer method
     *                                       already exists.
     *  during = TransactionPhase.AFTER_COMPLETION: Identifies an after completion observer method, called during the after completion phase of the transaction.
     * @param flight
     */
    public void conditionalObserver(@Observes(notifyObserver = Reception.IF_EXISTS,
            during = TransactionPhase.AFTER_COMPLETION) @JustCreatedFlight Flight flight) {
        log.info("New flight observed: {}", flight);

    }

    public void observeCreatedAsync(@ObservesAsync @JustCreatedFlight Flight flight) throws InterruptedException {
        log.info("New flight observed: {}", flight);
        Thread.sleep(2000);
    }

    public void observeTakeOffFlightDepartureAirport(@Observes @JustTakenOffFlight @Priority(100) TakenOffFlight takenOffFlight) {
        log.info("Take off flight observed at the departure (first -> lower @Priority): {}", takenOffFlight);
    }

    public void observeTakeOffFlightArrivalAirport(@Observes @JustTakenOffFlight @Priority(200) TakenOffFlight takenOffFlight) {
        log.info("Take off flight observed at the arrival (second -> higher @Priority): {}", takenOffFlight);
    }
}
