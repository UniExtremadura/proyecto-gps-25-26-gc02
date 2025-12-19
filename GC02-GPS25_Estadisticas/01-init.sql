--
-- PostgreSQL database dump clean + Nueva tabla historialreproducciones
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';
SET default_table_access_method = heap;

-- ============================================================
-- 1. Tabla: artistasmensual
-- ============================================================
CREATE TABLE public.artistasmensual (
    idartista integer NOT NULL,
    numoyentes bigint DEFAULT 0 NOT NULL,
    valoracionmedia bigint DEFAULT 0 NOT NULL,
    CONSTRAINT artistasmensual_numoyentes_check CHECK ((numoyentes >= 0)),
    CONSTRAINT artistasmensual_numseguidores_check CHECK ((valoracionmedia >= 0))
);

ALTER TABLE public.artistasmensual OWNER TO postgres;

-- ============================================================
-- 2. Tabla: busquedasartistas (con su secuencia)
-- ============================================================
CREATE TABLE public.busquedasartistas (
    id integer NOT NULL,
    idartista integer NOT NULL,
    idusuario integer,
    fecha timestamp without time zone DEFAULT now()
);

ALTER TABLE public.busquedasartistas OWNER TO postgres;

CREATE SEQUENCE public.busquedasartistas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.busquedasartistas_id_seq OWNER TO postgres;
ALTER SEQUENCE public.busquedasartistas_id_seq OWNED BY public.busquedasartistas.id;

ALTER TABLE ONLY public.busquedasartistas ALTER COLUMN id SET DEFAULT nextval('public.busquedasartistas_id_seq'::regclass);

-- ============================================================
-- 3. Tabla: comunidadesmensual
-- ============================================================
CREATE TABLE public.comunidadesmensual (
    idcomunidad integer NOT NULL,
    numpublicaciones bigint DEFAULT 0 NOT NULL,
    nummiembros bigint DEFAULT 0 NOT NULL,
    CONSTRAINT comunidadesmensual_nummiembros_check CHECK ((nummiembros >= 0)),
    CONSTRAINT comunidadesmensual_numpublicaciones_check CHECK ((numpublicaciones >= 0))
);

ALTER TABLE public.comunidadesmensual OWNER TO postgres;

-- ============================================================
-- 4. Tabla: contenidosmensual
-- ============================================================
CREATE TABLE public.contenidosmensual (
    idcontenido integer NOT NULL,
    esalbum boolean NOT NULL,
    sumavaloraciones numeric(2,1) DEFAULT 0 NOT NULL,
    numcomentarios integer DEFAULT 0 NOT NULL,
    numventas bigint DEFAULT 0 NOT NULL,
    genero character varying(35),
    esnovedad boolean DEFAULT false,
    CONSTRAINT contenidosmensual_numcomentarios_check CHECK ((numcomentarios >= 0)),
    CONSTRAINT contenidosmensual_numreproducciones_check CHECK ((numventas >= 0)),
    CONSTRAINT contenidosmensual_sumavaloraciones_check CHECK ((sumavaloraciones >= (0)::numeric))
);

ALTER TABLE public.contenidosmensual OWNER TO postgres;

-- ============================================================
-- 6. NUEVA TABLA: historialreproducciones
-- ============================================================
CREATE TABLE public.historialreproducciones (
    id SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_contenido INT NOT NULL,
    fecha_reproduccion TIMESTAMP DEFAULT NOW(),
    segundos_reproducidos INT DEFAULT 0
);

ALTER TABLE public.historialreproducciones OWNER TO postgres;

-- ============================================================
-- Primary Keys (Resto de tablas)
-- ============================================================

ALTER TABLE ONLY public.artistasmensual
    ADD CONSTRAINT artistasmensual_pkey PRIMARY KEY (idartista);

ALTER TABLE ONLY public.busquedasartistas
    ADD CONSTRAINT busquedasartistas_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.comunidadesmensual
    ADD CONSTRAINT comunidadesmensual_pkey PRIMARY KEY (idcomunidad);

ALTER TABLE ONLY public.contenidosmensual
    ADD CONSTRAINT contenidosmensual_pkey PRIMARY KEY (idcontenido);

INSERT INTO public.artistasmensual (idartista,numoyentes,valoracionmedia) VALUES
	 (13,1500,4),
	 (14,120,3),
	 (15,900,4),
	 (7,850,4),
	 (9,2100,4),
	 (6,1200,4),
	 (10,3200,4),
	 (12,540,4);

INSERT INTO public.busquedasartistas (idartista,idusuario,fecha) VALUES
	 (6,6,'2025-12-01 16:15:16.639435'),
	 (6,6,'2025-12-01 16:30:55.395731'),
	 (7,NULL,'2025-12-01 16:37:07.332136'),
	 (6,NULL,'2025-12-01 16:38:47.819914'),
	 (6,6,'2025-12-01 17:23:52.335239'),
	 (6,NULL,'2025-12-14 21:53:48.444634');

INSERT INTO public.comunidadesmensual (idcomunidad,numpublicaciones,nummiembros) VALUES
	 (4,1,0),
	 (5,0,1);

