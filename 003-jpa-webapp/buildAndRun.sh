#!/bin/sh
mvn clean package && docker build -t com.apedano/sample-jpa-jee .
docker rm -f sample-jpa-jee || true && docker run -d -p 9080:9080 -p 9443:9443 --name sample-jpa-jee com.apedano/sample-jpa-jee