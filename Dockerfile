# Use official OpenJDK 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper, pom, and source code from the assignment folder
COPY assignment/mvnw .
COPY assignment/.mvn .mvn
COPY assignment/pom.xml .
COPY assignment/src src

# Give execution permission to Maven wrapper
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose the port Render will assign
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "target/assigment-0.0.1-SNAPSHOT.jar"]
