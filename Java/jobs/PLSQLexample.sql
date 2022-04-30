	private static String url = "jdbc:oracle:thin:@bankaccountdb.csylxpgfy4vi.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "jaeNwawe";
	private static String password = "classTime";
	

---PL/SQL example

--let's create a user
CREATE USER fooduser IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO fooduser;
GRANT DBA TO fooduser WITH ADMIN OPTION;


--creating food table
CREATE TABLE food(
    food_id NUMBER(15),
    food_name VARCHAR2(100) UNIQUE,
    recipe VARCHAR2(500) NOT NULL,
    PRIMARY KEY(food_id)
);

INSERT INTO food VALUES(1, 'banana', '...its bananas');
INSERT INTO food VALUES(4, 'jackfruit', '...just press backspace');
INSERT INTO food VALUES(7, 'orange', '...we fear complexity?');
INSERT INTO food VALUES(8, 'jambalaya', '...its...spelled with all "a"s?');

SELECT * FROM food;

--STORED PROCEDURES
---They are blocks of code. Essentially, they are functions
DROP PROCEDURE hello_world_procedure;
CREATE OR REPLACE PROCEDURE hello_world_procedure
IS

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD!');
END;
/
--HOW TO EXECUTE A STORED PROCEDURE
BEGIN
    hello_world_procedure();
END;
/


--STRUCTURE OF A PROCEDURE IN SQL
/*
CREATE [OR REPLACE] PROCEDURE proc_name [list of parameters]
IS
    *declaration section*
BEGIN
    *execution section*
EXCEPTION
    *exeception section*
END;
/   <----NOTE THAT THERE IS A SLASH AT THE END OF THE PROCEDURE/FUNCTION
*/

-------INSERT stored procedure
CREATE OR REPLACE PROCEDURE insert_food(f_id IN NUMBER, f_name IN VARCHAR2,
                            f_recipe IN VARCHAR2)
IS
BEGIN
    INSERT INTO food VALUES (f_id, f_name, f_recipe);
    COMMIT;
END;
/
--executing
BEGIN
    insert_food(10, 'bacon', 'love');
END;
/
SELECT * FROM food;

--------OUT example
CREATE OR REPLACE PROCEDURE get_food(f_id IN NUMBER,
                                f_name OUT food.food_name%TYPE)
IS
BEGIN
    SELECT food_name INTO f_name FROM food WHERE food_id=f_id;
END;
/
--EXE block
DECLARE
    tempVariable VARCHAR2(4000);
BEGIN
    get_food(10, tempVariable);
    DBMS_OUTPUT.PUT_LINE('solution: ' || tempVariable);
END;
/

-----------FUNCTION---------
---They are blocks of code. They are literally functions
CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS
    max_id NUMBER;
BEGIN
    SELECT MAX(food_id) INTO max_id FROM food;
    RETURN max_id;
    --the "INTO" keyword is the assignment operator just like "=" in java
END;
/
--call get_max_id
DECLARE
    max_id NUMBER;
BEGIN
    max_id := get_max_id();
    -- ":=" is also an assignment operator just like "=" in java
    DBMS_OUTPUT.PUT_LINE('THE MAX: ' || max_id);
END;
/
--select * from food;

CREATE OR REPLACE FUNCTION get_max(num1 IN NUMBER, num2 IN NUMBER)
RETURN NUMBER
IS
BEGIN
    IF num1>num2 THEN
            RETURN num1;
    ELSE
        RETURN num2;
    END IF;
END;
/
--EXEC
DECLARE
    greater NUMBER;
BEGIN
    greater := get_max( 5500, 26000);
    DBMS_OUTPUT.PUT_LINE('max num is: ' || greater);
END;
/
--we want to exec again....
SELECT get_max(330, 4) FROM dual;



SELECT * FROM food;
-----SEQUENCES-----
CREATE SEQUENCE food_seq
    START WITH 151
    INCREMENT BY 4;
--how to drop a seq?
DROP SEQUENCE food_seq;
-------
CREATE OR REPLACE PROCEDURE insert_food_null_id(f_name IN VARCHAR2,
                f_recipe IN VARCHAR2)
IS
BEGIN
    INSERT INTO food VALUES(food_seq.NEXTVAL, f_name, f_recipe);
    COMMIT;
END;
/
--exec
BEGIN
    --insert_food_null_id('yams', '...my mans Gio knows whats up');
    insert_food_null_id('dumplings', 'tasty');
    --insert_food_null_id('sushi', 'tasty');
    --insert_food_null_id('dumplings', 'tasty');
END;
/
INSERT INTO food VALUES(null, 'stuff', 'other stuff');
SELECT * FROM food;



----TRIGGERS
--a trigger is essentially an event listener

CREATE OR REPLACE TRIGGER food_insertb
BEFORE INSERT ON food
FOR EACH ROW
BEGIN
    IF :new.food_id IS NULL THEN
        SELECT food_seq.NEXTVAL INTO :new.food_id FROM dual;
    END IF;
END;
/
--DROP TRIGGER food_insertb;

INSERT INTO food VALUES(null, 'stuff', 'other stuff');
SELECT * FROM food;

/*
CREATE [OR REPLACE] TRIGGER trigger_name
BEFORE | AFTER        INSERT | UPDATE | DELETE
ON table_name
FOR EACH ROW     <-----required if you want to see/manipulate rows of data
DECLARE
BEGIN
EXCEPTION
END;
/   <------slash
*/



/*
stored procedures        vs                   functions

EXECUTED INSTRUCTION                    MUST return a value or set
DML,  DQL                 -              SELECT ONLY
IN/OUT parameters (values and references) -      only IN
procedures can call functions    -       cannot called procedures
execution block         -            can be used in queries OR execution blocks
(yes, you can use a procedure inside of a procedure)



Cursor-
-  a cursor is a temporary work area created in the system memory when a SQL
    statement is executed. A cursor contains information on a select statement
    and the rows of data accessed by it.
    (basically, it points to a result set)    

View-
In sql, a view is a virtual table based on the result-set of a SQL statement.
A view contains rows and columns, just like a real table. The fields in a view
are fields from one or more real tables in the database. You can add SQL functions,
 WHERE, and JOIN statements to a view and present that data as if the data were
 coming from one single table.
*/

COMMIT;








