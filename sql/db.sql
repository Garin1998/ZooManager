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
    uuid uuid NOT NULL,
    name text
);


ALTER TABLE public.role OWNER TO admin;

--
-- Name: user_in_db; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.user_in_db (
    uuid uuid NOT NULL,
    name text,
    password text,
    email text,
    first_name text,
    last_name text,
    registration_timestamp timestamp without time zone
);


ALTER TABLE public.user_in_db OWNER TO admin;

--
-- Name: user_role; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.user_role (
    user_uuid uuid,
    role_uuid uuid
);


ALTER TABLE public.user_role OWNER TO admin;

--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.role (uuid, name) FROM stdin;
\.


--
-- Data for Name: user_in_db; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.user_in_db (uuid, name, password, email, first_name, last_name, registration_timestamp) FROM stdin;
\.


--
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.user_role (user_uuid, role_uuid) FROM stdin;
\.


--
-- Name: role role_pk; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (uuid);


--
-- Name: user_in_db user_in_db_pk; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.user_in_db
    ADD CONSTRAINT user_in_db_pk PRIMARY KEY (uuid);


--
-- Name: user_role user_role_role_null_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_role_null_fk FOREIGN KEY (role_uuid) REFERENCES public.role(uuid);


--
-- Name: user_role user_role_user_in_db_null_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_user_in_db_null_fk FOREIGN KEY (user_uuid) REFERENCES public.user_in_db(uuid);


--
-- PostgreSQL database dump complete
--

