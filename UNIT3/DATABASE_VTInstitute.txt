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

--
-- TOC entry 656 (class 1247 OID 16451)
-- Name: subjects_with_courses; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.subjects_with_courses AS (
	name character varying(50),
	course character varying(90)
);


ALTER TYPE public.subjects_with_courses OWNER TO postgres;

--
-- TOC entry 214 (class 1255 OID 32847)
-- Name: enroll_student(character varying, integer); Type: PROCEDURE; Schema: public; Owner: postgres
--

CREATE PROCEDURE public.enroll_student(student_id character varying, course_id integer)
    LANGUAGE plpgsql
    AS $$
DECLARE
 	enroll_code INTEGER;
	mysubject subjects;
BEGIN
   INSERT INTO enrollments (student, course) 
          VALUES (student_id, course_id)
		  RETURNING code INTO enroll_code;
   FOR mysubject IN
   		SELECT * FROM subjects where course=course_id
   LOOP
   		INSERT INTO scores (enrollment_id, subject_id, score)
		       VALUES (enroll_code, mysubject.code, 0);
   END LOOP;
END;
$$;


ALTER PROCEDURE public.enroll_student(student_id character varying, course_id integer) OWNER TO postgres;

--
-- TOC entry 226 (class 1255 OID 32848)
-- Name: get_student_scores(character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.get_student_scores(p_student_id character varying) RETURNS TABLE(course_name character varying, subject_name character varying, final_score integer)
    LANGUAGE plpgsql
    AS $$
DECLARE
 mysubject RECORD; 
BEGIN
 FOR mysubject IN 
 	SELECT subjects.name AS tname, courses.name AS tcourse, scores.score as tscore
      FROM courses INNER JOIN (subjects INNER JOIN (scores INNER JOIN enrollments ON scores.enrollment_id=enrollments.code) ON subjects.code=scores.subject_id) ON subjects.course=courses.code
	WHERE enrollments.student LIKE p_student_id 
   LOOP 
		subject_name := mysubject.tname;
		course_name := mysubject.tcourse;
		final_score := mysubject.tscore;
   RETURN NEXT; 
 END LOOP; 
END;
$$;


ALTER FUNCTION public.get_student_scores(p_student_id character varying) OWNER TO postgres;

--
-- TOC entry 213 (class 1255 OID 16500)
-- Name: has_pending_subjects(character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.has_pending_subjects(student_idcard character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$
DECLARE
 pending_subjects INTEGER; 
BEGIN
 	SELECT COUNT(*) INTO pending_subjects 
	FROM scores INNER JOIN enrollments ON enrollments.code=scores.enrollment_id
	WHERE (enrollments.student LIKE student_idcard) AND (scores.score < 5);
   RETURN (pending_subjects > 0); 
END;
$$;


ALTER FUNCTION public.has_pending_subjects(student_idcard character varying) OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16422)
-- Name: Courses_Code_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Courses_Code_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public."Courses_Code_seq" OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 16424)
-- Name: subjects; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.subjects (
    code integer DEFAULT nextval('public."Courses_Code_seq"'::regclass) NOT NULL,
    name character varying(50),
    year integer,
    course integer,
    hours integer
);


ALTER TABLE public.subjects OWNER TO postgres;

--
-- TOC entry 210 (class 1255 OID 16434)
-- Name: listofsubjects(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.listofsubjects(theyear integer) RETURNS SETOF public.subjects
    LANGUAGE plpgsql
    AS $$
DECLARE
 mysubject subjects; 
BEGIN
 FOR mysubject IN SELECT * FROM subjects WHERE year=theyear LOOP 
   RETURN NEXT mysubject; 
 END LOOP; 
END;
$$;


ALTER FUNCTION public.listofsubjects(theyear integer) OWNER TO postgres;

--
-- TOC entry 211 (class 1255 OID 16453)
-- Name: subjects_and_courses(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.subjects_and_courses(theyear integer) RETURNS SETOF public.subjects_with_courses
    LANGUAGE plpgsql
    AS $$
DECLARE
 mysubject subjects_with_courses; 
BEGIN
 FOR mysubject IN 
 	SELECT subjects.name, courses.name FROM subjects INNER JOIN courses 
	ON subjects.course=courses.code
	WHERE year=theyear 
   LOOP 
   RETURN NEXT mysubject; 
 END LOOP; 
END;
$$;


ALTER FUNCTION public.subjects_and_courses(theyear integer) OWNER TO postgres;

--
-- TOC entry 212 (class 1255 OID 16458)
-- Name: subjects_and_courses_2(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.subjects_and_courses_2(theyear integer) RETURNS TABLE(name character varying, course character varying)
    LANGUAGE plpgsql
    AS $$
DECLARE
 mysubject RECORD; 
BEGIN
 FOR mysubject IN 
 	SELECT subjects.name AS sname, courses.name AS scourse
      FROM subjects INNER JOIN courses ON subjects.course=courses.code
	WHERE year=theyear 
   LOOP 
   name := mysubject.sname;
   course := mysubject.scourse;
   RETURN NEXT; 
 END LOOP; 
END;
$$;


ALTER FUNCTION public.subjects_and_courses_2(theyear integer) OWNER TO postgres;

--
-- TOC entry 209 (class 1255 OID 16433)
-- Name: subjectsinayear(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.subjectsinayear(theyear integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
 amount INTEGER; 
BEGIN
 SELECT COUNT(*) INTO amount FROM subjects WHERE subjects.year=theyear; 
 RETURN amount; 
END;
$$;


ALTER FUNCTION public.subjectsinayear(theyear integer) OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16437)
-- Name: courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.courses (
    code integer NOT NULL,
    name character varying(90) NOT NULL
);


ALTER TABLE public.courses OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16435)
-- Name: courses_code_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.courses_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.courses_code_seq OWNER TO postgres;

--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 202
-- Name: courses_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.courses_code_seq OWNED BY public.courses.code;


--
-- TOC entry 207 (class 1259 OID 16469)
-- Name: enrollments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enrollments (
    student character varying(12) NOT NULL,
    course integer NOT NULL,
    code integer NOT NULL
);


ALTER TABLE public.enrollments OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16467)
-- Name: inscriptions_code_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.inscriptions_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inscriptions_code_seq OWNER TO postgres;

--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 206
-- Name: inscriptions_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inscriptions_code_seq OWNED BY public.enrollments.code;


--
-- TOC entry 208 (class 1259 OID 16485)
-- Name: scores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.scores (
    enrollment_id integer NOT NULL,
    subject_id integer NOT NULL,
    score integer
);


ALTER TABLE public.scores OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16462)
-- Name: students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.students (
    firstname character varying(50) NOT NULL,
    lastname character varying(100) NOT NULL,
    idcard character varying(12) NOT NULL,
    phone character varying(12),
    email character varying(100)
);


ALTER TABLE public.students OWNER TO postgres;

--
-- TOC entry 2882 (class 2604 OID 16440)
-- Name: courses code; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courses ALTER COLUMN code SET DEFAULT nextval('public.courses_code_seq'::regclass);


--
-- TOC entry 2883 (class 2604 OID 16472)
-- Name: enrollments code; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollments ALTER COLUMN code SET DEFAULT nextval('public.inscriptions_code_seq'::regclass);


--
-- TOC entry 3033 (class 0 OID 16437)
-- Dependencies: 203
-- Data for Name: courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.courses (code, name) VALUES (1, 'Multiplatform app development');
INSERT INTO public.courses (code, name) VALUES (2, 'Web development');


--
-- TOC entry 3036 (class 0 OID 16469)
-- Dependencies: 207
-- Data for Name: enrollments; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.enrollments (student, course, code) VALUES ('id001', 1, 11);
INSERT INTO public.enrollments (student, course, code) VALUES ('id001', 2, 12);


--
-- TOC entry 3037 (class 0 OID 16485)
-- Dependencies: 208
-- Data for Name: scores; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.scores (enrollment_id, subject_id, score) VALUES (11, 1, 6);
INSERT INTO public.scores (enrollment_id, subject_id, score) VALUES (11, 3, 8);
INSERT INTO public.scores (enrollment_id, subject_id, score) VALUES (11, 4, 5);
INSERT INTO public.scores (enrollment_id, subject_id, score) VALUES (11, 6, 9);
INSERT INTO public.scores (enrollment_id, subject_id, score) VALUES (12, 2, 0);
INSERT INTO public.scores (enrollment_id, subject_id, score) VALUES (12, 5, 0);


--
-- TOC entry 3034 (class 0 OID 16462)
-- Dependencies: 205
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Aitana', 'Garcia', 'id003', '', '');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('John', 'Spencer', 'id004', '', '');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('John', 'Smith', 'id005', '654654654', 'johnsmith@email.com');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Marcos', 'Andreu', 'id006', '', '');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Student', 'X', 'id007', '', '');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Mark', 'Ross', 'id008', '', '');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Estrella', 'Garcia', 'id002', '', 'estrella@email.com');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Robe', 'Iniesta', 'id111', '', '');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Jose', 'Garcia', 'id001', '655468075', 'jrgarcia@mail.com');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Ken', 'Brockman', 'id321', '123456789', 'ken@e.com');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Kevin', 'Smith', 'id4444', '123456789', '');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Jose ', 'Ramón', 'ID005', '', '');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Jose ', 'Ramón', 'ID002', '', 'jose.ramon.garcia.sevilla@gmail.com');
INSERT INTO public.students (firstname, lastname, idcard, phone, email) VALUES ('Jose', 'García', '12345678', '', '');


