--liquibase formatted sql

--changeset ilya:1
create table coffee_machines (
    id int generated by default as identity primary key,
    water_filled boolean not null default false,
    ground_coffee_filled boolean not null default false,
    coffee_boiled boolean not null default false,
    enabled boolean not null default false
);
--rollback drop table coffee_machines

--changeset ilya:2
insert into coffee_machines default values;
insert into coffee_machines default values;
insert into coffee_machines default values;
--rollback truncate table coffee_machines