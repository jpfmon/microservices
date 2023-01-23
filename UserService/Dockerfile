FROM openjdk:latest
EXPOSE 8082
ARG JAR_FILE=target/UserService-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /appuser.jar
ENTRYPOINT ["java", "-jar", "appuser.jar"]