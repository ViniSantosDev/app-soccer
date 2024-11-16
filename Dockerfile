# Use a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR da aplicação
COPY target/app-soccer-0.0.1.jar app.jar

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
