FROM eclipse-temurin:21-jdk-alpine

Install build tools and PostgreSQL client
RUN apk add --no-cache \
    git \
    maven \
    bash \
    tini \
    postgresql-client

WORKDIR /app

Clone repository
RUN git clone https://github.com/namirso/trabalho-docker.git ./

WORKDIR /app/trabalhoPOOW1Spring

Build application
RUN mvn clean package -DskipTests

Create log directory
VOLUME ["/var/log/app"]
RUN mkdir -p /var/log/app

Application entry point
ENTRYPOINT ["java", "-jar", "target/trabalhoPOOW1Spring-0.0.1-SNAPSHOT.jar"]
