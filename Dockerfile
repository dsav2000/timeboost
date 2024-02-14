# Use the official maven/Java 8 image to create a build artifact.
# https://hub.docker.com/_/maven
FROM maven:3.8.3-openjdk-17 as builder

# Set the working directory in docker
WORKDIR /app

# Copy the pom.xml file into the working directory
COPY pom.xml .

# Download all required dependencies into one layer
RUN mvn dependency:go-offline -B

# Copy your source code
COPY src /app/src

# Build the application
RUN mvn clean package

# Use OpenJDK JRE for runtime
FROM eclipse-temurin 

# Set the working directory
WORKDIR /app

# Copy the jar file built in the first stage
COPY --from=builder /app/target/timeboost-api-1.0-SNAPSHOT.jar .

# Expose the port
EXPOSE 8090

# Command to run the application
CMD ["java", "-jar", "timeboost-api-1.0-SNAPSHOT.jar"]

