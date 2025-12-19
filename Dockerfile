# Use OpenJDK 21
FROM eclipse-temurin:21-jdk-jammy

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR from Maven target
COPY target/todo-app-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 3000

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
