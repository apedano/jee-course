# Create


```shell script
mvn archetype:generate -DgroupId=org.example -DartifactId=untitled -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=com.airhacks -DarchetypeArtifactId=javaee8-essentials-archetype -DarchetypeVersion=0.0.4
```

# Build
mvn clean package && docker build -t com.apedano.jeecourse/002-todo-webapp .

# RUN

docker rm -f 002-todo-webapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name 002-todo-webapp com.apedano.jeecourse/002-todo-webapp 