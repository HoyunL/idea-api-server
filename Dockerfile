FROM openjdk:17-oracle
ARG port
EXPOSE ${port}
COPY ${JAR_FILE} app.jar
ENV docker-app 'Hello, Docker App !'
WORKDIR /usr/local
ENTRYPOINT ["java", "-jar", "docker-app-0.0.1-SNAPSHOT.jar"]







