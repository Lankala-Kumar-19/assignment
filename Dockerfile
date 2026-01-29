# Use official OpenJDK image with specific tag for stability
FROM openjdk:17-slim

WORKDIR /app

# Copy jar from assignment/target since your jar is inside that folder
COPY assignment/target/assignment-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
