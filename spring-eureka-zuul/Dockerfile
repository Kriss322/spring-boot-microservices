FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8762 available to the world outside this container
EXPOSE 8762

COPY zuul-0.0.1-SNAPSHOT.jar zuul-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/zuul-0.0.1-SNAPSHOT.jar"]