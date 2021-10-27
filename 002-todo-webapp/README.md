# Create

```shell script
mvn archetype:generate -DgroupId=org.example -DartifactId=untitled -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=com.airhacks -DarchetypeArtifactId=javaee8-essentials-archetype -DarchetypeVersion=0.0.4
```

# Build
```shell script
mvn clean package && docker build -t com.apedano.jeecourse/002-todo-webapp .
```

# RUN

```shell script
docker rm -f 002-todo-webapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name 002-todo-webapp com.apedano.jeecourse/002-todo-webapp 
```

### Deploy the application locally
Once the Payara Micro Server jar file has been downloaded we can build the war of our application and run it:
From the application root folder:
```shell script
java -jar ../payara-micro-server.jar --deploy target/002-todo-webapp.war --port 8082
```

In the output:

```shell script
http://host.docker.internal:8082/002-todo-webapp

'002-todo-webapp' REST Endpoints:
GET     /002-todo-webapp/api/v1/application.wadl
GET     /002-todo-webapp/api/v1/todo/list
POST    /002-todo-webapp/api/v1/todo/new
PUT     /002-todo-webapp/api/v1/todo/update
GET     /002-todo-webapp/api/v1/todo/{id}

```