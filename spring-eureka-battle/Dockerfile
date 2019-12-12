FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9302 available to the world outside this container
EXPOSE 9302

COPY battle-0.0.1-SNAPSHOT.jar battle-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/battle-0.0.1-SNAPSHOT.jar"]