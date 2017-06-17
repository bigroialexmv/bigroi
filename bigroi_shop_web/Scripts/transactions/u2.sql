SET TRANSACTION ISOLATION LEVEL 
-- READ UNCOMMITTED
-- READ COMMITTED
-- REPEATABLE READ
SERIALIZABLE
;

START TRANSACTION;

INSERT INTO USER (FIRST_NAME, LAST_NAME, EMAIL, PHONE, CRTD_TMS, UPDT_TMS) 
 VALUES ('Priscilla', 'Holden', 'holden@bigroi.by', '+375294444444', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

COMMIT;

ROLLBACK;

SELECT * FROM PURCHASE_ORDER_PRODUCT;



START TRANSACTION;

INSERT INTO PURCHASE_ORDER(USER_ID, DLRY_ADDR_ID, DLRY_DATE, CRTD_TMS)
VALUES (1, 1, '2017-06-27', CURRENT_TIMESTAMP);

INSERT INTO PURCHASE_ORDER_PRODUCT(ORDER_ID, PRODUCT_CODE, PRODUCT_PRICE, PRODUCT_QUANTITY)
VALUES (LAST_INSERT_ID(), 20, (SELECT PRICE FROM PRODUCT WHERE CODE=20), 2);

SELECT LAST_INSERT_ID();

UPDATE PRODUCT SET QUANTITY=QUANTITY - 2 WHERE CODE=20;

SELECT * FROM PRODUCT WHERE CODE=20;

COMMIT;

ROLLBACK;

SHOW OPEN TABLES;

SHOW PROCESSLIST;

KILL 529432;

UNLOCK TABLES;