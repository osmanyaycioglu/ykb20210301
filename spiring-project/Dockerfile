FROM openjdk:8-jdk-alpine
WORKDIR /spring-project
COPY target/spiring-project-1.0.0.jar abc.jar
EXPOSE 9090
ENV BASLA=xyz
ENTRYPOINT [ "sh","-c","java -Dspring.profiles.active=${prof} -jar abc.jar" ]

