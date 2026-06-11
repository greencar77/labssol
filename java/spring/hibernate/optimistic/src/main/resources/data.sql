insert into customer (id, name, email, version) values (100, 'Bob', 'bob@x.com', 1);
insert into customer (id, name, email, version) values (101, 'Mary', 'mary@x.com', 1);

insert into order_cust (id, customer_id, product_name, amount) values (100, 100, 'toothpaste', 20);
insert into order_cust (id, customer_id, product_name, amount) values (101, 100, 'apples', 50);