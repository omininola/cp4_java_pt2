# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o pom.xml e baixa dependências (cache eficiente)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte e gera o .jar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Runtime (imagem final enxuta)
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório da aplicação
WORKDIR /app

# Copia o .jar gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8082

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]