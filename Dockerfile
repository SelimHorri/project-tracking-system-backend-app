
FROM openjdk:11
RUN mkdir -p /home/app
WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE=dev
COPY . .
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "target/project-tracking-system-backend-app.jar"]

