--liquibase formatted sql

--changeset ilya:1
create table coffee_machines (
    id int generated by default as identity primary key,
    water_filled boolean not null default false,
    ground_coffee_filled boolean not null default false,
    coffee_filled boolean not null default false,
    enabled boolean not null default false
);
--rollback drop table coffee_machines