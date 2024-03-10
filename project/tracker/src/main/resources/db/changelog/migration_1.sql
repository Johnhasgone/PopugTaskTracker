create table account (
                         id uuid primary key,
                         name varchar(250) not null,
                         role smallint
);

create table task (
    id uuid primary key,
    status smallint not null,
    description text,
    account_id uuid references account(id)
)