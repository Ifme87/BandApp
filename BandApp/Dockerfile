
FROM maven:3.8-openjdk-17 as build
ARG VERSION=1.0.0-SNAPSHOT
WORKDIR /app/BandApp

COPY . .
RUN mvn versions:set -DnewVersion=${VERSION} && \
	mvn clean && \
	mvn package


FROM openjdk:17-jdk-slim
ARG VERSION=1.0.0-SNAPSHOT
WORKDIR /app/BandApp

COPY --from=build /app/BandApp/target/bandapp-${VERSION}.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]