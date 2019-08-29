DROP TABLE IF EXISTS orders;

CREATE SEQUENCE seq4;

CREATE TABLE orders (
    orderid integer         NOT NULL DEFAULT nextval('seq4')  PRIMARY KEY, 
    send     VARCHAR(255)    NULL, 
    receive  VARCHAR(255)    NULL, 
    deliver  VARCHAR(255)    NULL, 
    status  integer          NULL, 
    image    VARCHAR(255)    NULL, 
    fromx    VARCHAR(45)     NULL, 
    fromy    VARCHAR(45)     NULL, 
    tox      VARCHAR(45)     NULL, 
    toy      VARCHAR(45)     NULL, 
    date     timestamp        NOT NULL   DEFAULT CURRENT_TIMESTAMP, 
    info     VARCHAR(255)    NULL
);


ALTER SEQUENCE seq4 OWNED BY orders .orderid;