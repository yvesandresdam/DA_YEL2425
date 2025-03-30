--
-- PostgreSQL database dump
--

-- Dumped from database version 12.16 (Ubuntu 12.16-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.16 (Ubuntu 12.16-0ubuntu0.20.04.1)

-- Started on 2023-10-17 16:23:30 UTC

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
-- TOC entry 202 (class 1259 OID 18125)
-- Name: airlines; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.airlines (
    airlineid character varying(3) NOT NULL,
    name character varying(50) NOT NULL,
    shortcode character varying(3)
);


ALTER TABLE public.airlines OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 18128)
-- Name: airports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.airports (
    code character varying(4) NOT NULL,
    name character varying(100) NOT NULL,
    city character varying(3) NOT NULL
);


ALTER TABLE public.airports OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 18131)
-- Name: cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cities (
    code character varying(3) NOT NULL,
    name character varying(15) NOT NULL,
    state character varying(15) NOT NULL,
    country character varying(30) NOT NULL
);


ALTER TABLE public.cities OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 18134)
-- Name: contains; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contains (
    airlineid character varying(3) NOT NULL,
    airportid character varying(4) NOT NULL,
    code integer NOT NULL
);


ALTER TABLE public.contains OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 18137)
-- Name: contains_code_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contains_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contains_code_seq OWNER TO postgres;

--
-- TOC entry 2991 (class 0 OID 0)
-- Dependencies: 206
-- Name: contains_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contains_code_seq OWNED BY public.contains.code;


--
-- TOC entry 207 (class 1259 OID 18139)
-- Name: flights; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.flights (
    flight_code character varying(10) NOT NULL,
    source character varying(4) NOT NULL,
    destination character varying(4) NOT NULL,
    arrival character varying(10) NOT NULL,
    departure character varying(10) NOT NULL,
    status character varying(10),
    duration integer,
    flight_type character varying(10),
    layover_time integer,
    no_of_stops integer,
    airlineid character varying(3) NOT NULL,
    seats integer
);


ALTER TABLE public.flights OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 18142)
-- Name: passengers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.passengers (
    passportno character varying(10) NOT NULL,
    firstname character varying(20) NOT NULL,
    lastname character varying(20) NOT NULL,
    address character varying(100),
    phone character varying(12),
    sex character varying(1)
);


ALTER TABLE public.passengers OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 18145)
-- Name: tickets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tickets (
    ticket_number integer NOT NULL,
    date_of_booking date NOT NULL,
    date_of_travel date NOT NULL,
    date_of_cancellation date,
    passportno character varying(10) NOT NULL,
    flight_code character varying(10) NOT NULL,
    price integer
);


ALTER TABLE public.tickets OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 18148)
-- Name: ticket1_ticket_number_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ticket1_ticket_number_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ticket1_ticket_number_seq OWNER TO postgres;

--
-- TOC entry 2992 (class 0 OID 0)
-- Dependencies: 210
-- Name: ticket1_ticket_number_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ticket1_ticket_number_seq OWNED BY public.tickets.ticket_number;


--
-- TOC entry 2824 (class 2604 OID 18150)
-- Name: contains code; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contains ALTER COLUMN code SET DEFAULT nextval('public.contains_code_seq'::regclass);


--
-- TOC entry 2825 (class 2604 OID 18151)
-- Name: tickets ticket_number; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tickets ALTER COLUMN ticket_number SET DEFAULT nextval('public.ticket1_ticket_number_seq'::regclass);


--
-- TOC entry 2977 (class 0 OID 18125)
-- Dependencies: 202
-- Data for Name: airlines; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.airlines (airlineid, name, shortcode) VALUES ('AA', 'American Airlines', '001');
INSERT INTO public.airlines (airlineid, name, shortcode) VALUES ('AI', 'Air India Limited', '098');
INSERT INTO public.airlines (airlineid, name, shortcode) VALUES ('LH', 'Lufthansa', '220');
INSERT INTO public.airlines (airlineid, name, shortcode) VALUES ('BA', 'British Airways', '125');
INSERT INTO public.airlines (airlineid, name, shortcode) VALUES ('QR', 'Qatar Airways', '157');
INSERT INTO public.airlines (airlineid, name, shortcode) VALUES ('9W', 'Jet Airways', '589');
INSERT INTO public.airlines (airlineid, name, shortcode) VALUES ('EK', 'Emirates', '176');
INSERT INTO public.airlines (airlineid, name, shortcode) VALUES ('EY', 'Ethiad Airways', '607');


