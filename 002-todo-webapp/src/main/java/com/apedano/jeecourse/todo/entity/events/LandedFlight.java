package com.apedano.jeecourse.todo.entity.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LandedFlight extends TakenOffFlight {
    private LocalDateTime landTimestamp;

    public LandedFlight(TakenOffFlight takenOffFlight, LocalDateTime landTimestamp) {
        super(takenOffFlight, takenOffFlight.getTakeOffTimestamp());
        this.landTimestamp = landTimestamp;
    }
}

