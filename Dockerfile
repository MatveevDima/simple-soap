FROM openjdk:8

WORKDIR /app

ADD target/simple-soap-0.0.1-SNAPSHOT.jar .

CMD ["java", \
"-Duser.timezone=GMT+3:00", \
"-jar", "simple-soap-0.0.1-SNAPSHOT.jar"]