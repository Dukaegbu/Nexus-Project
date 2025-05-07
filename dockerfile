FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/hello-nexus-1.2.0.jar app.jar
EXPOSE 8085
CMD ["java", "-jar", "app.jar"]