INSERT INTO public.contenidosmensual (idcontenido,esalbum,sumavaloraciones,numcomentarios,numventas,genero,esnovedad) VALUES
	 (64,false,5.0,1,1,'Flamenco',false),
	 (62,false,0.0,0,2,'Pop',false),
	 (65,false,0.0,0,100,'Kpop',false),
	 (63,false,0.0,0,3,'Pop',false),
	 (61,true,0.0,0,12,'Pop',true);

INSERT INTO public.historialreproducciones (id_usuario,id_contenido,fecha_reproduccion,segundos_reproducidos) VALUES
	 (6,65,'2025-12-01 17:03:58.189928',120),
	 (6,65,'2025-12-01 17:04:11.184845',120),
	 (6,65,'2025-12-01 17:04:11.40521',120),
	 (6,65,'2025-12-01 17:04:11.604923',120),
	 (6,65,'2025-12-01 17:04:11.824809',120),
	 (6,65,'2025-12-01 17:04:12.054821',120),
	 (6,65,'2025-12-01 17:04:12.245006',120),
	 (6,65,'2025-12-01 17:04:12.49483',120),
	 (6,65,'2025-12-01 17:04:12.825019',120),
	 (6,65,'2025-12-01 17:04:13.045099',120);
INSERT INTO public.historialreproducciones (id_usuario,id_contenido,fecha_reproduccion,segundos_reproducidos) VALUES
	 (6,65,'2025-12-01 17:04:13.29507',120),
	 (6,65,'2025-12-01 17:04:13.544837',120),
	 (6,65,'2025-12-01 17:04:13.814978',120),
	 (6,65,'2025-12-01 17:04:14.254834',120),
	 (6,65,'2025-12-01 17:04:14.554955',120),
	 (6,65,'2025-12-01 17:04:14.93491',120),
	 (6,65,'2025-12-01 17:04:15.245013',120),
	 (6,65,'2025-12-01 17:04:15.504833',120),
	 (6,65,'2025-12-01 17:04:15.754786',120),
	 (6,65,'2025-12-01 17:04:16.114986',120);
INSERT INTO public.historialreproducciones (id_usuario,id_contenido,fecha_reproduccion,segundos_reproducidos) VALUES
	 (6,65,'2025-12-01 17:04:16.504973',120),
	 (6,65,'2025-12-01 17:04:16.845152',120),
	 (6,65,'2025-12-01 17:04:17.234977',120),
	 (6,65,'2025-12-01 17:04:17.584868',120),
	 (6,65,'2025-12-01 17:04:18.084768',120),
	 (6,65,'2025-12-01 17:04:18.345468',120),
	 (6,65,'2025-12-01 17:04:18.555016',120),
	 (6,65,'2025-12-01 17:04:18.764944',120),
	 (6,65,'2025-12-01 17:04:19.085059',120),
	 (6,65,'2025-12-01 17:04:19.344801',120);
INSERT INTO public.historialreproducciones (id_usuario,id_contenido,fecha_reproduccion,segundos_reproducidos) VALUES
	 (6,62,'2025-12-01 17:05:15.978053',120),
	 (6,62,'2025-12-01 17:05:43.501913',120),
	 (6,62,'2025-12-01 17:05:43.72177',120),
	 (6,62,'2025-12-01 17:05:43.922059',120),
	 (6,62,'2025-12-01 17:05:44.131845',120),
	 (6,62,'2025-12-01 17:05:44.352775',120),
	 (6,62,'2025-12-01 17:05:44.591811',120),
	 (6,66,'2025-12-01 17:16:05.700901',120),
	 (6,66,'2025-12-01 17:24:18.738762',120),
	 (6,66,'2025-12-01 17:24:34.241301',120);
INSERT INTO public.historialreproducciones (id_usuario,id_contenido,fecha_reproduccion,segundos_reproducidos) VALUES
	 (6,66,'2025-12-01 17:24:34.571506',120),
	 (6,66,'2025-12-01 17:24:34.941616',120),
	 (6,66,'2025-12-01 17:24:35.161491',120),
	 (6,66,'2025-12-01 17:24:35.401636',120),
	 (6,66,'2025-12-01 17:24:35.591407',120),
	 (6,66,'2025-12-01 17:24:35.811623',120),
	 (6,66,'2025-12-01 17:24:36.011455',120),
	 (6,66,'2025-12-01 17:24:36.231383',120),
	 (6,66,'2025-12-01 17:24:37.596683',120),
	 (6,66,'2025-12-01 17:24:58.111549',120);
INSERT INTO public.historialreproducciones (id_usuario,id_contenido,fecha_reproduccion,segundos_reproducidos) VALUES
	 (6,66,'2025-12-01 17:24:58.321357',120),
	 (6,66,'2025-12-01 17:24:58.531421',120),
	 (6,66,'2025-12-01 17:24:58.741401',120),
	 (6,66,'2025-12-01 17:24:58.961468',120),
	 (6,66,'2025-12-01 17:24:59.191433',120),
	 (6,66,'2025-12-01 17:24:59.421378',120),
	 (6,66,'2025-12-01 17:24:59.681672',120),
	 (6,66,'2025-12-01 17:24:59.991449',120),
	 (6,66,'2025-12-01 17:25:00.291474',120),
	 (6,66,'2025-12-01 17:25:00.571864',120);