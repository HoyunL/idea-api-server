FROM openjdk:17-oracle
EXPOSE 8080
COPY ./target/idea-api-server-0.0.1-SNAPSHOT.jar /docker-start/idea-api-server-0.0.1-SNAPSHOT.jar
RUN chmod +x /docker-start/idea-api-server-0.0.1-SNAPSHOT.jar
WORKDIR /docker-start
ENTRYPOINT ["java", "-jar", "idea-api-server-0.0.1-SNAPSHOT.jar","-Dfile.encoding=UTF-8"]
