create table soloist(
    id serial primary key,
    name varchar(255)
);

create table music(
    id serial primary key,
    name varchar(255)
);

create table music_band(
    id serial primary key,
    soloist_id int references soloist(id),
    music_id int references music(id)
);

insert into soloist(name) values ('Kurt');
insert into soloist(name) values ('Shawn');

insert into music(name) values ('Nirvana');
insert into music(name) values ('Slipknot');

insert into music_band(soloist_id, music_id) values (1, 1);
insert into music_band(soloist_id, music_id) values (1, 2);

select * from music_band;