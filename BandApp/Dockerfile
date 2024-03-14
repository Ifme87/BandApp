# Used Java image 
FROM amazoncorretto:8-alpine3.17-jre

# Create user & group
RUN addgroup -S app && adduser -S app -G app

# Use user "app"
USER app

# Copy jar file into the docker image
COPY target/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]