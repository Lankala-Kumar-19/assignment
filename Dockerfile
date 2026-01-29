# Use official OpenJDK 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the entire assignment folder
COPY assignment assignment

# Make Maven wrapper executable
RUN chmod +x assignment/mvnw

# Build the project using Maven inside the nested folder
RUN ./assignment/mvnw -f assignment/pom.xml clean package -DskipTests

# Expose the port Render will assign
EXPOSE 8080

# Start the app using the correct JAR name
CMD ["java", "-jar", "assignment/target/assignment-0.0.1-SNAPSHOT.jar"]
