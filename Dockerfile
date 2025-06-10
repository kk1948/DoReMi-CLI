# Use a lightweight Java 21 image
FROM openjdk:21-jdk-slim

# Set working directory in the container
WORKDIR /app

# Copy the built JAR file from IntelliJ to the container
COPY out/artifacts/DoReMiSubscriptionManager_jar/DoReMiSubscriptionManager.jar DoReMiSubscriptionManager.jar

# Run the Java CLI app by default
CMD ["java", "-jar", "DoReMiSubscriptionManager.jar"]
