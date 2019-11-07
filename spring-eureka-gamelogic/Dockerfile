FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

COPY Tribes-0.0.1-SNAPSHOT.jar Tribes-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Tribes-0.0.1-SNAPSHOT.jar"]