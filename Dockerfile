FROM openjdk:17
COPY target/kael-0.0.1-SNAPSHOT.jar /app/kael.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "kael.jar"]
EXPOSE 8080