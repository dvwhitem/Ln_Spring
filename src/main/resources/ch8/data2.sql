
CREATE SEQUENCE public.revinfo_rev_seq;

CREATE TABLE public.REVINFO (
                REVINFO_ID BIGINT NOT NULL,
                REV INTEGER NOT NULL DEFAULT nextval('public.revinfo_rev_seq'),
                CONSTRAINT revinfo_id PRIMARY KEY (REVINFO_ID, REV)
);


ALTER SEQUENCE public.revinfo_rev_seq OWNED BY public.REVINFO.REV;

CREATE TABLE public.CONTACT_AUDIT_H (
                CONTACT_AUDIT_H_ID INTEGER NOT NULL,
                AUDIT_REVISION INTEGER NOT NULL,
                FIRST_NAME VARCHAR(60) NOT NULL,
                LAST_NAME VARCHAR(40) NOT NULL,
                BIRTH_DATE TIMESTAMP NOT NULL,
                VERSION INTEGER DEFAULT 0 NOT NULL,
                CREATED_BY VARCHAR(20) NOT NULL,
                CREATED_DATE TIMESTAMP NOT NULL,
                LAST_MODIFIED_BY VARCHAR(20) NOT NULL,
                LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
                ACTION_TYPE INTEGER NOT NULL,
                AUDIT_REVISION_END INTEGER NOT NULL,
                AUDIT_REVISION_END_TS TIMESTAMP NOT NULL,
                CONSTRAINT contact_audit_h_id PRIMARY KEY (CONTACT_AUDIT_H_ID, AUDIT_REVISION)
);


CREATE SEQUENCE public.revinfo_rev_seq;

CREATE TABLE public.REVINFO (
                REVINFO_ID BIGINT NOT NULL,
                REV INTEGER NOT NULL DEFAULT nextval('public.revinfo_rev_seq'),
                CONSTRAINT revinfo_id PRIMARY KEY (REVINFO_ID, REV)
);


ALTER SEQUENCE public.revinfo_rev_seq OWNED BY public.REVINFO.REV;

CREATE TABLE public.CONTACT_AUDIT_H (
                CONTACT_AUDIT_H_ID INTEGER NOT NULL,
                AUDIT_REVISION INTEGER NOT NULL,
                FIRST_NAME VARCHAR(60) NOT NULL,
                LAST_NAME VARCHAR(40) NOT NULL,
                BIRTH_DATE TIMESTAMP NOT NULL,
                VERSION INTEGER DEFAULT 0 NOT NULL,
                CREATED_BY VARCHAR(20) NOT NULL,
                CREATED_DATE TIMESTAMP NOT NULL,
                LAST_MODIFIED_BY VARCHAR(20) NOT NULL,
                LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
                ACTION_TYPE INTEGER NOT NULL,
                AUDIT_REVISION_END INTEGER NOT NULL,
                AUDIT_REVISION_END_TS TIMESTAMP NOT NULL,
                CONSTRAINT contact_audit_h_id PRIMARY KEY (CONTACT_AUDIT_H_ID, AUDIT_REVISION)
);

CREATE UNIQUE INDEX uq_contact_audit_h_1
 ON public.contact_audit_h
 ( FIRST_NAME, LAST_NAME );


CREATE SEQUENCE public.contact_audit_contact_audit_id_seq;

CREATE TABLE public.CONTACT_AUDIT (
                CONTACT_AUDIT_ID INTEGER NOT NULL DEFAULT nextval('public.contact_audit_contact_audit_id_seq'),
                LAST_NAME VARCHAR(40) NOT NULL,
                FIRST_NAME VARCHAR(60) NOT NULL,
                BIRTH_DATE TIMESTAMP NOT NULL,
                VERSION INTEGER DEFAULT 0 NOT NULL,
                CREATED_BY VARCHAR(20),
                CREATED_DATE TIMESTAMP NOT NULL,
                LAST_MODIFIED_BY VARCHAR(20) NOT NULL,
                LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
                CONSTRAINT contact_audit_id PRIMARY KEY (CONTACT_AUDIT_ID)
);

CREATE UNIQUE INDEX uq_contact_audit_1
 ON public.contact_audit
 ( FIRST_NAME, LAST_NAME );


ALTER SEQUENCE public.contact_audit_contact_audit_id_seq OWNED BY public.CONTACT_AUDIT.CONTACT_AUDIT_ID;

CREATE TABLE public.HOBBY (
                HOBBY_ID VARCHAR(20) NOT NULL,
                CONSTRAINT hobby_id PRIMARY KEY (HOBBY_ID)
);


CREATE SEQUENCE public.contact_contact_id_seq;

CREATE TABLE public.CONTACT (
                CONTACT_ID INTEGER NOT NULL DEFAULT nextval('public.contact_contact_id_seq'),
                FIRST_NAME VARCHAR(60) NOT NULL,
                LAST_NAME VARCHAR(40) NOT NULL,
                BIRTH_DATE TIMESTAMP NOT NULL,
                VERSION INTEGER DEFAULT 0 NOT NULL,
                CONSTRAINT contact_id PRIMARY KEY (CONTACT_ID)
);


ALTER SEQUENCE public.contact_contact_id_seq OWNED BY public.CONTACT.CONTACT_ID;

CREATE UNIQUE INDEX uq_contact_1
 ON public.CONTACT
 ( FIRST_NAME, LAST_NAME );

CREATE TABLE public.CONTACT_HOBBY_DETAIL (
                CONTACT_ID INTEGER NOT NULL,
                HOBBY_ID VARCHAR(20) NOT NULL,
                CONSTRAINT contact_id__hobby_id PRIMARY KEY (CONTACT_ID, HOBBY_ID)
);


