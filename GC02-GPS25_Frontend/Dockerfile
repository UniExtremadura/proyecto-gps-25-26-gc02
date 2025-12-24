# 1. Usamos una imagen base de Node (más ligera y rápida que Ubuntu puro)
FROM node:18-alpine

# 2. Directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiamos SOLO los archivos de dependencias primero
# (Esto optimiza la caché de Docker: si no cambias las dependencias, este paso se salta)
# ASUNCIÓN: Tu package.json está dentro de una carpeta llamada 'view' según tu anterior archivo.
COPY view/package.json view/package-lock.json ./

# 4. Instalamos las dependencias
RUN npm install

# 5. Copiamos el resto del código fuente del frontend
COPY view/ .

# 6. Definimos el puerto 3001 como variable de entorno
ENV PORT=3001

# 7. Exponemos el puerto
EXPOSE 3001

# 8. Arrancamos la aplicación
# Host 0.0.0.0 es necesario para que Docker permita conexiones externas
CMD ["npm", "start"]