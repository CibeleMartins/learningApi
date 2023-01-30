# FROM openjdk:16-jdk-slim
# ARG JAR_FILE=target/*.jar learning-api-java.jar
# COPY ${JAR_FILE} learning-api-java.jar
# RUN bash -c 'touch /learning-api-java.jar'
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom" ,"-jar","/app.jar"]

FROM openjdk:16-jdk-slim
ADD target/*.jar learning-api-java.jar
ENTRYPOINT ["java", "-jar", "learning-api-java.jar"]