FROM openjdk:8-jdk-alpine
WORKDIR /spring-project
COPY target/node-discovery-1.0.0.jar node-discovery-1.0.0.jar
EXPOSE 9090
ENV BASLA=xyz
ENTRYPOINT [ "sh","-c","java  -jar node-discovery-1.0.0.jar" ]

