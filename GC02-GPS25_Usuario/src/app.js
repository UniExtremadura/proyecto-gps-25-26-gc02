/**
 * @file app.js
 */
import express from 'express';
import cors from 'cors';
import dotenv from 'dotenv';
import swaggerUi from "swagger-ui-express";
import swaggerDocument from "./config/swagger.js";

import usuarioRoutes from './routes/usuario.routes.js';
import artistaRoutes from './routes/artista.routes.js';
import favoritoRoutes from './routes/favorito.routes.js';
import cestaRoutes from './routes/cesta.routes.js';
import deseaRoutes from './routes/desea.routes.js';
import compradoRoutes from './routes/comprado.routes.js';

dotenv.config(); 

const app = express();

// --- INICIO DEL CAMBIO ---

// 1. Comenta o borra tu configuración anterior que estaba fallando:
/* const allowedOrigins = [
  process.env.PORT_CORS || "http://localhost:3001",
  "http://127.0.0.1:3001"
];

app.use(cors({
  origin: allowedOrigins,
  credentials: true
}));
*/

// 2. Agrega esta línea sencilla. 
// Esto permite que CUALQUIER origen (localhost:3001, postman, móvil, etc.) acceda.
app.use(cors());

// --- FIN DEL CAMBIO ---

console.log('DB URL:', process.env.DATABASE_URL); 

app.use(express.json()); 

app.use('/api/usuarios/artistas', artistaRoutes);
app.use('/api/usuarios/favoritos', favoritoRoutes);
app.use('/api/usuarios/cesta', cestaRoutes);
app.use('/api/usuarios/desea', deseaRoutes);
app.use('/api/usuarios/tiene', compradoRoutes);

app.use('/api/usuarios', usuarioRoutes);

app.use('/api/docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

export default app;