--
-- TOC entry 2978 (class 0 OID 18128)
-- Dependencies: 203
-- Data for Name: airports; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.airports (code, name, city) VALUES ('LIA', 'Louisville International Airport', 'LOU');
INSERT INTO public.airports (code, name, city) VALUES ('CHIA', 'Chandigarh International Airport', 'CHA');
INSERT INTO public.airports (code, name, city) VALUES ('DFWI', 'Dallas/Fort Worth International Airport', 'FW');
INSERT INTO public.airports (code, name, city) VALUES ('IGIA', 'Indira GandhiInternational Airport', 'DEL');
INSERT INTO public.airports (code, name, city) VALUES ('CSIA', 'Chhatrapati Shivaji International Airport', 'MUM');
INSERT INTO public.airports (code, name, city) VALUES ('SFIA', 'San Francisco International Airport', 'SFR');
INSERT INTO public.airports (code, name, city) VALUES ('FKFI', 'Frankfurt Airport', 'FKF');
INSERT INTO public.airports (code, name, city) VALUES ('GBIA', 'George Bush Intercontinental Airport', 'HOU');
INSERT INTO public.airports (code, name, city) VALUES ('JFKI', 'John F. Kennedy International Airport', 'NYC');
INSERT INTO public.airports (code, name, city) VALUES ('TIA', 'Tampa International Airport', 'TMP');


--
-- TOC entry 2979 (class 0 OID 18131)
-- Dependencies: 204
-- Data for Name: cities; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cities (code, name, state, country) VALUES ('LOU', 'Louisville', 'Kentucky', 'United States');
INSERT INTO public.cities (code, name, state, country) VALUES ('CHA', 'Chandigarh', 'Chandigarh', 'India');
INSERT INTO public.cities (code, name, state, country) VALUES ('FW', 'Fort Worth', 'Texas', 'United States');
INSERT INTO public.cities (code, name, state, country) VALUES ('DEL', 'Delhi', 'Delhi', 'India');
INSERT INTO public.cities (code, name, state, country) VALUES ('MUM', 'Mumbai', 'Maharashtra', 'India');
INSERT INTO public.cities (code, name, state, country) VALUES ('SFR', 'San Francisco', 'California', 'United States');
INSERT INTO public.cities (code, name, state, country) VALUES ('FKF', 'Frankfurt', 'Hesse', 'Germany');
INSERT INTO public.cities (code, name, state, country) VALUES ('HOU', 'Houston', 'Texas', 'United States');
INSERT INTO public.cities (code, name, state, country) VALUES ('NYC', 'New York City', 'New York', 'United States');
INSERT INTO public.cities (code, name, state, country) VALUES ('TMP', 'Tampa', 'Florida', 'United States');


--
-- TOC entry 2980 (class 0 OID 18134)
-- Dependencies: 205
-- Data for Name: contains; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AA', 'LIA', 1);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AA', 'JFKI', 2);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AA', 'GBIA', 3);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AA', 'SFIA', 4);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AA', 'TIA', 5);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AI', 'CHIA', 6);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AI', 'DFWI', 7);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AI', 'IGIA', 8);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AI', 'CSIA', 9);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('AI', 'GBIA', 10);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('LH', 'CHIA', 11);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('LH', 'FKFI', 12);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('LH', 'JFKI', 13);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('LH', 'SFIA', 14);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('LH', 'DFWI', 15);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('BA', 'JFKI', 16);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('BA', 'CSIA', 17);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('BA', 'CHIA', 18);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('BA', 'FKFI', 19);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('BA', 'SFIA', 20);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('QR', 'CSIA', 21);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('QR', 'DFWI', 22);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('QR', 'JFKI', 23);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('QR', 'TIA', 24);
INSERT INTO public.contains (airlineid, airportid, code) VALUES ('QR', 'LIA', 25);


--
-- TOC entry 2982 (class 0 OID 18139)
-- Dependencies: 207
-- Data for Name: flights; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('QR2305', 'CSIA', 'DFWI', '13:00', '13:55', 'Delayed', 21, 'Non-stop', 0, 0, 'QR', 150);
INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('EY1234', 'JFKI', 'TIA', '19:20', '20:05', 'On-time', 16, 'Connecting', 5, 2, 'EY', 150);
INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('BA3056', 'CSIA', 'DFWI', '02:15', '02:55', 'On-time', 29, 'Connecting', 3, 1, 'BA', 100);
INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('QR1902', 'LIA', 'GBIA', '22:00', '22:50', 'Delayed', 28, 'Non-stop', 0, 1, 'QR', 75);
INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('AI2014', 'CSIA', 'DFWI', '02:10', '03:15', 'On-time', 24, 'Connecting', 3, 1, 'AI', 50);
INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('LH9876', 'JFKI', 'CSIA', '05:50', '06:35', 'On-time', 18, 'Non-stop', 0, 0, 'LH', 50);
INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('9W2334', 'GBIA', 'IGIA', '23:00', '13:45', 'On-time', 23, 'Non-stop', 0, 0, '9W', 150);
INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('EK3456', 'CSIA', 'SFIA', '18:50', '19:40', 'On-time', 30, 'Non-stop', 0, 0, 'EK', 150);
INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('AA4367', 'SFIA', 'FKFI', '18:10', '18:55', 'On-time', 21, 'Non-stop', 0, 0, 'AA', 200);
INSERT INTO public.flights (flight_code, source, destination, arrival, departure, status, duration, flight_type, layover_time, no_of_stops, airlineid, seats) VALUES ('BA1689', 'FKFI', 'IGIA', '10:20', '10:55', 'On-time', 14, 'Non-stop', 0, 0, 'BA', 100);


