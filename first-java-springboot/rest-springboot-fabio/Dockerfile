FROM openjdk:17-oracle
MAINTAINER github/FabioDevGomes
COPY ./target/rest-springboot-fabio-1-0.0.1-SNAPSHOT.jar /app/rest-springboot-fabio-1-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "rest-springboot-fabio-1-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

