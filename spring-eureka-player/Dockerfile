FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9401 available to the world outside this container
EXPOSE 9401

COPY player-0.0.1-SNAPSHOT.jar player-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/player-0.0.1-SNAPSHOT.jar"]