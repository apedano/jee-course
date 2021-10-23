#!/bin/sh
mvn clean package && docker build -t com.apedano.jeecourse/002-todo-webapp .
docker rm -f 002-todo-webapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name 002-todo-webapp com.apedano.jeecourse/002-todo-webapp 
