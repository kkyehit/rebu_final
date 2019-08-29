DROP TABLE IF EXISTS deliverers;

CREATE SEQUENCE seq3;

CREATE TABLE deliverers (
     id int NOT NULL DEFAULT nextval('seq3') PRIMARY KEY,
  username varchar(128) NOT NULL UNIQUE,
  password varchar(256) NOT NULL, 
   status  int            NULL, 
   x       VARCHAR(45)    NULL, 
    y       VARCHAR(45)    NULL
);

ALTER SEQUENCE seq3 OWNED BY members .id;