--
-- TOC entry 2983 (class 0 OID 18142)
-- Dependencies: 208
-- Data for Name: passengers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('A1122334', 'MANAN', 'LAKHANI', '5589 CHTHAM REFLECTIONS, APT 349 HOUSTON, TX', '900433512', 'F');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('A1234568', 'ALEN', 'SMITH', '2230 NORTHSIDE, APT 11, ALBANY, NY', '808036729', 'M');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('B8765430', 'LAKSHMI', 'SHARMA', '1110 FIR HILLS, APT 903, AKRON, OH', '766619050', 'F');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('B9876541', 'ANKITA', 'AHIR', '3456 VIKAS APTS, APT 102,DOMBIVLI, INDIA', '808036728', 'F');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('C2345698', 'KHYATI', 'MISHRA', '7820 MCCALLUM COURTS, APT 234, AKRON, OH', '808226728', 'F');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('D1002004', 'ANKITA', 'PATIL', '7720 MCCALLUM BLVD, APT 1082, DALLAS, TX', '908036726', 'F');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('E3277889', 'John', 'GATES', '1234 BAKER APTS, APT 59, HESSE, GERMANY', '972456998', 'M');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('J9801235', 'AKHILESH', 'JOSHI', '345 CHATHAM COURTS, APT 678, MUMBAI, INDIA', '908036929', 'M');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('K3212322', 'SARA', 'GOMES', '6785 SPLITSVILLA, APT 34, MIAMI, FL', '902456922', 'F');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('P3452390', 'ALIA', 'BHAT', '548 MARKET PLACE, SAN Francisco, CA', '973456780', 'F');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('Q1243567', 'KARAN', 'MOTANI', '4444 FRANKFORD VILLA, APT 77, GUILDERLAND, NY', '972762664', 'M');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('R8990566', 'RIA', 'GUPTA', '3355 PALENCIA, APT 2065, MUMBAI, INDIA', '472451234', 'M');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('S1243269', 'ROM', 'SOLANKI', '7720 MCCALLUM BLVD, APT 2087, DALLAS, TX', '900456890', 'M');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('W7543336', 'JOHN', 'SMITH', '6666 ROCK HILL, APT 2902, TAMPA, FL', '462456998', 'M');
INSERT INTO public.passengers (passportno, firstname, lastname, address, phone, sex) VALUES ('X9324666', 'TEJASHREE', 'PANDIT', '9082 ESTAES OF RICHARDSON, RICHARDSON, TX', '900436012', 'F');


