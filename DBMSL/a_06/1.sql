DROP DATABASE IF EXISTS A6;
CREATE DATABASE A6;
USE A6;

CREATE TABLE O_rollCall(
    roll_no INT NOT NULL,
    name VARCHAR(20)
);

CREATE TABLE N_rollCall(
    roll_no INT NOT NULL,
    name VARCHAR(20)
);

INSERT INTO O_rollCall VALUES(1, 'Prathamesh');
INSERT INTO O_rollCall VALUES(2, 'Aditya');
INSERT INTO O_rollCall VALUES(3, 'Ram');
INSERT INTO O_rollCall VALUES(4, 'Sooraj');
INSERT INTO O_rollCall VALUES(5, 'Shreya');

INSERT INTO N_rollCall VALUES(1, 'Prathamesh');
INSERT INTO N_rollCall VALUES(3, 'Ram');
INSERT INTO N_rollCall VALUES(5, 'Shreya');
INSERT INTO N_rollCall VALUES(6, 'Swatej');
INSERT INTO N_rollCall VALUES(7, 'Yuvraj');

SELECT * FROM O_rollCall;
SELECT * FROM N_rollCall;

delimiter $$
CREATE PROCEDURE MergeTables()
BEGIN
DECLARE roll INT;
DECLARE finished INT DEFAULT 0;
DECLARE cur1 cursor for select roll_no from O_rollCall;
DECLARE CONTINUE handler for NOT found set finished = 1;
OPEN cur1;
 
loop1: loop
IF finished = 1 THEN
close cur1; 
leave loop1;
END IF;
FETCH cur1 INTO roll;
IF NOT EXISTS(select roll_no from N_rollCall where roll_no = roll) THEN
INSERT INTO N_rollCall select * from O_rollCall where roll_no = roll;
END IF;
END loop loop1;
END
$$


delimiter ;

call MergeTables();


SELECT * FROM O_rollCall;
SELECT * FROM N_rollCall;

