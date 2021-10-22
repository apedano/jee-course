# Hello world application

### Created with

`mvn archetype:generate -DgroupId=com.apedano.jee -DartifactId=001-hello-world-webapp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false`

### Application JEE dependency

```XML
       <dependency>
         <groupId>javax</groupId>
         <artifactId>javaee-api</artifactId>
         <version>8.0</version>
         <scope>provided</scope>
       </dependency>
```
This means that the application server container will provide the dependency and the implementation for that.

### Deploy an application locally
Once the Payara Micro Server jar file has been downloaded we can build the war of our application and run it:

```shell script
java -jar payara-micro-server.jar --deploy 001-hello-world-webapp.war --port 8081
```

### Create a Docker image with the application server bundle

Create a Dockerfile with the following content

```dockerfile
FROM payara/micro

COPY target/001-hello-world-webapp.war $DEPLOY_DIR
```

and then build the image with

```shell script
docker build -t 001-hello-world-webapp .
```
So we can run the webapp container with

```shell script
http://localhost:8081/001-hello-world-webapp/resources/ping
```

With the response 

```text
Hello world! Enjoy Java EE 8!
```
