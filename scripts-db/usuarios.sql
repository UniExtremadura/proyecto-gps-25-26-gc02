INSERT INTO public.usuario
(id, nombreusuario, nombrereal, contrasenia, correo, descripcion, fecharegistro, rutafoto, esartista)
VALUES
(1,'NewTalent88','Pablo Ruiz','talent88','pablo.ruiz@example.com','Artista debutante.','2025-12-18 19:45:29.37',NULL,true),
(2,'MelodiaFina','Elena Navarro','melodia2024','elena.navarro@example.com','Compositora de música instrumental.','2025-12-18 19:45:49.363',NULL,true),
(3,'JazzSoul','Sara Martín','soulvibes','sara.martin@example.com','Cantante de jazz y soul.','2025-12-18 19:47:46.326',NULL,true),
(4,'UrbanStar','Kevin Romero','urbano2024','kevin.romero@example.com','Artista urbano emergente.','2025-12-18 19:48:23.34',NULL,true),
(5,'ChillZone','Daniel Torres','relax123','daniel.torres@example.com','Escucho música lo-fi para estudiar.','2025-12-18 19:48:36.29',NULL,false),
(6,'ElectroQueen','María Pérez','electro2024','maria.perez@example.com','DJ de música electrónica.','2025-12-18 19:48:46.439',NULL,true),
(7,'RockVibes','Jorge Castillo','rockrules','jorge.castillo@example.com','Guitarrista de rock clásico.','2025-12-18 19:48:57.777',NULL,true),
(8,'ListenerPro','Ana López','contraseñaAna1','ana.lopez@example.com','Amante de la música indie.','2025-12-18 19:49:11.813',NULL,false),
(9,'BeatMaker22','Carlos Méndez','beats2024','carlos.mendez22@example.com','Productor de hip hop y trap.','2025-12-18 19:49:25.717',NULL,true),
(10,'ArtistaDemo01','Lucía Fernández','claveSegura01','lucia.fernandez01@example.com','Cantante de pop alternativo.','2025-12-18 19:49:35.947',NULL,true)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.artista
(idusuario, esnovedad, oyentes, valoracion, idgenero)
VALUES
(1,true,120,3.8,29),
(2,false,900,4.4,30),
(3,false,1500,4.7,28),
(4,true,540,4.0,24),
(6,false,3200,4.9,22),
(7,true,2100,4.8,26),
(9,true,850,4.2,24),
(10,false,1200,4.5,23)
ON CONFLICT (idusuario) DO NOTHING;

-- COLOCAMOS EL ID DONDE QUEREMOS
SELECT setval(
  pg_get_serial_sequence('public.usuario', 'id'),
  (SELECT MAX(id) FROM public.usuario)
);