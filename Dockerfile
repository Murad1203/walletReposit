FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-alpine
ADD . /src
WORKDIR /src
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/WalletTransaction-0.0.1-SNAPSHOT.jar"]