create table license(
id serial primary key,
    number int
);

create table driver(
    id serial primary key,
    name varchar(255),
    license_id int references license(id) unique
);

insert into license(number) values (123456);
insert into driver(name, license_id) values ('Albert', 1);

select * from license;
select * from driver;