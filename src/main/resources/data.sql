create table records (
    id uuid not null primary key,
    create_time timestamp not null,
    edit_time timestamp not null,
    title varchar(100) not null,
    content text
);
