# Stage 1: Build the JAR with Lombok and dependencies
FROM eclipse-temurin:17-jdk-alpine AS builder
ARG CACHEBUST=2
WORKDIR /app

# Copy Maven wrapper and pom first (for layer caching)
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY pom.xml .

# Make Maven wrapper executable and download dependencies
RUN chmod +x mvnw && \
    ./mvnw dependency:resolve -DincludeScope=provided && \
    ./mvnw dependency:go-offline -B

# Copy source and build with Lombok
COPY src ./src
RUN ./mvnw clean package -DskipTests -B -U

# Stage 2: Runtime image
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app.jar"]
EXPOSE 8080