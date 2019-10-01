DROP TABLE IF EXISTS reivews;

CREATE SEQUENCE seq5;

CREATE TABLE reviews(
    reviewid Integer         NOT NULL PRIMARY KEY DEFAULT nextval('seq5'), 
    deliver  VARCHAR(255)    NULL,
    date     timestamp       NOT NULL    DEFAULT CURRENT_TIMESTAMP, 
    text     VARCHAR(255)    NULL
);

ALTER SEQUENCE seq5 OWNED BY  reviews.reviewid;