DROP DATABASE if EXISTS A8;
CREATE DATABASE A8;
USE A8;

CREATE TABLE student(
    roll_no INT,
    name VARCHAR(20),
    doa date, 
    branch VARCHAR(20),
    percent INT,
    status VARCHAR(20)
    );

CREATE TABLE alumni(
    roll_no INT,
    name VARCHAR(20),
    doa date, 
    branch VARCHAR(20),
    percent INT,
    status VARCHAR(20)
    );

INSERT INTO student VALUES(1, 'Prathamesh', '2020-04-8', 'Comp', '89', 'Pass');
INSERT INTO student VALUES(2, 'Aditya', '2020-04-5', 'ENTC', '45', 'Fail');
INSERT INTO student VALUES(3, 'Utkarsh', '2020-04-3', 'IT', '81', 'Pass');
INSERT INTO student VALUES(4, 'Varun', '2020-03-8', 'IT', '91', 'Pass');
INSERT INTO student VALUES(5, 'Shreya', '2020-01-23', 'Comp', '94', 'Pass');

DELIMITER $$
CREATE TRIGGER student_delete
    BEFORE DELETE ON student
    FOR EACH ROW 
    BEGIN
    INSERT INTO alumni VALUES(
    old.roll_no,
    old.name,
    old.doa, 
    old.branch,
    old.percent,
    old.status
    );
    END$$

CREATE TRIGGER student_update
    BEFORE UPDATE ON student
    FOR EACH ROW 
    BEGIN
        INSERT INTO alumni VALUES(
        old.roll_no,
        old.name,
        old.doa, 
        old.branch,
        old.percent,
        old.status
        );
    END$$

DELIMITER ;


DELETE FROM student WHERE roll_no=1;
UPDATE student SET percent=81 WHERE roll_no=2;
SELECT * FROM alumni;
