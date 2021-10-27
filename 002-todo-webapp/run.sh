#!/bin/sh
mvn clean install
java -jar ../payara-micro-server.jar --deploy target/002-todo-webapp.war --port 8082