# Use the official Java base image with JDK 17
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY ./target/demo-0.0.1-SNAPSHOT.jar /app

# Expose the port on which the Spring Boot application listens
EXPOSE 8082

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]

#test ci