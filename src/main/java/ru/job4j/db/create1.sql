create table categories (
    id serial primary key,
	name varchar(255)
);

create table states (
    id serial primary key,
	name varchar(255)
);


create table roles (
    id serial primary key,
	name varchar(255)
);

create table rules (
    id serial primary key,
	name varchar(255)
);

create table role_rules (
    role_id INT REFERENCES roles(id),
    rule_id INT REFERENCES rules(id),
    PRIMARY KEY (role_id, rule_id)
);

create table users (
    id serial primary key,
	name varchar(255),
	email varchar(255) UNIQUE,
	role_id int REFERENCES roles(id)	
);

create table items (
    id serial primary key,
	title varchar(255),
	user_id int REFERENCES users(id),
    state_id int REFERENCES states(id),
    category_id int REFERENCES categories(id)
);

create table comments (
    id serial primary key,
	text TEXT,
	item_id int REFERENCES items(id)
);

create table attachs (
    id serial primary key,
	filename varchar(255),
	item_id int REFERENCES items(id)
);
