package com.apedano.jeecourse.todo.controller;

import com.apedano.jeecourse.todo.entity.Todo;
import com.apedano.jeecourse.todo.service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

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
        Todo output = todoService.createTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("update")
    @PUT
    public Response update(Todo todo) {
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") long id) {
        Todo todo = todoService.findTodoById(id);
        return Response.ok(todo).build();
    }

    @Path("list")
    @GET
    public List<Todo> listTodos() {
        return todoService.getTodos();
    }

}
