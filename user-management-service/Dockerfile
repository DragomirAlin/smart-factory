# Use the official OpenJDK 21 base image
FROM azul/zulu-openjdk:21
# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container at /app
COPY target/*.jar /app/user-management-service.jar

# Expose the port that the application will run on
EXPOSE 8081

# Run the jar file
CMD ["java", "-jar", "user-management-service.jar"]
