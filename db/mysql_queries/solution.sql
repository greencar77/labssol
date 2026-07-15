#Exercise 1 (QQ3J)
select c.first_name, c.last_name, count(*) as rnt_cnt
from rental r, customer c
where r.customer_id = c.customer_id 
group by r.customer_id
order by rnt_cnt desc;


#Exercise 2 (QATM)
select f.title, f.release_year , f.rental_rate 
from film f left join inventory i on f.film_id = i.film_id
where i.film_id is null;


#Exercise 3 (QHMT)
select c.name , count(*) as rent_cnt, sum(p.amount) as paym_sum
from category c, film_category fc , film f , inventory i , rental r, payment p 
where c.category_id = fc.category_id and fc.film_id =f.film_id and f.film_id =i.film_id and i.inventory_id =r.inventory_id and p.rental_id =r.rental_id 
group by c.category_id
order by paym_sum desc;


#Exercise 4 (Q0ZA)
select concat(a.first_name, ' ',  a.last_name)
, (select count(*) from actor a2, film_actor fa2 where a2.actor_id =fa2.actor_id and a2.actor_id=a.actor_id) as f_cnt
from actor a
order by f_cnt desc
limit 5
;


#Exercise 5 (QTG7)
select distinct c.customer_id, r.rental_id 
from customer c, rental r , inventory i , store s
where r.inventory_id =i.inventory_id
    and i.store_id =s.store_id and r.customer_id =c.customer_id
order by c.customer_id, r.rental_id
;


select distinct c.customer_id, count(r.rental_id) as r_cnt
from customer c, rental r , inventory i , store s
where r.inventory_id =i.inventory_id
    and i.store_id =s.store_id and r.customer_id =c.customer_id
group by c.customer_id
order by c.customer_id
;

#not quietly following a hint to use 'COUNT(DISTINCT ...)'
select * from (
select distinct c.customer_id, count(r.rental_id) as r_cnt
from customer c, rental r , inventory i , store s
where r.inventory_id =i.inventory_id
    and i.store_id =s.store_id and r.customer_id =c.customer_id
group by c.customer_id
order by c.customer_id
) x
where x.r_cnt>1
;

#Exercise Bonus (Q3N7)
--not a solution

select concat(c.first_name, ' ',  c.last_name) as cc, cat.name 
  , count(r.rental_id) as rnt_cnt
from customer c, rental r, inventory i , film f, film_category fc , category cat
where c.customer_id =r.customer_id and r.inventory_id =i.inventory_id and i.film_id =f.film_id and f.film_id =fc.film_id and fc.category_id =cat.category_id
group by c.customer_id, cat.category_id 
order by cc, cat.name
;