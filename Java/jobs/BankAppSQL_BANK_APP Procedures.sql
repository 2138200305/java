INSERT INTO user_types (usertype, typename) VALUES (1, 'Customer');
/
INSERT INTO user_types (usertype, typename) VALUES (2, 'Employee');
/
INSERT INTO user_types (usertype, typename) VALUES (3, 'Administrator');
/
INSERT INTO users (userid, usertype, username, password) VALUES (1, 3, 'admin', ORA_HASH('admin'));
/
INSERT INTO users (userid, usertype, username, password) VALUES (2, 1, 'tkropp', ORA_HASH('testpass'));
/

CREATE OR REPLACE PROCEDURE get_user_type(in_typename IN VARCHAR2, out_typeid OUT NUMBER) IS
BEGIN
	SELECT ut.usertype INTO out_typeid FROM BANK_APP.User_Types ut WHERE ut.typename = in_typename;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			SELECT -1 INTO out_typeid FROM DUAL;
END;

/* to be used for new userids */
CREATE SEQUENCE BANK_APP.userid_seq
    START WITH 2
    INCREMENT BY 1;
/

/* to be used for new accountids */
CREATE SEQUENCE BANK_APP.accountid_seq
    START WITH 1
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER trigger_user_insert
BEFORE INSERT ON BANK_APP.Users
FOR EACH ROW
BEGIN
	IF :NEW.userid IS NULL THEN
		SELECT BANK_APP.userid_seq.NEXTVAL INTO :NEW.userid FROM DUAL;
	END IF;
END;
/

/* takes in a username, password, and usertype and outputs 1 for success and 0 for failure and outputs the user id of the new user */
CREATE OR REPLACE PROCEDURE create_user(in_username IN VARCHAR2, in_password IN VARCHAR2, in_usertype IN VARCHAR2,
											out_was_successful OUT NUMBER, out_user_id OUT NUMBER) IS
v_user VARCHAR2(50);
v_utype NUMBER;
BEGIN
	SELECT u.username INTO v_user FROM BANK_APP.Users u WHERE u.username = in_username;
	SELECT 0 INTO out_was_successful FROM DUAL;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		get_user_type(in_usertype, v_utype);
		IF v_utype = -1 THEN
			SELECT 0 INTO out_was_successful FROM DUAL;
		ELSIF v_utype = 1 THEN
			INSERT INTO BANK_APP.Users (usertype, username, password, pending) VALUES (v_utype, in_username, ORA_HASH(in_password), 0);
			SELECT BANK_APP.userid_seq.CURRVAL INTO out_user_id FROM DUAL;
			COMMIT;
			SELECT 1 INTO out_was_successful FROM DUAL;
		ELSE
			INSERT INTO BANK_APP.Users (usertype, username, password) VALUES (v_utype, in_username, ORA_HASH(in_password));
			SELECT BANK_APP.userid_seq.CURRVAL INTO out_user_id FROM DUAL;
			COMMIT;
			SELECT 1 INTO out_was_successful FROM DUAL;
		END IF;
END; /

/* returns 1 if the credentials were correct and 0 if the credentials were incorrect */
CREATE OR REPLACE PROCEDURE test_password(in_username IN VARCHAR2, in_password IN VARCHAR2, out_is_correct OUT NUMBER) IS
v_hash NUMBER;
v_pass NUMBER;
BEGIN
	SELECT ORA_HASH(in_password) INTO v_hash FROM DUAL;
	SELECT u.password INTO v_pass FROM BANK_APP.Users u WHERE in_username = u.username;
	IF v_hash = v_pass THEN
		SELECT 1 INTO out_is_correct FROM DUAL;
	ELSE
		SELECT 0 INTO out_is_correct FROM DUAL;
	END IF;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		SELECT 0 INTO out_is_correct FROM DUAL;
END; /

CREATE OR REPLACE FUNCTION get_type(in_usertype IN NUMBER) RETURN VARCHAR2 IS
v_typename VARCHAR2(20);
BEGIN
	SELECT ut.typename INTO v_typename FROM BANK_APP.User_Types ut WHERE in_usertype = ut.usertype;
	RETURN v_typename;
