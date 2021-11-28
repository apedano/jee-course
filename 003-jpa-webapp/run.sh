#!/bin/sh
mvn clean install && java -jar ../payara-micro-server.jar --deploy target/003-jpa-webapp.war --port 8082