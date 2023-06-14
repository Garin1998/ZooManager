FROM maven:3.9.2-amazoncorretto-17 AS build
WORKDIR /app
COPY src src
COPY pom.xml pom.xml
RUN mvn -f pom.xml clean package
FROM amazoncorretto:17.0.5
COPY --from=build app/target/*.jar /zoo-manager.jar
ENTRYPOINT ["java","-jar","/zoo-manager.jar"]