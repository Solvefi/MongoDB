
FROM openjdk:11-jre-slim

COPY target/mongodb-0.0.1-SNAPSHOT.jar /app/MongoDB.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "MongoDB.jar"]
