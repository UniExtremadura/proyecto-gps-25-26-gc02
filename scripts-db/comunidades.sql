INSERT INTO comunidades_comunidad (idArtista,nombreComunidad,descComunidad,rutaImagen,fechaCreacion,palabrasVetadas) VALUES
	 (6,'Comunidad Ariana Grande','Esta es la descripción de prueba.',NULL,'2025-12-01 16:04:52.224594','spam,anuncio'),
	 (7,'Comunidad Claudia','Esta es la descripción de prueba.',NULL,'2025-12-01 16:05:49.332188','mew,tongo');

INSERT INTO comunidades_comunidadmiembros (idUsuario,fechaUnion,idComunidad_id) VALUES
	 (6,'2025-12-14 22:15:19.265344',5);

INSERT INTO comunidades_publicacion (titulo,contenido,rutaFichero,fechaPublicacion,idComunidad_id) VALUES
	 ('Esta es mi primera publicación','primerazcvzdvdagvdag',NULL,'2025-12-01 16:50:06.524297',4);
