package com.apedano.jeecourse.todo.service;

import com.apedano.jeecourse.todo.annotations.MyService;
import com.apedano.jeecourse.todo.entity.events.*;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.time.LocalDateTime;

@MyService
@Slf4j
public class FlightService {

    @Inject
    @JustCreatedFlight
    private Event<Flight> createFlightEvent;

    public void triggerCreateFlightEvent(Flight flight) {
        log.info("Triggering new flight event");
        createFlightEvent.fire(flight);
    }

    public LandedFlight createExample() {
        Route route = new Route(Airplane.AIRBUS_380_800, "PMO", "NDL");
        //return new Flight(route, LocalDateTime.now(), LocalDateTime.now().plusHours(2).plusMinutes(25));
        Flight flight = new Flight(route);
        TakenOffFlight takenOffFlight = new TakenOffFlight(flight, LocalDateTime.now());
        return new LandedFlight(takenOffFlight, LocalDateTime.now().plusHours(2).plusMinutes(25));
    }
}