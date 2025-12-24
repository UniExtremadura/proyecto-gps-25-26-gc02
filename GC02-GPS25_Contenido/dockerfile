# --- Etapa 1: Construcción (Build) ---
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el pom.xml y descargamos dependencias para aprovechar la caché de capas de Docker
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente y construimos el jar
COPY src ./src
RUN mvn clean package -DskipTests

# --- Etapa 2: Ejecución (Run) ---
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp

# Copiamos el JAR generado en la etapa anterior
# El nombre se basa en artifactId y version del pom.xml (swagger-spring-1.0.0.jar)
COPY --from=build /app/target/swagger-spring-1.0.0.jar app.jar

# Exponemos el puerto definido en application.properties
EXPOSE 8083

# Comando de inicio
ENTRYPOINT ["java", "-jar", "/app.jar"]