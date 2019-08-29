DROP TABLE IF EXISTS purchases;

CREATE SEQUENCE seq2;

CREATE TABLE purchases (
  `purchaseid` integer NOT NULL DEFAULT nextval('seq2') PRIMARY KEY,
  `userid` integer NOT NULL,
  `goodsid` integer NOT NULL,
  `date` timestamp NOT NULL 
) ;

ALTER SEQUENCE seq2 OWNED BY  purchases.id;