use banking_system;
create table accounts(
account_number bigint not null primary key default(null) ,
full_name varchar(255) not null default(null),
email varchar(255) not null unique default(null),
balance decimal(4) not null default(null),
security_pin char(4) not null default(null)
);
select* from accounts;
ALTER TABLE accounts ADD security_pin CHAR(4) not null default(null);
select * from accounts;
alter table accounts modify balance decimal(10,2) not null default(null);