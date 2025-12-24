# 📖 Microservicio de Gestión de Contenidos - UnderSounds

Bienvenido al repositorio del microservicio encargado de la gestión de contenidos (textos, imágenes, metadatos, etc.) para la página web **UnderSounds**.

Este microservicio está construido con **Spring Boot**, utiliza **Maven** para la gestión de dependencias y **Oracle Database** como sistema de persistencia.

## 🛠️ Requisitos Previos

Asegúrate de tener instaladas las siguientes herramientas en tu entorno de desarrollo:

  * **Java Development Kit (JDK) 17**: Necesario para compilar y ejecutar la aplicación Spring Boot.
  * **Maven**: Utilizado para la gestión de dependencias y la construcción del proyecto.
  * **Git**: Para clonar y gestionar el código fuente desde GitHub.
  * **Oracle Database**: La base de datos debe estar instalada y accesible.
  * **SQL Developer (o similar)**: Herramienta necesaria para la gestión y ejecución de scripts de base de datos (opcional, pero muy recomendable).

## ⚙️ Configuración de las Variables de Entorno (Maven)

Para poder ejecutar Maven desde cualquier terminal, es necesario añadir su ruta al *path* del sistema.

### 1\. Descargar e Instalar Maven

Asegúrate de haber descargado Apache Maven y descomprimido el archivo en una ubicación estable (ej. `C:\Program Files\Apache\apache-maven-3.9.6`).

### 2\. Configurar la Variable `M2_HOME` (o `MAVEN_HOME`)

Esta variable apunta a la carpeta raíz donde instalaste Maven.

| Sistema Operativo | Pasos |
| :--- | :--- |
| **Windows** | 1. Abre el cuadro de diálogo de Propiedades del Sistema. 2. Ve a **Variables de Entorno**. 3. En **Variables del sistema**, haz clic en **Nueva**. 4. **Nombre de la variable:** `M2_HOME` o `MAVEN_HOME`. 5. **Valor de la variable:** La ruta a tu instalación de Maven (ej. `C:\Program Files\Apache\apache-maven-3.9.6`). |
| **Linux/macOS** | Añade la siguiente línea a tu archivo de *shell* (ej. `~/.bashrc`, `~/.zshrc`):<br> `export M2_HOME="/opt/apache-maven-3.9.6"` |

### 3\. Añadir Maven al `Path`

Ahora, añade la carpeta `bin` de Maven al `Path` del sistema para que los comandos sean reconocidos.

| Sistema Operativo | Pasos |
| :--- | :--- |
| **Windows** | 1. En **Variables de Entorno**, selecciona la variable **Path**. 2. Haz clic en **Editar** y luego en **Nueva**. 3. Añade la ruta: `%M2_HOME%\bin` |
| **Linux/macOS** | Añade la siguiente línea a tu archivo de *shell*:<br> `export PATH="$PATH:$M2_HOME/bin"` |

### 4\. Verificar la Instalación

Abre una **nueva** ventana de terminal o consola y ejecuta el siguiente comando:

```bash
mvn -v
```

Si la instalación fue exitosa, verás la versión de Apache Maven y de Java que se está utilizando, confirmando que puedes proceder con la compilación del microservicio.

## 🚀 Instalación y Configuración

### 1\. Clonar el Repositorio

Utiliza `git` para clonar el proyecto desde GitHub.

```bash
git clone https://github.com/AdaXiang/GC02-GPS25_Contenido.git
cd GC02-GPS25_Contenido
```

### 2\. Configuración de la Base de Datos Oracle

#### a. Generación Automática del Esquema
El proyecto utiliza Spring Data JPA y la propiedad spring.jpa.hibernate.ddl-auto=update configurada. Esto significa que el esquema de la base de datos se creará o actualizará automáticamente basándose en las clases @Entity al iniciar la aplicación, por lo que no se requiere la ejecución manual de scripts DDL (Data Definition Language).

#### b. Actualizar Propiedades

El microservicio se conecta a la base de datos a través del archivo de configuración de Spring Boot.

1.  Abre el archivo: `src/main/resources/application.properties`.

2.  Actualiza las siguientes propiedades de conexión con los detalles de tu base de datos Oracle:

    ```properties
    # Ejemplo para application.properties
      springdoc.api-docs.path=/api-docs
      server.servlet.contextPath=/api
      server.port=8080
      spring.jackson.date-format=io.swagger.RFC3339DateFormat
      spring.jackson.serialization.WRITE_DATES_AS_TIMESTAMPS=false

      # --- DATASOURCE (¡REEMPLAZAR ESTOS VALORES!) ---
      spring.datasource.url=jdbc:oracle:thin:@servidor.basedatos.com:1521/PRODDB
      spring.datasource.username=USUARIO_CONTENIDO
      spring.datasource.password=password_secreta_123
      spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

      # --- JPA / HIBERNATE ---
      spring.jpa.database-platform=org.hibernate.dialect.Oracle12cDialect
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
    ```

### 3\. Compilar y Ejecutar

Utiliza Maven para construir el proyecto y ejecutar la aplicación Spring Boot.

#### a. Compilar

Ejecuta el siguiente comando para descargar dependencias y compilar el proyecto:

```bash
mvn clean install
```

#### b. Ejecutar el Microservicio

Una vez que la compilación es exitosa, puedes ejecutar el microservicio directamente:

```bash
mvn spring-boot:run
```

O, si prefieres ejecutar el JAR generado:

```bash
java -jar target/underSounds-Contenido-0.0.1-SNAPSHOT.jar
```

## ✅ Verificación

Una vez que la aplicación se esté ejecutando (`http://localhost:8080`), puedes verificar su estado o acceder a los *endpoints* definidos.

  * Consulta la documentación de la API (Swagger UI) para ver los *endpoints* de gestión de contenidos.

## 📂 Estructura del Proyecto

El proyecto sigue una estructura de paquetes estándar para aplicaciones Spring Boot, utilizando la segregación de responsabilidades:

| Paquete | Descripción |
| :--- | :--- |
| `api` | Contiene interfaces o clases relacionadas con la definición de la **API** y los modelos generados automáticamente, a menudo usados por la documentación (Swagger/OpenAPI). |
| `configuration` | Almacena clases de **configuración** de Spring, como la configuración de seguridad (`WebSecurityConfig`), *beans* personalizados, o *config* de Swagger/OpenAPI. |
| `controllers` | Contiene los **controladores REST** (`@RestController`). Estas clases manejan las peticiones HTTP entrantes, llaman a la capa de servicios y devuelven las respuestas. |
| `entity` | Define las clases **Entity** de JPA (`@Entity`). Representan las tablas de la base de datos (Oracle) y son la capa de persistencia directa. |
| `model` | Contiene las clases **Model** o DTO (Data Transfer Object). Estas clases se usan a menudo para la **entrada y salida** de datos en los controladores, separando la estructura de la base de datos de la estructura de la API. |
| `repository` | Incluye las interfaces **Repository** (`JpaRepository`). Son responsables de la comunicación directa con la base de datos (CRUD), sin lógica de negocio. |
| `services` | Contiene la lógica de **negocio** (`@Service`). Implementa las operaciones complejas y transaccionales, utilizando los *repositories* para la manipulación de datos. |


