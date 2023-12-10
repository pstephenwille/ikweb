# SELECT

order of ops

1. from - DCL
2. where - DCL
3. groupby - DML
4. having - DML
5. select - DQL
6. order by - DML
7. limit - DML

### w3c sql

### CustomerID	CustomerName	ContactName	Address	City	PostalCode	Country

### select count of users with followers < 10, and less than 10

```sql
select case
           when num_user_follows > 10 then 'gt 10'
           else 'lt 10' end as followers_bucket,
       Count(user_id)       as num_users
from (
         select uf.user_id, u.name, count(uf.user_follow_id) as num_user_follows
         from user_follows uf
                  join Users u on uf.user_id = u.id
         group by 1, 2
     )
group by 1
```

## window/analytical functions

-- for very city what is the top selling product

```sql
select *
from (select product_id,
             product_name,
             city,
             sales_amount,
             ROW_NUMBER() over (partition by city order by sales_amount desc) as rnk
      from sales) as foo
where foo.rnk = 1

;


select product_id, product_name, city
from (
         select product_id,
                product_name,
                city,
                ROW_NUMBER() over (partition by city
                    order by total_sales desc) as rnk
         from (
                  select product_id, product_name, city, Sum(sales_amount) as total_sales
                  from sales
                  group by 1, 2, 3
              ) as ugh
     ) as foo
where rnk = 1
```

```sql

select product_id, product_name, city
from (
         select product_id,
                product_name,
                city,
                ROW_NUMBER() over (partition by city
                    order by total_sales desc) as rnk
         from (
                  select product_id, product_name, city, Sum(sales_amount) as total_sales
                  from sales
                  group by 1, 2, 3
              ) as ugh
     ) as foo
where rnk = 1
;
```

## exchange rates

converts local currency to USD in the Sales table, and show rates applied based on sale_date, effective_start_date

-- sale_date | sales_amount_usd | source_currency | rate

```sql



```
