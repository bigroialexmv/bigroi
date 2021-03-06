INSERT INTO T1 VALUES(1,1);
INSERT INTO T1 VALUES(1,2);
INSERT INTO T1 VALUES(1,3);

INSERT INTO T2 VALUES(1, 'A');
INSERT INTO T2 VALUES(1, 'B');
INSERT INTO T2 VALUES(1, 'C');

SELECT * FROM T1;
SELECT * FROM T2;

SELECT * FROM T1
	INNER JOIN T2 ON T1.T1C1=T2.T2C1
;

SELECT * FROM T2
	INNER JOIN T1 ON T1.T1C1=T2.T2C1
;

SELECT * FROM T2
	INNER JOIN T1 ON T1.T1C2=T2.T2C1
;

SELECT * FROM T2
	LEFT JOIN T1 ON T1.T1C2=T2.T2C1
;

SELECT * FROM T1
	LEFT JOIN T2 ON T1.T1C2=T2.T2C1
;

SELECT * FROM T2
	RIGHT JOIN T1 ON T1.T1C2=T2.T2C1
;