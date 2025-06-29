FROM eclipse-temurin:21-jdk-alpine

# Instalar dependências
RUN apk add --no-cache \
    git \
    maven \
    bash \
    tini \
    postgresql-client

# Diretório de trabalho
WORKDIR /app

# Clonar o projeto do GitHub
RUN git clone https://github.com/namirso/trabalhoDOCKER.git .

# Entrar no diretório do projeto
WORKDIR /app/trabalhoPOOW1Spring

# Compilar o projeto (sem testes)
RUN mvn clean package -DskipTests

# Criar diretório de logs
RUN mkdir -p /var/log/app
VOLUME ["/var/log/app"]

# Expõe a porta 8080
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "target/trabalhoPOOW1Spring-0.0.1-SNAPSHOT.jar"]
