package com.apedano.jeecourse.todo.entity;

import com.apedano.jeecourse.todo.annotations.VehicleTypeQualifier;

@com.apedano.jeecourse.todo.annotations.TruckQualifier
@VehicleTypeQualifier(VehicleTypeQualifier.VehicleType.TRUCK)
public class Truck implements Vehicle {
    @Override
    public String getDescriptionForModel(String model) {
        return String.format("This is a truck of model: %s", model);
    }
}
