FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9200 available to the world outside this container
EXPOSE 9200

COPY spring-eureka-common-0.0.1-SNAPSHOT.jar spring-eureka-common-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-eureka-common-0.0.1-SNAPSHOT.jar"]