--
-- TOC entry 3031 (class 0 OID 16424)
-- Dependencies: 201
-- Data for Name: subjects; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.subjects (code, name, year, course, hours) VALUES (1, 'DATA ACCESS', 2, 1, NULL);
INSERT INTO public.subjects (code, name, year, course, hours) VALUES (3, 'DATABASE MANAGEMENT SYSTEMS', 1, 1, NULL);
INSERT INTO public.subjects (code, name, year, course, hours) VALUES (4, 'SERVICES AND PROCESSES', 2, 1, NULL);
INSERT INTO public.subjects (code, name, year, course, hours) VALUES (6, 'Technical English', 1, 1, NULL);
INSERT INTO public.subjects (code, name, year, course, hours) VALUES (2, 'DEVELOPMENT ENVIRONMENTS', 1, 2, NULL);
INSERT INTO public.subjects (code, name, year, course, hours) VALUES (5, 'MARKUP LANGUAGES', 1, 2, NULL);


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 200
-- Name: Courses_Code_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Courses_Code_seq"', 6, true);


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 202
-- Name: courses_code_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.courses_code_seq', 2, true);


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 206
-- Name: inscriptions_code_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inscriptions_code_seq', 12, true);


--
-- TOC entry 2885 (class 2606 OID 16429)
-- Name: subjects Courses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subjects
    ADD CONSTRAINT "Courses_pkey" PRIMARY KEY (code);


