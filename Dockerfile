
FROM openjdk:11
RUN mkdir -p /home/app
ENV SPRING_PROFILES_ACTIVE=dev
COPY . /home/app
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "/home/app/target/project-tracking-system.jar"]

