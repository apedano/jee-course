package com.apedano.jeecourse.todo.controller;


import com.apedano.jeecourse.todo.entity.Todo;
import com.apedano.jeecourse.todo.entity.events.Flight;
import com.apedano.jeecourse.todo.service.FlightService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("flight")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class FlightRest {

    @Inject
    private FlightService flightService;

    @Path("new")
    @POST
    public Response triggerNew(Flight flight) {
        log.info("New flight call on the FLIGHT rest API: {}", flight);
        flightService.triggerCreateFlightEvent(flight);
        return Response.ok(new GenericResponse("The new flight event has been triggered. Look at the application log to check event handling logs")).build();
    }

    @Path("example")
    @GET
    public Response example(Flight flight) {
        log.info("Example flight call on the FLIGHT rest API");

        return Response.ok(flightService.createExample()).build();
    }
}
