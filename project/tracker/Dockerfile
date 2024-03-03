FROM maven:3.9.6-eclipse-temurin-21-alpine
ENV PROJECT_DIR=/tracker
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR

COPY ./pom.xml $PROJECT_DIR
RUN mvn dependency:resolve

COPY ./src $PROJECT_DIR/src
RUN mvn install -DskipTests

FROM openjdk:21-slim-buster
ENV PROJECT_DIR=/tracker
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=0 $PROJECT_DIR/target/tracker* $PROJECT_DIR/

EXPOSE 8080
CMD ["java", "-jar", "/tracker/tracker-0.0.1-SNAPSHOT.jar"]
