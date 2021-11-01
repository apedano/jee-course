package com.apedano.jeecourse.todo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotEmpty(message = "Task must be set") //-> Uses Bean validation API
    @Size(min = 10, message="Task should not be less than 10 characters long")
    private String task;

    @NotNull(message = "Due date must be set") //-> Uses Bean validation API
    @FutureOrPresent(message = "The due date cannot be in the past")
    @JsonbDateFormat(value="yyyy-MM-dd")
    private LocalDate dueDate;
    private boolean isCompleted;
    private LocalDate dateCompleted;
    private LocalDate dateCreated;


}
