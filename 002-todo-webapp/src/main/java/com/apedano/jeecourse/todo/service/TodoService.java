package com.apedano.jeecourse.todo.service;

import com.apedano.jeecourse.todo.entity.Todo;
import com.apedano.jeecourse.todo.interceptors.Audit;
import com.apedano.jeecourse.todo.interceptors.CheckMethodParameter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.Interceptors;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional //--> now it is a service
@Slf4j
@RequestScoped
public class TodoService {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
      log.info("******TodoService @PostConstuct method called********");
    }

    @PreDestroy
    public void destroy() {
        log.info("*****TodoService @PreDestroy method called********");
    }

    public Todo createTodo(Todo todo) {
        entityManager.persist(todo);
        return todo;
    }

    public Todo updateTodo(Todo todo) {
        entityManager.merge(todo);
        return todo;
    }

    //Alternative setting
    //@Interceptors({Audit.class, CheckMethodParameter.class})
    @Audit
    @CheckMethodParameter
    public Todo findTodoById(long id) {
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> getTodos() {
        return entityManager
                .createQuery("select t from Todo t", Todo.class)
                .getResultList();
    }
}
