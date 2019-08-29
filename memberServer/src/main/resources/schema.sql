DROP TABLE IF EXISTS members;

CREATE SEQUENCE seq1;

CREATE TABLE members (
  id integer NOT NULL DEFAULT nextval('seq1') PRIMARY KEY,
  username varchar(128) NOT NULL UNIQUE,
  password varchar(256) NOT NULL
);

ALTER SEQUENCE seq1 OWNED BY members .id;