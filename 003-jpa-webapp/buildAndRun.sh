#!/bin/sh
mvn clean package && docker build -t com.apedano/003-jpa-webapp .
docker rm -f 003-jpa-webapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name 003-jpa-webapp com.apedano/003-jpa-webapp 
