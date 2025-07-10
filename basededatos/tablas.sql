drop schema if exists public cascade;
create schema public;

create table grupo(
    id serial not null primary key,
    codigo varchar default '',
    grupo varchar default ''
);

