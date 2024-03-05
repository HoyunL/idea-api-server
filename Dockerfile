FROM openjdk:17-oracle
EXPOSE 8080
ARG JAR_FILE=./build/libs/*.jar
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "docker-app-0.0.1-SNAPSHOT.jar"]







