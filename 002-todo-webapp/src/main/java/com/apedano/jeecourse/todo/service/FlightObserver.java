package com.apedano.jeecourse.todo.service;

import com.apedano.jeecourse.todo.annotations.MyService;
import com.apedano.jeecourse.todo.entity.events.Flight;
import com.apedano.jeecourse.todo.entity.events.TakenOffFlight;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import java.time.LocalDateTime;

@MyService
@Slf4j
public class FlightObserver {

    public void observeJustCreated(@Observes @JustCreatedFlight Flight flight) {
        log.info("New flight observed: {}", flight);
        TakenOffFlight takenOffFlight = new TakenOffFlight(flight, LocalDateTime.now());
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
        TakenOffFlight takenOffFlight = new TakenOffFlight(flight, LocalDateTime.now());
    }
}
