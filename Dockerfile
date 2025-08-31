

FROM eclipse-temurin:21-jdk-jammy AS build
WORKDIR /workspace/app


COPY gradlew .
COPY gradle ./gradle
COPY settings.gradle .
COPY build.gradle .
COPY src ./src

RUN chmod +x gradlew
RUN ./gradlew clean bootJar --no-daemon


FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
RUN useradd -ms /bin/bash appuser
USER appuser

#
COPY --from=build /workspace/app/build/libs/*SNAPSHOT*.jar /app/app.jar


EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
