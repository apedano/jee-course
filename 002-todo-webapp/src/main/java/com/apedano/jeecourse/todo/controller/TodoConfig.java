package com.apedano.jeecourse.todo.controller;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api/v1") //--> root path of all restful api endpoints in the application
public class TodoConfig extends Application {
}
