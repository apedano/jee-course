package com.apedano.jeecourse.todo.controller;

import com.apedano.jeecourse.todo.entity.CarResponse;
import com.apedano.jeecourse.todo.service.VehicleService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("vehicle")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class VehicleRest {

    /*** FIELD injection point ***/
    @Inject
    private VehicleService vehicleService;

    @Path("description")
    @GET
    public Response getVehicleDescription(@QueryParam("type") String type, @QueryParam("model") String model) {
        log.info("getVehicleDescription endpoint call on the VehicleRest");
        return Response.ok(new CarResponse(vehicleService.getDescription(type, model))).build();
    }

}
