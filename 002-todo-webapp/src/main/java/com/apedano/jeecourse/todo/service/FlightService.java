package com.apedano.jeecourse.todo.service;

import com.apedano.jeecourse.todo.annotations.MyService;
import com.apedano.jeecourse.todo.entity.events.*;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.concurrent.CompletionStage;

@MyService
@Slf4j
public class FlightService {

    @Inject
    @JustCreatedFlight
    private Event<Flight> createFlightEvent;

    @Inject
    @JustTakenOffFlight
    private Event<TakenOffFlight> takeOffFlightEvent;

    public void triggerCreateFlightEvent(Flight flight) {
        log.info("Triggering new flight event");
        createFlightEvent.fire(flight);
    }

    public void triggerCreateFlightAsyncEvent(Flight flight) {
        log.info("Triggering new flight event");
        CompletionStage<Flight> flightCompletionStage = createFlightEvent.fireAsync(flight); //returns immediately
        flightCompletionStage.thenAccept(this::flightEventDelivered);
    }

    private void flightEventDelivered(Flight flight) {
        log.info("Async Event processed for flight {}", flight);
    }

    public LandedFlight createExample() {
        Route route = new Route(Airplane.AIRBUS_380_800, "PMO", "NDL");
        //return new Flight(route, LocalDateTime.now(), LocalDateTime.now().plusHours(2).plusMinutes(25));
        Flight flight = new Flight(route);
        TakenOffFlight takeOffFlightPayload = new TakenOffFlight(flight, LocalDateTime.now());
        return new LandedFlight(takeOffFlightPayload, LocalDateTime.now().plusHours(2).plusMinutes(25));
    }

    public void triggerTakeOffEvent(Flight flight) {
        TakenOffFlight takenOffFlight = new TakenOffFlight(flight, LocalDateTime.now());
        takeOffFlightEvent.fire(takenOffFlight);
    }
}
