FROM openjdk:8-jdk-alpine
ADD target/awesome-media-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9999
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]