--pets_db
drop database if exists pets-db;
create database pets_db;

--pets
CREATE TABLE IF NOT EXISTS pets
(
    pet_id          serial primary key,
    owner_id        integer references owners(owner_id),
    pet_name        varchar(100) NOT NULL,
    pet_age         integer NOT NULL,
    pet_health      integer NOT NULL,
    pet_type_id     integer references pet_types(pet_type_id)
);

--owners
CREATE TABLE IF NOT EXISTS owners
(
    owner_id        serial primary key,
    owner_name      varchar(100) NOT NULL,
    owner_age       integer
);

--pet_types
CREATE TABLE IF NOT EXISTS pet_types
(
    pet_type_id        serial primary key,
    pet_type           varchar(100) NOT NULL
);

------INSERTS------

INSERT INTO owners (owner_name, owner_age)
VALUES('Jenny', 22), ('Gareth', 25);

INSERT INTO pet_types (pet_type)
VALUES('guinea pig'),('cat'),('pig'),('dog');