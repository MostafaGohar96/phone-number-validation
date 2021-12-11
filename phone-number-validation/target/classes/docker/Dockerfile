FROM openjdk:8
EXPOSE 8013
ADD phone-number-validation-service.jar phone-number-validation-service.jar
COPY settings.properties settings.properties
COPY application-development.properties application-development.properties
COPY sample.db sample.db
ENTRYPOINT ["java", "-Dspring.profiles.active=development", "-jar", "phone-number-validation-service.jar"]
