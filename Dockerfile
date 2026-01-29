# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file
COPY assignment/target/assignment-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (Render will set PORT env)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
