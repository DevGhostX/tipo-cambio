FROM adoptopenjdk/openjdk11:latest
MAINTAINER santiago
ARG JAR_FILE=target/TipoCambio-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} TipoCambio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/TipoCambio-0.0.1-SNAPSHOT.jar"]