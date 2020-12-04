FROM maven:3-openjdk-11-slim AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn jar:jar

FROM openjdk:11-jre-slim
ENV SPRING_PROFILE=default
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/spring-postgres-1.0-SNAPSHOT.jar /app/
ENV PORT 8080
EXPOSE $PORT
ENTRYPOINT ["java","-Dspring.profiles.active=${SPRING_PROFILE}", "-Dserver.port=${PORT}", "-Dapp.start=true", "-jar", "spring-postgres-1.0-SNAPSHOT.jar"]
