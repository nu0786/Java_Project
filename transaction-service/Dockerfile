# Use a base image with Java 11
FROM adoptopenjdk/openjdk11

# Set the working directory
RUN mkdir /app
WORKDIR /app
RUN chmod -R 777 /app

# Copy the JAR file to the container
ADD build/libs/*.jar /app/app.jar
# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8080
# Define the command to run your application
CMD ["java", "-jar", "app.jar"]