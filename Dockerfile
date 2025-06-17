FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/apirest_jwt-0.0.1.jar
COPY ${JAR_FILE} apirest_jwt.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "apirest_jwt.jar"]