-- liquibase formatted sql
-- changeset tienva:1.1

create table "company"
(
    id bigserial
        constraint company_pk
            primary key,
    name varchar(255) not null,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    is_deleted boolean default false
);

create table "user"
(
    id bigserial
        constraint user_pk
            primary key,
    name varchar(255) not null,
    company_id bigserial
        constraint fk_user_company
            references company(id),
    created_at timestamp default now(),
    updated_at timestamp default now(),
    is_deleted boolean default false
);


