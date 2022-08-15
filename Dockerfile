FROM openjdk:11.0.6-jre-slim

COPY target/demo-0.0.1-SNAPSHOT.jar server.jar

EXPOSE 8080

CMD ["java", "-jar", "server.jar"]