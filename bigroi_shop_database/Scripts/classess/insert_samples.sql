-- mysqld --skip-grant-tables;

select * from product;
select * from user;

-- update user set UPDT_TMS=current_timestamp where USER_ID=18;

insert into user(FIRST_NAME, LAST_NAME, EMAIL, CRTD_TMS, UPDT_TMS, PHONE)
values ('Alexander', 'Medvedev', 'alex-medvedev@tut.by', current_timestamp, current_timestamp, '+375297505384');

select USER_ID from user where LAST_NAME='Medvedev';
select * from user_address;

insert into user_address(USER_ID, CITY, STREET_ADDR)
values ( (select USER_ID from user where LAST_NAME='Medvedev'), 'Minsk', 'ul. J. Kolasa, 1');

start transaction;
insert into purchase_order(USER_ID, STATUS_CD, )
commit;