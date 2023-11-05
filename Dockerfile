FROM openjdk:17-alpine
COPY ./build/libs/gachon-crpyto-user-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]