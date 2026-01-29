# Use official OpenJDK 17 image
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy Maven wrapper, pom, and source code
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Give execution permission to Maven wrapper
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose the port
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "target/assigment-0.0.1-SNAPSHOT.jar"]
