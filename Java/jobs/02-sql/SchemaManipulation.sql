----is sql case sensitive?
--SELECT * FROM artist;
--select * from artist;



----NOW FOR SCHEMA MANIPULATION!!!!!!!

-------CREATE A TABLE
--DATATYPES IN SQL: NUMBER, VARCHAR, VARCHAR2, DATE, TIMESTAMP, BLOB, CLOB
-----
--CONSTRAINTS: primary key, foreign key, unique, not null, and check
--NOT NULL ensure the record has a value in this column
--UNIQUE ensures that any two records will not have the same value
--PRIMARY KEY it represents the official unique identifier for the table
----PK is a combination of unique and not null
--FOREIGN KEY is a reference pointer to another table's primary key
----example syntax: PRIMARY KEY (refKey from THIS table)
----FK is used as a locator (locates another record)
----example syntax: FOREIGN KEY (reference_attribute_from_this_table)
----            REFERENCES other_table (PK_from_other_table)
--CHECK creates an additional custom condition for the column
----example syntax:   CONSTRAINT constraint_name CHECK (column_name >15)
CREATE TABLE pokemon(
    pokemon_id NUMBER(15) PRIMARY KEY,
    pokemon_name VARCHAR2(100),
    pokemon_type VARCHAR2(25)
    --PRIMARY KEY(pokemon_id)
);

--describes the structure of the table
DESC pokemon;

--DDL:    drop
DROP TABLE pokemon;
--DDL:    alter
ALTER TABLE pokemon ADD pokemon_secondtype VARCHAR2(25);
--DDL:     truncate
/*not going to do an example BUT truncate deletes all entries into the table
 while keeping the table structure intact. DROP is like throwing a cup of water
 into the trash, while TRUNCATE is like pouring out the water and keeping the cup.
*/



--this is how you view all entries into a table
SELECT * FROM pokemon;


--DML:    insert
INSERT INTO pokemon VALUES(1,'bulbasaur', 'grass', 'ice');
INSERT INTO pokemon VALUES(7, 'squirtle', 'water', null);
INSERT INTO pokemon VALUES(121, 'starmie', 'water', 'psychic');
INSERT INTO pokemon VALUES(6, 'charizard', 'fire', 'flying');
INSERT INTO pokemon(pokemon_id, pokemon_type, pokemon_name)
        VALUES(9, 'water', 'blastoise');
        
--DML:    update
UPDATE pokemon SET pokemon_secondtype='poison' WHERE pokemon_id=1;
--DML:    delete
DELETE FROM pokemon WHERE pokemon_id=9;
DELETE FROM pokemon;

--what happens if I try to use the primary key a second time
INSERT INTO pokemon VALUES(121, 'duplicatemon', 'flying', 'psychic');

--remoteaws example
INSERT INTO pokemon VALUES(1000, 'Danny Boy', 'psychic', 'techno');
INSERT INTO pokemon VALUES(1001, 'Asura', 'tank', 'hair manipulator');

commit;
rollback;