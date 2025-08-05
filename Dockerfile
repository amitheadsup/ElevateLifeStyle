# Base image
FROM eclipse-temurin:17-jdk

# Working directory
WORKDIR /app

# Copy the shaded jar and testng.xml
COPY target/admin-automation-1.0-SNAPSHOT.jar .
COPY testng.xml .

# Run TestNG from inside the fat JAR
CMD ["java", "-jar", "admin-automation-1.0-SNAPSHOT.jar", "testng.xml"]
