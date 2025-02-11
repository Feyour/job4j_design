create table license
(
    id             serial primary key,
    driver         varchar(255),
    number         int
);

create table people
(
    id             serial primary key,
    name           varchar(255),
    age            int,
    license_id int references license(id) unique
);

insert into license(driver, number) values ('Albert', 362901);
insert into license(driver, number) values ('Alex', 094673);
insert into license(driver, number) values ('Maria', 785643);

insert into people(name, age, license_id) values ('Albert', 23, 1);
insert into people(name, age, license_id) values ('Alex', 56, 2);
insert into people(name, age, license_id) values ('Maria', 18, 3);