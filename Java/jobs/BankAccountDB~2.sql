INSERT INTO bankuser (USER_NAME,USER_PASSWORD,FIRST_NAME,LAST_NAME,USER_LEVEL)
VALUES ('adminteller','admincode','Tom','Skillz','adminteller');


INSERT INTO bankuser (USER_NAME,USER_PASSWORD,FIRST_NAME,LAST_NAME,USER_LEVEL)
VALUES ('adminteller','admincode','Tom','Skillz','adminteller');

SELECT * FROM bankuser;


SELECT BALANCE FROM bankuser WHERE FIRST_Name='James';


DELETE FROM bankuser WHERE USER_LEVEL = 'pending';
DELETE FROM bankuser WHERE ACCOUNT_ID = 200;


UPDATE bankuser SET BALANCE = ? WHERE USER_NAME= ?

ALTER TABLE bankuser  ACCOUNT_ID          NUMBER(15)  AUTO_INCREMENT;

ALTER BANKUSER account_id;
B

CREATE TABLE winwin (
user_name           VARCHAR2 (26) NOT NULL,
user_password       VARCHAR2(26) ,
first_name          VARCHAR2(25) ,
last_name           VARCHAR2(25) ,
user_level          VARCHAR2(25) ,
account_id          NUMBER(15)  AUTO_INCREMENT ,
balance             NUMBER(30)
);

CREATE SEQUENCE my_account
START WITH 1
Increment by 1
CACHE 10;
CREATE TABLE superhumans(
    shuman_id NUMBER(15),
    shuman_name VARCHAR2(100) NOT NULL,
    bounty NUMBER(30) NOT NULL,
    PRIMARY KEY(shuman_id),
    UNIQUE(shuman_name)
);


DESC bankuser;