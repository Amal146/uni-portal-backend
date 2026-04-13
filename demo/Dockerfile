FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN Remove-Item -Recurse -Force .\target
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar  

# Fix: /app/target (pom in root)
EXPOSE $PORT  

# Render uses $PORT
ENTRYPOINT ["java", "-jar", "app.jar"]
