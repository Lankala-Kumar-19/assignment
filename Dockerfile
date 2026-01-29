# Use official OpenJDK 17 image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy project contents **flattened** (no nested assignment folder)
COPY assignment/mvnw .
COPY assignment/.mvn .mvn
COPY assignment/pom.xml .
COPY assignment/src src

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the JAR
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the JAR
CMD ["java", "-jar", "target/assigment-0.0.1-SNAPSHOT.jar"]
