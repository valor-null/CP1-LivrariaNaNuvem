
FROM eclipse-temurin:21-jdk-jammy AS build
WORKDIR /workspace/app


COPY gradlew ./
COPY gradle ./gradle
COPY settings.gradle .
COPY build.gradle .


RUN chmod +x gradlew

COPY src ./src


RUN --mount=type=cache,target=/root/.gradle \
    ./gradlew clean bootJar --no-daemon

FROM eclipse-temurin:21-jre-jammy AS runtime

RUN useradd -ms /bin/bash appuser
WORKDIR /app

COPY --from=build /workspace/app/build/libs/*.jar /app/app.jar


EXPOSE 8080

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XX:InitialRAMPercentage=50.0 -Dfile.encoding=UTF-8 -Duser.timezone=UTC"


USER appuser


ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
