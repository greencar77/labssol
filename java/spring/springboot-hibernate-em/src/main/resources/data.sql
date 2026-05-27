--Q07M
insert into customer (id, name, email) values (100, 'Bob', 'bob@x.com');
insert into customer (id, name, email) values (101, 'Mary', 'mary@x.com');

insert into order_cust (id, customer_id, product_name, amount) values (100, 100, 'toothpaste', 20);
insert into order_cust (id, customer_id, product_name, amount) values (101, 100, 'apples', 50);