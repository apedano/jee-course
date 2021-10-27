package com.apedano.jeecourse.todo.service;

import com.apedano.jeecourse.todo.entity.Todo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional //--> now it is a service
public class TodoService {

    @PersistenceContext
    private EntityManager entityManager;

    public Todo createTodo(Todo todo) {
        entityManager.persist(todo);
        return todo;
    }

    public Todo updateTodo(Todo todo) {
        entityManager.merge(todo);
        return todo;
    }

    public Todo findTodoById(long id) {
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> getTodos() {
        return entityManager
                .createQuery("select t from Todo t", Todo.class)
                .getResultList();
    }
}
