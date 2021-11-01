package com.apedano.jeecourse.todo.entity;

import com.apedano.jeecourse.todo.annotations.VehicleTypeQualifier;

@com.apedano.jeecourse.todo.annotations.CarQualifier
@VehicleTypeQualifier(VehicleTypeQualifier.VehicleType.CAR)
public class Car implements Vehicle {
    @Override
    public String getDescriptionForModel(String model) {
        return String.format("This is a car of model: %s", model);
    }
}
