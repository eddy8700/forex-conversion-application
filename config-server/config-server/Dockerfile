FROM openjdk:8-jdk-alpine
VOLUME /tmp
# Make port 8761 available to the world outside this container
EXPOSE 8761
ARG JAR_FILE=target/config-server-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} config-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/config-server.jar"]


