SELECT * FROM album;
SELECT * FROM artist;


--INNER
SELECT * FROM artist a INNER JOIN album b ON a.artistid = b.artistid;
SELECT a.artistid, b.albumid as ALBUM FROM artist a INNER JOIN album b ON a.artistid = b.artistid;
--old way to use an inner join
SELECT * FROM artist a, album b WHERE a.artistid=b.artistid;

--LEFT
SELECT * FROM artist a LEFT OUTER JOIN album b ON a.artistid = b.artistid;
--older way to do left join
SELECT * FROM artist a, album b WHERE a.artistid=b.artistid(+);


--RIGHT
SELECT * FROM artist a RIGHT OUTER JOIN album b ON a.artistid = b.artistid;
--NOTE: we don't need the outer keyword, it's strictly for readability
--older way to do right join
SELECT * FROM artist a, album b WHERE a.artistid(+)=b.artistid;


--FULL
SELECT * FROM artist a FULL OUTER JOIN album b ON a.artistid=b.artistid;


--LEFT without middle of vendiagram, 
--          (excluded aka distinct aka strictly left outer join)
SELECT * FROM artist a LEFT OUTER JOIN album b ON a.artistid=b.artistid
    WHERE a.artistid NOT IN(
        SELECT c.artistid FROM artist c INNER JOIN album d ON c.artistid=d.artistid);
--ANOTHER way to do the exact same thing
SELECT * FROM artist a LEFT OUTER JOIN album b ON a.artistid = b.artistid
    WHERE b.artistid IS NULL;

--DISTINCT FULL join
SELECT * FROM artist a FULL OUTER JOIN album b ON a.artistid = b.artistid
    WHERE b.artistid IS NULL OR a.artistid IS NULL;


--SELF JOIN
-----SELECT * FROM table01 A INNER JOIN table01 B ON A.id=B.foreignid;


--CROSS JOIN aka CARTESIAN JOIN
----SELECT * FROM table01 CROSS JOIN table02;