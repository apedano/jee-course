package com.apedano.jeecourse.todo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.AUTO;

@Data
@EqualsAndHashCode
@ToString(includeFieldNames = true)
@Slf4j
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @PrePersist
    private void init() {
        log.info("Lifecycle hook init for TODO objects");
        setDateCreated(LocalDate.now());
    }

    private String task;
    private LocalDate dueDate;
    private boolean isCompleted;
    private LocalDate dateCompleted;
    private LocalDate dateCreated;


}
