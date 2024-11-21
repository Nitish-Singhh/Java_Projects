use banking_system;
create table user
(
full_name varchar(255) not null default(null),
email varchar(255) not null primary key default(null),
password varchar(255) not null default(null)
);
select * from user;