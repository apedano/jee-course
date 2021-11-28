# Build
mvn clean package && docker build -t com.apedano/003-jpa-webapp .

# RUN

docker rm -f 003-jpa-webapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name 003-jpa-webapp com.apedano/003-jpa-webapp


####Deploy H2 embedded  datasource in payara server 
https://blog.payara.fish/deploying-data-source-configuration 