FROM openjdk:8-jdk-alpine
WORKDIR /spring-project
COPY target/node-config-1.0.0.jar node-config-1.0.0.jar
ENTRYPOINT [ "sh","-c","java -DPORT=${PORT}  -jar node-config-1.0.0.jar" ]