END; /

/* selects all users into the reference cursor parameter */

CREATE OR REPLACE PROCEDURE select_users(out_cursor_users OUT SYS_REFCURSOR) IS
BEGIN
	OPEN out_cursor_users FOR
	SELECT userid, username, get_type(usertype), pending FROM BANK_APP.Users;
END; /

/* selects all customers into the reference cursor parameter */

CREATE OR REPLACE PROCEDURE select_customers(out_cursor_customers OUT SYS_REFCURSOR) IS
BEGIN
	OPEN out_cursor_customers FOR
	SELECT userid, username, pending FROM BANK_APP.Users
	WHERE usertype = (SELECT usertype FROM BANK_APP.User_Types WHERE typename = 'Customer');
END; /

/* selects all accounts */

CREATE OR REPLACE PROCEDURE BANK_APP.select_all_accounts(out_cursor_accts OUT SYS_REFCURSOR) IS
BEGIN
	OPEN out_cursor_accts FOR
	SELECT accountid, balance, isapproved, primaryuserid FROM BANK_APP.Accounts;
END; /

/* selects user-account connections */

CREATE OR REPLACE PROCEDURE BANK_APP.select_user_account_joints(out_cursor_joints OUT SYS_REFCURSOR) IS
BEGIN
	OPEN out_cursor_joints FOR
	SELECT userid, accountid FROM BANK_APP.User_Account_Joint;
END; /

/* selects accounts for a particular user */

CREATE OR REPLACE PROCEDURE BANK_APP.select_accounts(in_userid IN NUMBER, out_cursor_accts OUT SYS_REFCURSOR) IS
v_type VARCHAR(20);
BEGIN
	SELECT t.typename INTO v_type FROM BANK_APP.User_Types t WHERE t.usertype =
		(SELECT u.usertype FROM BANK_APP.Users u WHERE u.userid = in_userid);
	IF v_type = 'Customer' THEN
		OPEN out_cursor_accts FOR
		SELECT a.accountid, a.balance FROM BANK_APP.Accounts a WHERE a.accountid IN
			(SELECT j.accountid FROM BANK_APP.User_Account_Joint j WHERE j.userid = in_userid);
	ELSE
		OPEN out_cursor_accts FOR
		SELECT a.accountid, a.balance FROM BANK_APP.Accounts a;
	END IF;
END; /

/* creates a new account */
CREATE OR REPLACE PROCEDURE BANK_APP.create_account(in_approved IN NUMBER, out_accountid OUT NUMBER) IS
v_accountid NUMBER;
BEGIN
	SELECT BANK_APP.accountid_seq.NEXTVAL INTO out_accountid FROM DUAL;
	INSERT INTO BANK_APP.Accounts (accountid, balance, isapproved) VALUES (out_accountid, 0, in_approved);
	COMMIT;
END; /

/* creates a new account */
CREATE OR REPLACE PROCEDURE BANK_APP.create_account_with_primary(in_primaryid IN NUMBER, in_approved IN NUMBER, out_accountid OUT NUMBER) IS
v_accountid NUMBER;
BEGIN
	SELECT BANK_APP.accountid_seq.NEXTVAL INTO out_accountid FROM DUAL;
	INSERT INTO BANK_APP.Accounts (accountid, balance, isapproved, primaryuserid) VALUES (out_accountid, 0, in_approved, in_primaryid);
	INSERT INTO BANK_APP.User_Account_Joint (userid, accountid) VALUES (in_primaryid, out_accountid);
	COMMIT;
END; /

CREATE OR REPLACE PROCEDURE BANK_APP.set_primary_holder(in_userid IN NUMBER, in_accountid IN NUMBER) IS
v_userid NUMBER;
v_accountid NUMBER;
BEGIN
	SELECT userid INTO v_userid FROM BANK_APP.Users WHERE userid = in_userid;
	SELECT accountid INTO v_accountid FROM BANK_APP.Accounts WHERE accountid = in_accountid;
	UPDATE BANK_APP.Accounts SET primaryuserid = in_userid WHERE userid = in_userid;
	COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		NULL;
