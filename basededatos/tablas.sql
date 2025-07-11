drop schema if exists public cascade;
create schema public;

create table grupo(
    id serial not null primary key,
    codigo varchar default '',
    nombre varchar default ''
);

create table fabricante(
    id serial not null primary key,
    nombre varchar default ''
);

create table precio(
    id serial not null primary key,
    nombre varchar default ''
);

