package com.apedano.jeecourse.todo.entity.events;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private Route route;
}
