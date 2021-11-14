package com.apedano.jeecourse.todo.entity.events;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TakenOffFlight extends Flight {
    private LocalDateTime takeOffTimestamp;

    public TakenOffFlight(Flight flight, LocalDateTime takeOffTimestamp) {
        super(flight.getRoute());
        this.takeOffTimestamp = takeOffTimestamp;
    }
}
