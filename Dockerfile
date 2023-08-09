FROM openjdk:17-alpine
ADD bibliotheque/target/βιβλιοθήκη.jar βιβλιοθήκη.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "βιβλιοθήκη.jar"]