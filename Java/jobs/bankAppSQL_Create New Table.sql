---- Create tables for the DB
GRANT UNLIMITED TABLESPACE TO BANK_APP;
/

CREATE TABLE user_types (
	usertype 	NUMBER 			NOT NULL,
	typename 	VARCHAR2(20) 	NOT NULL,
	CONSTRAINT PK_USERTYPE PRIMARY KEY (usertype)
);
/

CREATE TABLE users (
	userid 		NUMBER 			NOT NULL,
	usertype 	NUMBER 			NOT NULL,
	username 	VARCHAR2(50) 	NOT NULL,
	password	NUMBER			NOT NULL,
	pending		NUMBER,
	CONSTRAINT PK_USERID PRIMARY KEY (userid),
	CONSTRAINT FK_USERTYPE
		FOREIGN KEY (usertype)
		REFERENCES user_types (usertype)
);
/

CREATE TABLE accounts (
	accountid 		NUMBER 				NOT NULL,
	balance 		NUMBER 				NOT NULL,
	isapproved 		NUMBER 	DEFAULT 0	NOT NULL,
	primaryuserid 	NUMBER 	DEFAULT -1	NOT NULL,
	CONSTRAINT PK_ACCOUNTID PRIMARY KEY (accountid)
);
/

CREATE TABLE user_account_joint (
	userid 		NUMBER 	NOT NULL,
	accountid 	NUMBER 	NOT NULL,
	CONSTRAINT PK_USER_ACCOUNT_JOINT PRIMARY KEY (userid, accountid),\
	CONSTRAINT FK_USERID
		FOREIGN KEY (userid)
		REFERENCES users (userid),
	CONSTRAINT FK_ACCOUNTID
		FOREIGN KEY (accountid)
		REFERENCES accounts (accountid)
);
/
