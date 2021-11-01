package com.apedano.jeecourse.todo.controller;

import com.apedano.jeecourse.todo.entity.Todo;
import com.apedano.jeecourse.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class TodoRest {

    /*** FIELD injection point ***/
    @Inject
    private TodoService todoService;

    /**
     * The application doesn't use DTO
     *
     * @param todo
     * @return
     */
    @Path("new")
    @POST
    public Response createTodo(Todo todo) {
        log.info("New endpoint call on the TODO rest API");
        Todo output = todoService.createTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("update")
    @PUT
    public Response update(Todo todo) {
        log.info("update endpoint call on the TODO rest API");
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") long id) {
        log.info("getById endpoint call on the TODO rest API");
        Todo todo = todoService.findTodoById(id);
        return Response.ok(todo).build();
    }

    @Path("list")
    @GET
    public List<Todo> listTodos() {
        log.info("list endpoint call on the TODO rest API");
        return todoService.getTodos();
    }

    @Path("complete")
    @PUT
    public Response markAsComplete(@QueryParam("id") long id) {
        log.info("list endpoint call on the TODO rest API");
        Todo todo = todoService.findTodoById(id);
        if(todo == null) {
            throw new IllegalArgumentException("No todo found with id:" + id);
        }
        todo.setCompleted(true);
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }

}
