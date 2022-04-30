---QUERY BASICS!!!!-----

DESC employee;
--SELECT [column1, column2, etc] FROM [the table name];
SELECT lastname, firstname FROM employee;
--SELECT *   <------the '*' means all columns
SELECT * FROM employee;
--ALIAS (using the "AS" keyword) changes the title of the attribute in a result set
SELECT lastname AS muffin, firstname AS button FROM employee;


---DIFFERENT SELECTS
SELECT * FROM employee;
SELECT * FROM employee WHERE title='Sales Manager';
SELECT * FROM employee WHERE title='Sales Support Agent' AND  firstname='Jane';
SELECT * FROM employee WHERE firstname='Andrew' OR firstname='Nancy' OR firstname='Margaret';
----ALSO, you can use >, <, <=, >= in the where clause
SELECT * FROM employee 
            WHERE reportsto>1; --they can be on separate lines, that is fine.
--different ways to say "not equals"
SELECT * FROM employee WHERE NOT firstname='Andrew';
SELECT * FROM employee WHERE firstname != 'Andrew';
SELECT * FROM employee WHERE firstname <> 'Andrew';
SELECT * FROM employee WHERE firstname ^= 'Andrew';

--NULL REFERENCES
--this won't function as we expect
--SELECT * FROM employee WHERE reportsto = null;
SELECT * FROM employee WHERE reportsto IS NULL;
SELECT * FROM employee WHERE reportsto IS NOT NULL;



DESC album;
SELECT * FROM album;
--LIKE keyword, finds patterns in attributes
---'%' is a wildcard that replaces 0 or more characters
---'_' is a wildcard that replaces a SINGLE character
SELECT * FROM album WHERE title LIKE 'B%';
SELECT * FROM album WHERE title LIKE '%Big Ones';
SELECT * FROM album WHERE title LIKE '%i% %ne%';
SELECT * FROM album WHERE title LIKE '_ig%O_es';

DESC employee;
SELECT * FROM employee;
-----ORDER BY examples------aka sorting
----DEFAULTS to ascending order
SELECT * FROM employee ORDER BY lastname;
SELECT * FROM employee ORDER BY lastname DESC;
SELECT * FROM employee ORDER BY lastname ASC;
--sorting by title, and in the case where they are the same fallback to sorting by firstname
SELECT * FROM employee ORDER BY title ASC, firstname DESC;

SELECT * FROM employee;
---BETWEEN keyword
---inclusive range
SELECT * FROM employee WHERE  employeeid BETWEEN 5 AND 7;
SELECT * FROM employee WHERE  employeeid BETWEEN 5 AND 7 AND title='IT Staff';


--IN keyword
---IN creates a set of possibilities
SELECT * FROM employee WHERE firstname='Andrew'
        OR firstname='Nancy' OR firstname='Margaret';
SELECT * FROM employee WHERE firstname IN('Andrew', 'Nancy', 'Margaret');


----AGGREGATE functions
--what is an aggregate function?
--------a calculation operation on a group of records (aka data entries)
--different aggregate functions
-----COUNT, MAX, MIN, AVG, SUM, DISTINCT
-------------there are more but I want to highlight these
SELECT * FROM album;
SELECT COUNT(*) FROM album;
SELECT * FROM employee;
SELECT COUNT(*) FROM employee WHERE title='Sales Support Agent';
SELECT COUNT(title) FROM employee;
--how do we get unique titles?
SELECT COUNT(DISTINCT(title)) FROM employee;

SELECT * FROM invoice;
--OTHER AGGREGATE examples
SELECT invoiceid, customerid, total FROM invoice;
SELECT MAX(total) FROM invoice;
SELECT MIN(total) FROM invoice;
SELECT AVG(total) FROM invoice;
SELECT SUM(total) FROM invoice;

--GROUP BY examples
--forces aggregate functions to work on subsets of grouped data as opposed
--- to the entire result set
SELECT COUNT(*) AS sales, billingcountry FROM invoice GROUP BY billingcountry;

--HAVING example
---when group by is NOT used HAVING behaves like WHERE
----WHERE filters BEFORE aggregate functions, HAVING may filter after
SELECT billingcountry, SUM(total) FROM invoice GROUP BY billingcountry;
SELECT billingcountry, SUM(total) FROM invoice  WHERE total>50 GROUP BY billingcountry;

SELECT billingcountry, SUM(total) FROM invoice GROUP BY
        billingcountry HAVING SUM(total)<50;
---WHERE goes before GROUP BY goes before HAVING



----SCALAR functions----
---THE FOLLOWING IS MY OWN TERMS, OTHERS MAY NOT KNOW WHAT YOU'RE TALKING ABOUT
--CATEGORIES of scalar functions:
----    numeric, character, date, conversion

--first, what is dual?
SELECT 'hello world' FROM dual;
SELECT 5*7 FROM dual;
SELECT * FROM dual;

--NUMERIC
--      abs(x), ceil(x), floor(x), trunc(x,y), round(x,y)
SELECT abs(-99) FROM dual;
SELECT floor(88.77) FROM dual;
SELECT ceil(88.77) FROM dual;
SELECT trunc(888.7238577383, 4) FROM dual;
--CHARACTER   there are lots of these. Including BUT not limited to:
--      upper(x), lower(x), length(x)
SELECT 'HELLO wOrlD' FROM dual;
SELECT upper('HELLO wOrlD') FROM dual;
SELECT lower('HELLO wOrlD') FROM dual;
SELECT length('HELLO wOrlD') FROM dual;
--DATE    there are lots of these
----      next_day(x, 'week_day'), last_day(x), sysdate
SELECT sysdate FROM dual;
SELECT last_day(sysdate) FROM dual;
SELECT next_day(sysdate, 'Friday')  FROM dual;
--CONVERSIONS     convert data types
--    to_char(), to_date(),   and more
---we'll ignore the example for now

SELECT * FROM invoice;
SELECT billingcountry, billingcity FROM invoice;
SELECT upper(billingcountry), billingcity FROM invoice;
--SO.....what does a scalar function actually do?
-- it's an operation that works on a SINGLE record entry, as opposed to an aggragate
-- function that works on a set of data


-----SUBQUERY EXAMPLE------AKA nested queries
DESC customer;
SELECT * FROM customer;
SELECT * FROM invoice;

SELECT * FROM customer WHERE customerid IN(
    SELECT customerid FROM invoice WHERE total>16.0);
-----the INNER query is difing a set of customerids that the OUTER query will
--          choose from. For this reason, the INNER query must be completed first.

--more subqueries
SELECT customerid, total, invoiceid FROM (SELECT * FROM invoice WHERE total>16.0)
    WHERE invoiceid>200;







