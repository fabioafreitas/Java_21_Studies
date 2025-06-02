# Stage 1: Build the WAR using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the WAR file
RUN mvn clean package -DskipTests

# Stage 2: Deploy the WAR into Tomcat 9
FROM tomcat:9.0

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR built in previous stage to Tomcat
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose default Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
