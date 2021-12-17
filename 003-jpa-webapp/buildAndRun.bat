@echo off
call mvn clean package
call docker build -t com.apedano/sample-jpa-jee .
call docker rm -f sample-jpa-jee
call docker run -d -p 9080:9080 -p 9443:9443 --name sample-jpa-jee com.apedano/sample-jpa-jee