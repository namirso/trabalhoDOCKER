FROM eclipse-temurin:21-jdk-alpine

RUN apk add --no-cache \
    git \
    maven \
    bash \
    postgresql-client


WORKDIR /app


RUN git clone https://github.com/namirso/trabalhoDOCKER.git .


WORKDIR /app/trabalhoPOOW1Spring


RUN mvn clean package -DskipTests


RUN mkdir -p /var/log/app
VOLUME ["/var/log/app"]


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "target/trabalhoPOOW1Spring-0.0.1-SNAPSHOT.jar"]
