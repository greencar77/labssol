insert into customer (id, name, email) values (next value for customer_seq, 'Bob', 'bob@x.com');
insert into customer (id, name, email) values (next value for customer_seq, 'Mary', 'mary@x.com');

insert into order_cust (id, customer_id, product_name, amount) values (100, (select id from customer where name = 'Bob'), 'toothpaste', 20);
insert into order_cust (id, customer_id, product_name, amount) values (101, (select id from customer where name = 'Bob'), 'apples', 50);