--
-- TOC entry 2984 (class 0 OID 18145)
-- Dependencies: 209
-- Data for Name: tickets; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (1, '2016-05-11', '2016-12-15', NULL, 'A1234568', 'AI2014', 95000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (2, '2016-06-11', '2016-12-20', '2016-12-10', 'B9876541', 'LH9876', 100000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (3, '2016-08-21', '2016-12-25', NULL, 'C2345698', '9W2334', 200000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (4, '2016-08-10', '2017-01-12', NULL, 'D1002004', 'QR1902', 150000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (5, '2016-06-13', '2016-12-10', NULL, 'X9324666', 'EY1234', 98000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (6, '2016-11-11', '2017-02-12', NULL, 'B8765430', 'BA3056', 125000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (7, '2016-11-15', '2016-12-25', NULL, 'J9801235', '9W2334', 195000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (8, '2016-10-15', '2016-12-18', NULL, 'A1122334', 'AA4367', 170000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (9, '2016-11-12', '2016-12-30', NULL, 'Q1243567', 'QR1902', 140000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (10, '2016-01-22', '2016-12-15', NULL, 'S1243269', 'EK3456', 45000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (11, '2016-10-19', '2016-12-31', NULL, 'E3277889', 'BA1689', 100000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (12, '2016-11-20', '2017-01-12', NULL, 'K3212322', 'QR1902', 120000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (13, '2016-05-13', '2016-12-15', '2016-05-25', 'P3452390', 'AI2014', 65000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (14, '2016-06-26', '2016-12-23', NULL, 'W7543336', 'BA1689', 80000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (15, '2016-08-11', '2016-12-22', NULL, 'R8990566', 'QR2305', 98000);
INSERT INTO public.tickets (ticket_number, date_of_booking, date_of_travel, date_of_cancellation, passportno, flight_code, price) VALUES (16, '2023-10-17', '2023-10-17', NULL, 'A1122334', 'BA1689', NULL);


--
-- TOC entry 2993 (class 0 OID 0)
-- Dependencies: 206
-- Name: contains_code_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contains_code_seq', 25, true);


--
-- TOC entry 2994 (class 0 OID 0)
-- Dependencies: 210
-- Name: ticket1_ticket_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ticket1_ticket_number_seq', 16, true);


--
-- TOC entry 2827 (class 2606 OID 18153)
-- Name: airlines airline_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.airlines
    ADD CONSTRAINT airline_pkey PRIMARY KEY (airlineid);


--
-- TOC entry 2829 (class 2606 OID 18155)
-- Name: airports airport_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.airports
    ADD CONSTRAINT airport_pkey PRIMARY KEY (code);


--
-- TOC entry 2831 (class 2606 OID 18157)
-- Name: cities city_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT city_pkey PRIMARY KEY (code);


--
-- TOC entry 2833 (class 2606 OID 18159)
-- Name: contains contains_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contains
    ADD CONSTRAINT contains_pkey PRIMARY KEY (code);


--
-- TOC entry 2837 (class 2606 OID 18161)
-- Name: flights flight_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flights
    ADD CONSTRAINT flight_pkey PRIMARY KEY (flight_code);


--
-- TOC entry 2839 (class 2606 OID 18163)
-- Name: passengers passenger_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.passengers
    ADD CONSTRAINT passenger_pkey PRIMARY KEY (passportno);


--
-- TOC entry 2842 (class 2606 OID 18165)
-- Name: tickets tickets_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT tickets_pkey PRIMARY KEY (ticket_number);


--
-- TOC entry 2834 (class 1259 OID 18166)
-- Name: fki_fk_dest; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_fk_dest ON public.flights USING btree (destination);


--
-- TOC entry 2840 (class 1259 OID 18167)
-- Name: fki_flight_code; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_flight_code ON public.tickets USING btree (flight_code);


--
-- TOC entry 2835 (class 1259 OID 18168)
-- Name: fki_source; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_source ON public.flights USING btree (source);


--
-- TOC entry 2843 (class 2606 OID 18169)
-- Name: airports airport_city_code_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.airports
    ADD CONSTRAINT airport_city_code_fkey FOREIGN KEY (city) REFERENCES public.cities(code) ON UPDATE CASCADE;


--
-- TOC entry 2844 (class 2606 OID 18174)
-- Name: contains contains_airlineid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contains
    ADD CONSTRAINT contains_airlineid_fkey FOREIGN KEY (airlineid) REFERENCES public.airlines(airlineid) ON UPDATE CASCADE;


--
-- TOC entry 2845 (class 2606 OID 18179)
-- Name: contains contains_ap_code_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contains
    ADD CONSTRAINT contains_ap_code_fkey FOREIGN KEY (airportid) REFERENCES public.airports(code) ON UPDATE CASCADE;


--
-- TOC entry 2846 (class 2606 OID 18184)
-- Name: flights fk_dest; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flights
    ADD CONSTRAINT fk_dest FOREIGN KEY (destination) REFERENCES public.airports(code) NOT VALID;


--
-- TOC entry 2847 (class 2606 OID 18189)
-- Name: flights fk_source; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flights
    ADD CONSTRAINT fk_source FOREIGN KEY (source) REFERENCES public.airports(code) NOT VALID;


--
-- TOC entry 2848 (class 2606 OID 18194)
-- Name: flights flight_airlineid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flights
    ADD CONSTRAINT flight_airlineid_fkey FOREIGN KEY (airlineid) REFERENCES public.airlines(airlineid) ON UPDATE CASCADE;


--
-- TOC entry 2849 (class 2606 OID 18199)
-- Name: tickets flight_code; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT flight_code FOREIGN KEY (flight_code) REFERENCES public.flights(flight_code) NOT VALID;


--
-- TOC entry 2850 (class 2606 OID 18204)
-- Name: tickets ticket1_passportno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT ticket1_passportno_fkey FOREIGN KEY (passportno) REFERENCES public.passengers(passportno) ON UPDATE CASCADE;


-- Completed on 2023-10-17 16:23:35 UTC

--
-- PostgreSQL database dump complete
--

