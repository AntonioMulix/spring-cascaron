--
-- PostgreSQL database dump
--

\restrict vkhjZhtIeviVkxuTkUl5lSlRCEdqOxCsmx70YFLw2aQqZuLxOgefoJAikWAAPqc

-- Dumped from database version 18.1 (Ubuntu 18.1-1.pgdg24.04+2)
-- Dumped by pg_dump version 18.1 (Ubuntu 18.1-1.pgdg24.04+2)

-- Started on 2026-03-10 01:18:50 CST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 16633)
-- Name: admin_log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin_log (
    log_id bigint NOT NULL,
    type character varying(255) NOT NULL,
    operation character varying(255) NOT NULL,
    remote_addr character varying(255) NOT NULL,
    request_uri character varying(255) NOT NULL,
    method character varying(255) NOT NULL,
    params character varying(255),
    operate_date timestamp(6) without time zone NOT NULL,
    user_id integer,
    user_name character varying(255),
    result_params character varying(255) NOT NULL,
    exception_log character varying(255) NOT NULL
);


ALTER TABLE public.admin_log OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16650)
-- Name: admin_log_log_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.admin_log ALTER COLUMN log_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.admin_log_log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 16684)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id_rol bigint NOT NULL,
    name character varying(255) NOT NULL,
    nombre character varying(255)
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16683)
-- Name: roles_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.roles ALTER COLUMN id_rol ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.roles_id_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 224 (class 1259 OID 16720)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id_usuario bigint NOT NULL,
    nombre character varying(255) NOT NULL,
    ap_paterno character varying(255) NOT NULL,
    ap_materno character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    estatus integer NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    email character varying(255)
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16719)
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.usuarios ALTER COLUMN id_usuario ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.usuarios_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 226 (class 1259 OID 16733)
-- Name: usuarios_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios_roles (
    id bigint NOT NULL,
    usuario_id bigint NOT NULL,
    rol_id bigint NOT NULL
);


ALTER TABLE public.usuarios_roles OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16732)
-- Name: usuarios_roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.usuarios_roles ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.usuarios_roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3477 (class 0 OID 16633)
-- Dependencies: 219
-- Data for Name: admin_log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin_log (log_id, type, operation, remote_addr, request_uri, method, params, operate_date, user_id, user_name, result_params, exception_log) FROM stdin;
6	obtuvo lista de todos los  usuarios	listarUsuarios	127.0.1.1	/usuarios/listarUsuarios	GET	\N	2026-03-08 14:59:43.325429	\N	\N	<200 OK OK,OutputEntity(code=200 OK, messages=[Proceso exitoso.], error=0, data=[com.example.cascaron.entity.Usuarios@5fb349c]),[]>	Sin anormalidad
\.


--
-- TOC entry 3480 (class 0 OID 16684)
-- Dependencies: 222
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id_rol, name, nombre) FROM stdin;
1	ROLE_USER	\N
2	ROLE_ADMIN	\N
\.


--
-- TOC entry 3482 (class 0 OID 16720)
-- Dependencies: 224
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id_usuario, nombre, ap_paterno, ap_materno, username, password, estatus, created_at, updated_at, email) FROM stdin;
3	Marco	Romero	Solis	marmulix	$2a$10$W6Ttckl2GcjdQIgu00RmYuW4UaXF/Z/XtPXoTLSRFo7abq0uZN0yq	1	\N	\N	marmulix@gmail.com
\.


--
-- TOC entry 3484 (class 0 OID 16733)
-- Dependencies: 226
-- Data for Name: usuarios_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios_roles (id, usuario_id, rol_id) FROM stdin;
3	3	1
\.


--
-- TOC entry 3490 (class 0 OID 0)
-- Dependencies: 220
-- Name: admin_log_log_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.admin_log_log_id_seq', 6, true);


--
-- TOC entry 3491 (class 0 OID 0)
-- Dependencies: 221
-- Name: roles_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_rol_seq', 2, true);


--
-- TOC entry 3492 (class 0 OID 0)
-- Dependencies: 223
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_usuario_seq', 3, true);


--
-- TOC entry 3493 (class 0 OID 0)
-- Dependencies: 225
-- Name: usuarios_roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_roles_id_seq', 3, true);


--
-- TOC entry 3321 (class 2606 OID 16675)
-- Name: admin_log admin_log_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin_log
    ADD CONSTRAINT admin_log_pkey PRIMARY KEY (log_id);


--
-- TOC entry 3323 (class 2606 OID 16690)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id_rol);


--
-- TOC entry 3325 (class 2606 OID 16731)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 3327 (class 2606 OID 16740)
-- Name: usuarios_roles usuarios_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios_roles
    ADD CONSTRAINT usuarios_roles_pkey PRIMARY KEY (id);


--
-- TOC entry 3328 (class 2606 OID 16780)
-- Name: usuarios_roles roles_id_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios_roles
    ADD CONSTRAINT roles_id_1 FOREIGN KEY (rol_id) REFERENCES public.roles(id_rol) NOT VALID;


--
-- TOC entry 3329 (class 2606 OID 16785)
-- Name: usuarios_roles usuario_id_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios_roles
    ADD CONSTRAINT usuario_id_1 FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id_usuario) NOT VALID;


-- Completed on 2026-03-10 01:18:50 CST

--
-- PostgreSQL database dump complete
--

\unrestrict vkhjZhtIeviVkxuTkUl5lSlRCEdqOxCsmx70YFLw2aQqZuLxOgefoJAikWAAPqc