CREATE SEQUENCE public.contact_tel_detail_contact_tel_detail_id_seq;

CREATE TABLE public.CONTACT_TEL_DETAIL (
                CONTACT_TEL_DETAIL_ID INTEGER NOT NULL DEFAULT nextval('public.contact_tel_detail_contact_tel_detail_id_seq'),
                CONTACT_ID INTEGER NOT NULL,
                TEL_TYPE VARCHAR(20) NOT NULL,
                TEL_NUMBER VARCHAR(20) NOT NULL,
                VERSION INTEGER DEFAULT 0 NOT NULL,
                CONSTRAINT contact_tel_detail_id PRIMARY KEY (CONTACT_TEL_DETAIL_ID)
);


ALTER SEQUENCE public.contact_tel_detail_contact_tel_detail_id_seq OWNED BY public.CONTACT_TEL_DETAIL.CONTACT_TEL_DETAIL_ID;

ALTER TABLE public.CONTACT_HOBBY_DETAIL ADD CONSTRAINT hobby_contact_hobby_detail_fk
FOREIGN KEY (HOBBY_ID)
REFERENCES public.HOBBY (HOBBY_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CONTACT_TEL_DETAIL ADD CONSTRAINT contact_contact_tel_detail_fk
FOREIGN KEY (CONTACT_ID)
REFERENCES public.CONTACT (CONTACT_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CONTACT_HOBBY_DETAIL ADD CONSTRAINT contact_contact_hobby_detail_fk
FOREIGN KEY (CONTACT_ID)
REFERENCES public.CONTACT (CONTACT_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


CREATE SEQUENCE public.contact_audit_contact_audit_id_seq;

CREATE TABLE public.CONTACT_AUDIT (
                CONTACT_AUDIT_ID INTEGER NOT NULL DEFAULT nextval('public.contact_audit_contact_audit_id_seq'),
                LAST_NAME VARCHAR(40) NOT NULL,
                FIRST_NAME VARCHAR(60) NOT NULL,
                BIRTH_DATE TIMESTAMP NOT NULL,
                VERSION INTEGER DEFAULT 0 NOT NULL,
                CREATED_BY VARCHAR(20),
                CREATED_DATE TIMESTAMP NOT NULL,
                LAST_MODIFIED_BY VARCHAR(20) NOT NULL,
                LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
                CONSTRAINT contact_audit_id PRIMARY KEY (CONTACT_AUDIT_ID)
);



ALTER SEQUENCE public.contact_audit_contact_audit_id_seq OWNED BY public.CONTACT_AUDIT.CONTACT_AUDIT_ID;

CREATE TABLE public.HOBBY (
                HOBBY_ID VARCHAR(20) NOT NULL,
                CONSTRAINT hobby_id PRIMARY KEY (HOBBY_ID)
);


CREATE SEQUENCE public.contact_contact_id_seq;

CREATE TABLE public.CONTACT (
                CONTACT_ID INTEGER NOT NULL DEFAULT nextval('public.contact_contact_id_seq'),
                FIRST_NAME VARCHAR(60) NOT NULL,
                LAST_NAME VARCHAR(40) NOT NULL,
                BIRTH_DATE TIMESTAMP NOT NULL,
                VERSION INTEGER DEFAULT 0 NOT NULL,
                CONSTRAINT contact_id PRIMARY KEY (CONTACT_ID)
);


ALTER SEQUENCE public.contact_contact_id_seq OWNED BY public.CONTACT.CONTACT_ID;

CREATE UNIQUE INDEX uq_contact_1
 ON public.CONTACT
 ( FIRST_NAME, LAST_NAME );

CREATE TABLE public.CONTACT_HOBBY_DETAIL (
                CONTACT_ID INTEGER NOT NULL,
                HOBBY_ID VARCHAR(20) NOT NULL,
                CONSTRAINT contact_id__hobby_id PRIMARY KEY (CONTACT_ID, HOBBY_ID)
);


CREATE SEQUENCE public.contact_tel_detail_contact_tel_detail_id_seq;

CREATE TABLE public.CONTACT_TEL_DETAIL (
                CONTACT_TEL_DETAIL_ID INTEGER NOT NULL DEFAULT nextval('public.contact_tel_detail_contact_tel_detail_id_seq'),
                CONTACT_ID INTEGER NOT NULL,
                TEL_TYPE VARCHAR(20) NOT NULL,
                TEL_NUMBER VARCHAR(20) NOT NULL,
                VERSION INTEGER DEFAULT 0 NOT NULL,
                CONSTRAINT contact_tel_detail_id PRIMARY KEY (CONTACT_TEL_DETAIL_ID)
);


ALTER SEQUENCE public.contact_tel_detail_contact_tel_detail_id_seq OWNED BY public.CONTACT_TEL_DETAIL.CONTACT_TEL_DETAIL_ID;

ALTER TABLE public.CONTACT_HOBBY_DETAIL ADD CONSTRAINT hobby_contact_hobby_detail_fk
FOREIGN KEY (HOBBY_ID)
REFERENCES public.HOBBY (HOBBY_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CONTACT_TEL_DETAIL ADD CONSTRAINT contact_contact_tel_detail_fk
FOREIGN KEY (CONTACT_ID)
REFERENCES public.CONTACT (CONTACT_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CONTACT_HOBBY_DETAIL ADD CONSTRAINT contact_contact_hobby_detail_fk
FOREIGN KEY (CONTACT_ID)
REFERENCES public.CONTACT (CONTACT_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;