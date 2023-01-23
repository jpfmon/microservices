FROM openjdk:latest
EXPOSE 8080
ARG JAR_FILE=target/PostService-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /apppost.jar
ENTRYPOINT ["java", "-jar", "apppost.jar"]