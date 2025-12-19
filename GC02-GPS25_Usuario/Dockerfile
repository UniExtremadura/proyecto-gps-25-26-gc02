#Imagen base
FROM node:18-alpine

# instalar cliente postgres, PSQL ya que no esta en alpine
RUN apk add --no-cache postgresql-client

#Directorio de trabajo
WORKDIR /app

# Copiar dependencias
COPY package*.json ./
RUN npm install

# Copiar el resto del proyecto
COPY . .

# Generar Prisma Client
RUN npx prisma generate

#Puerto expuesto 
EXPOSE 3000

# Arranque
CMD ["npm", "run", "dev"]