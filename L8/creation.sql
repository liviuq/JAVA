drop table continents;
create table continents
(
    id int,
    name varchar
);

drop table countries;
create table countries
(
    id int,
    name varchar,
    code varchar,
    continent varchar
);

drop table capitals;
create table capitals
(
    country varchar,
    name varchar,
    latitude float(15),
    longitude float(15),
    code varchar,
    continent varchar
);
select * from capitals;
select * from capitals where trim(lower(name)) = 'Paris';

delete from continents where id = 1;
select * from continents;
insert into continents values (1, 'Australia');
insert into continents values (2, 'Europe');