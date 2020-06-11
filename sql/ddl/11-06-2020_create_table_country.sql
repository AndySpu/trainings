CREATE SEQUENCE country_id_seq INCREMENT 1 START 1000000;

CREATE TABLE master.country (
	id INT NOT NULL DEFAULT NEXTVAL('country_id_seq'),
	country varchar(20) NOT NULL,
	latitude int4 NOT NULL,
	longitude int4 NOT NULL,
	name varchar(100) NOT NULL,
	i timestamp,
	u timestamp
);

ALTER SEQUENCE country_id_seq OWNED BY country.id_country;

create or replace
function country_insert_i() returns trigger as $$
begin
    update country set (i, u) = (now(), now());
	return new;
end; $$
LANGUAGE PLPGSQL;

create or replace
function country_insert_u() returns trigger as $$
begin
	update country set (u) = (now());
	return new;
end; $$
LANGUAGE PLPGSQL;

create trigger country_insert
after insert on country
for each row execute
procedure country_insert_i();

create trigger country_update
after update on country
for each row execute
procedure country_insert_u();