-- mysqld --skip-grant-tables;
-- mysql> create database bigroi_shop DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;


select * from product;
select * from user;

-- update user set UPDT_TMS=current_timestamp where USER_ID=18;

insert into user(FIRST_NAME, LAST_NAME, EMAIL, CRTD_TMS, UPDT_TMS, PHONE)
values ('Alexander', 'Medvedev', 'alex-medvedev@tut.by', current_timestamp, current_timestamp, '+375297505384');

select USER_ID from user where LAST_NAME='Medvedev';
select * from user_address;

insert into user_address(USER_ID, CITY, STREET_ADDR)
values ( (select USER_ID from user where LAST_NAME='Medvedev'), 'Minsk', 'ul. J. Kolasa, 1');

select * from purchase_order;

select * from product;
select * from purchase_order_product;

start transaction;

insert into purchase_order(USER_ID, DLRY_ADDR_ID, DLRY_DATE)
values (18, 5, current_date);

insert into purchase_order_product(ORDER_ID, PRODUCT_CODE, PRODUCT_PRICE, DISCOUNT, PRODUCT_QUANTITY)
values (last_insert_id(), 43, (select PRICE from product where code=43), 5, 2 );

insert into purchase_order_product(ORDER_ID, PRODUCT_CODE, PRODUCT_PRICE, DISCOUNT, PRODUCT_QUANTITY)
values (last_insert_id(), 45, (select PRICE from product where code=45), 5, 1 );

commit;


rollback;