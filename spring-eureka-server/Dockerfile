FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8761 available to the world outside this container
EXPOSE 8761

COPY server-0.0.1-SNAPSHOT.jar server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/server-0.0.1-SNAPSHOT.jar"]