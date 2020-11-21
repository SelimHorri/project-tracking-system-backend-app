FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD target/project-tracking-system.jar project-tracking-system.jar
ENTRYPOINT ["java", "-jar", "project-tracking-system.jar"]
