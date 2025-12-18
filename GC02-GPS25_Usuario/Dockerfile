#Imagen base
FROM node:18-alpine

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
