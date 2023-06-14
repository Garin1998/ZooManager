--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2 (Debian 15.2-1.pgdg110+1)
-- Dumped by pg_dump version 15.2 (Debian 15.2-1.pgdg110+1)

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

--
-- Name: role; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.role (
    id uuid NOT NULL,
    name text
);


ALTER TABLE public.role OWNER TO admin;

--
-- Name: user_in_db; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.user_in_db (
    id uuid NOT NULL,
    name text,
    password text,
    registration_timestamp timestamp without time zone
);


ALTER TABLE public.user_in_db OWNER TO admin;

--
-- Name: user_role; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.user_role (
    user_id uuid,
    role_id uuid
);


ALTER TABLE public.user_role OWNER TO admin;

--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.role (id, name) FROM stdin;
78cb5e54-15a9-4c9e-9cd0-ef38089b5104	ROLE_ADMIN
f0754716-f9fd-458c-8074-c606ee3e517c	ROLE_USER
\.


--
-- Data for Name: user_in_db; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.user_in_db (id, name, password, registration_timestamp) FROM stdin;
\.


--
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.user_role (user_id, role_id) FROM stdin;
\.


--
-- Name: role role_pk; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);


--
-- Name: user_in_db user_in_db_pk; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.user_in_db
    ADD CONSTRAINT user_in_db_pk PRIMARY KEY (id);


--
-- Name: user_role user_role_role_null_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_role_null_fk FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- Name: user_role user_role_user_in_db_null_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_user_in_db_null_fk FOREIGN KEY (user_id) REFERENCES public.user_in_db(id);


--
-- PostgreSQL database dump complete
--