--
-- TOC entry 2888 (class 2606 OID 16442)
-- Name: courses courses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (code);


--
-- TOC entry 2892 (class 2606 OID 16474)
-- Name: enrollments inscriptions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollments
    ADD CONSTRAINT inscriptions_pkey PRIMARY KEY (code);


--
-- TOC entry 2894 (class 2606 OID 16489)
-- Name: scores pk_enrollment; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scores
    ADD CONSTRAINT pk_enrollment PRIMARY KEY (enrollment_id, subject_id);


--
-- TOC entry 2890 (class 2606 OID 16466)
-- Name: students students_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (idcard);


--
-- TOC entry 2886 (class 1259 OID 16448)
-- Name: fki_fk_course; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_fk_course ON public.subjects USING btree (course);


--
-- TOC entry 2895 (class 2606 OID 16443)
-- Name: subjects fk_course; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subjects
    ADD CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES public.courses(code) NOT VALID;


--
-- TOC entry 2897 (class 2606 OID 16480)
-- Name: enrollments fk_course; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollments
    ADD CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES public.courses(code) NOT VALID;


--
-- TOC entry 2899 (class 2606 OID 16490)
-- Name: scores fk_enrollment; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scores
    ADD CONSTRAINT fk_enrollment FOREIGN KEY (enrollment_id) REFERENCES public.enrollments(code);


--
-- TOC entry 2896 (class 2606 OID 16475)
-- Name: enrollments fk_student; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollments
    ADD CONSTRAINT fk_student FOREIGN KEY (student) REFERENCES public.students(idcard) NOT VALID;


--
-- TOC entry 2898 (class 2606 OID 16495)
-- Name: scores fk_subjects; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scores
    ADD CONSTRAINT fk_subjects FOREIGN KEY (subject_id) REFERENCES public.subjects(code);