END; /

CREATE OR REPLACE PROCEDURE BANK_APP.unpend_account_primary(in_accountid IN NUMBER) IS
v_userid NUMBER;
BEGIN
	SELECT userid INTO v_userid FROM BANK_APP.Users WHERE userid =
		(SELECT primaryuserid FROM BANK_APP.Accounts WHERE accountid = in_accountid);
	UPDATE BANK_APP.Users SET pending = 0 WHERE userid = v_userid;
	COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		NULL;
END; /

/* sets the pending status of the customer to the given value, where 1 represents true, and 0 false */
CREATE OR REPLACE PROCEDURE BANK_APP.set_pending(in_userid IN NUMBER, in_pending IN NUMBER) IS
v_typename VARCHAR2(20);
BEGIN
	SELECT typename INTO v_typename FROM (BANK_APP.Users LEFT JOIN BANK_APP.User_Types USING (usertype)) WHERE userid = in_userid;
	IF v_typename = 'Customer' THEN
		UPDATE BANK_APP.Users u SET u.pending = in_pending WHERE u.userid = in_userid;
		COMMIT;
	END IF;
END; /

CREATE OR REPLACE PROCEDURE BANK_APP.approve_account(in_accountid IN NUMBER) IS
BEGIN
	UPDATE BANK_APP.Accounts SET isapproved = 1 WHERE accountid = in_accountid;
	COMMIT;
	unpend_account_primary(in_accountid);
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		NULL;
END; /

CREATE OR REPLACE PROCEDURE BANK_APP.delete_account(in_accountid IN NUMBER) IS
BEGIN
	DELETE FROM BANK_APP.User_Account_Joint WHERE accountid = in_accountid;
	DELETE FROM BANK_APP.Accounts WHERE accountid = in_accountid;
	COMMIT;
END; /

CREATE OR REPLACE PROCEDURE BANK_APP.withdraw(in_accountid IN NUMBER, in_amount IN NUMBER) IS
v_curr_bal NUMBER;
BEGIN
	SELECT balance INTO v_curr_bal FROM BANK_APP.Accounts WHERE accountid = in_accountid;
	IF in_amount > 0 AND in_amount <= v_curr_bal THEN
		UPDATE BANK_APP.Accounts SET balance = (balance - in_amount) WHERE accountid = in_accountid;
		COMMIT;
	END IF;
END; /

CREATE OR REPLACE PROCEDURE BANK_APP.deposit(in_accountid IN NUMBER, in_amount IN NUMBER) IS
BEGIN
	IF in_amount > 0 THEN
		UPDATE BANK_APP.Accounts SET balance = (balance + in_amount) WHERE accountid = in_accountid;
		COMMIT;
	END IF;
END; /

SELECT * FROM BANK_APP.User_Account_Joint;

CREATE OR REPLACE PROCEDURE BANK_APP.create_joint(in_userid IN NUMBER, in_accountid IN NUMBER) IS
v_userid NUMBER;
BEGIN
	SELECT userid INTO v_userid FROM BANK_APP.User_Account_Joint WHERE userid = in_userid AND accountid = in_accountid;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		INSERT INTO BANK_APP.User_Account_Joint VALUES (in_userid, in_accountid);
		COMMIT;
END; /

CREATE OR REPLACE PROCEDURE BANK_APP.destroy_joint(in_userid IN NUMBER, in_accountid IN NUMBER) IS
v_userid NUMBER;
BEGIN
	SELECT userid INTO v_userid FROM BANK_APP.User_Account_Joint WHERE userid = in_userid AND accountid = in_accountid;
	DELETE FROM BANK_APP.User_Account_Joint WHERE userid = in_userid AND accountid =  in_accountid;
	COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		NULL;
END; /
