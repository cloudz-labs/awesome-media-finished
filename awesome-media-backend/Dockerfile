FROM openjdk:8-jdk-alpine
RUN apk add --no-cache curl tar bash
VOLUME /tmp
ADD target/awesome-media-backend-solution-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]