FROM eclipse-temurin:21.0.10_7-jre
EXPOSE 8080
ARG JAR_FILE=target/api_backend-0.0.2.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
