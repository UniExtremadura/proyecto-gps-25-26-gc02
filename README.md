# 🎵 UnderSound

**UnderSound** es un sistema basado en una **arquitectura de microservicios**, diseñado para gestionar usuarios, contenido, comunidades y estadísticas dentro de una plataforma moderna y escalable.  
Este repositorio centraliza la configuración y el despliegue completo del sistema utilizando **Docker** y **Docker Compose**.

---

## 📌 Descripción General

El sistema **UnderSound** está compuesto por **cinco microservicios independientes**, cada uno con su propia responsabilidad, tecnología y base de datos.  
El despliegue se realiza de forma unificada mediante **Docker Compose**, permitiendo levantar todo el ecosistema de manera sencilla y reproducible.

---

## 🧩 Arquitectura de Microservicios

| Microservicio | Tecnología Backend | Base de Datos | Descripción |
|---------------|-------------------|---------------|-------------|
| 👤 **Usuarios** | Node.js (Express) | PostgreSQL | Gestión de usuarios, autenticación y perfiles. |
| 🎼 **Contenido** | Spring Boot (Java) | Oracle | Administración del contenido multimedia. |
| 📊 **Estadísticas** | Python (FastAPI) | PostgreSQL | Recolección y análisis de métricas del sistema. |
| 👥 **Comunidades** | Python (Django) | MySQL | Gestión de comunidades, interacciones y grupos. |
| 🌐 **Frontend** | React | — | Interfaz de usuario del sistema UnderSound. |

---

## 🐳 Despliegue con Docker

El proyecto utiliza **Docker** para garantizar consistencia entre entornos y facilitar el despliegue del sistema completo.

### 🔧 Estructura de Docker

- En el **directorio raíz** del repositorio se encuentra el archivo:
  - `docker-compose.yml`
- Cada microservicio cuenta con:
  - Su propio **Dockerfile**
  - Configuración independiente de dependencias y entorno

---

### 🚀 Ejecución del Proyecto

Para levantar todo el sistema:

```bash
docker-compose up --build
```

Este comando:
- Construye las imágenes de cada microservicio
- Inicializa las bases de datos
- Levanta todos los contenedores necesarios

---

## 🗄 Inicialización de Bases de Datos

Cada microservicio es responsable de su propia base de datos, incluyendo:

- **Creación automática de tablas**
- **Inserción de datos iniciales**

Esto garantiza que, al desplegar el sistema:
- Las bases de datos **no estén vacías**
- El sistema sea funcional desde el primer inicio sin configuración manual adicional

---

## 👥 Roles del Proyecto

| Rol | Responsable | Descripción |
|----|------------|-------------|
| 🧑‍💼 **Product Owner** | Jose Nogales | Define la visión, prioriza el backlog y representa la voz del cliente. |
| 🧑‍💻 **Lead Tech** | Manuel Solis | Toma decisiones técnicas y asegura la calidad de la arquitectura. |
| 🧪 **DevOps / QA** | Rina Hodge | Automatiza procesos, gestiona CI/CD y garantiza la calidad del software. |
| 🧭 **Scrum Master** | Ada Xiang Ramos | Facilita las ceremonias Scrum y elimina impedimentos. |
| 👩‍💻 **Developer** | Milagros Tejado | Implementa funcionalidades y corrige errores. |

---

## ✅ Características Clave

- Arquitectura de microservicios desacoplada
- Uso de múltiples tecnologías según la responsabilidad del servicio
- Despliegue unificado con Docker Compose
- Inicialización automática de bases de datos
- Sistema listo para pruebas desde el primer arranque
