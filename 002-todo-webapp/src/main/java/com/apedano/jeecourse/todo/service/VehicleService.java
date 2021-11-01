package com.apedano.jeecourse.todo.service;

import com.apedano.jeecourse.todo.annotations.CarQualifier;
import com.apedano.jeecourse.todo.annotations.MyService;
import com.apedano.jeecourse.todo.annotations.TruckQualifier;
import com.apedano.jeecourse.todo.annotations.VehicleTypeQualifier;
import com.apedano.jeecourse.todo.annotations.VehicleTypeQualifier.VehicleType;
import com.apedano.jeecourse.todo.entity.Vehicle;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import static com.apedano.jeecourse.todo.annotations.VehicleTypeQualifier.VehicleType.*;

@MyService
public class VehicleService {

    @Inject
    @CarQualifier
    @VehicleTypeQualifier(value = CAR)
    private Vehicle car;

    @Inject
    @TruckQualifier
    @VehicleTypeQualifier(value = TRUCK)
    private Vehicle truck;

    @Inject
    Logger logger;

    public String getDescription(String type, String model) {
        logger.info("getDescription method called");
        switch (type) {
            case "car":
                return car.getDescriptionForModel(model);
            case "truck":
                return truck.getDescriptionForModel(model);
            default:
                throw new IllegalArgumentException(String.format("Not recognized type:%s", type));
        }
    }

}
