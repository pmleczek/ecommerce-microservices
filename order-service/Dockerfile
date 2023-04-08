# '--platform=linux/amd64' added for M1 chip compatibility
FROM --platform=linux/amd64 eclipse-temurin:17-jre-alpine
WORKDIR /usr/app
COPY build/libs/*.jar application.jar
RUN addgroup -S spring && adduser -S spring -G spring
USER spring
ENTRYPOINT ["java", "-jar", "application.jar"]