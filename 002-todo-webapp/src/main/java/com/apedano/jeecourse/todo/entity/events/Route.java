package com.apedano.jeecourse.todo.entity.events;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    private Airplane airplane;
    private String fromAirport;
    private String toAirport;

}
