FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9100 available to the world outside this container
EXPOSE 9100

COPY auth-0.0.1-SNAPSHOT.jar auth-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/auth-0.0.1-SNAPSHOT.jar"]