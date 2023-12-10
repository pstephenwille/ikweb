-- http://sqlfiddle.com/#!15/bebec8/38


CREATE TABLE table2
(
    "customer_id" varchar(2),
    "service"     varchar(7),
    "start_date"  timestamp,
    "end_date"    varchar(10)
)
;

INSERT INTO table2
    ("customer_id", "service", "start_date", "end_date")
VALUES ('C1', 'netflix', '2021-01-01 00:00:00', '2021-02-01'),
       ('C1', 'prime', '2021-02-01 00:00:00', NULL),
       ('C2', 'netflix', '2021-01-01 00:00:00', NULL)
;

-------------------------------------------------

CREATE TABLE Table1
(
    "date_interaction" timestamp,
    "customer_id"      varchar(2)
)
;

INSERT INTO Table1
    ("date_interaction", "customer_id")
VALUES ('2020-03-01 00:00:00', 'C1'),
       ('2021-02-28 00:00:00', 'C1'),
       ('2021-02-28 12:10:00', 'C1'),
       ('2021-02-28 05:01:00', 'C2'),
       ('2022-01-23 00:00:00', 'C2'),
       ('2019-12-30 00:00:00', 'C3')
;

-------------------------------------------------

CREATE TABLE users
(
    "id"   varchar(2),
    "name" varchar(3)
)
;

INSERT INTO users
    ("id", "name")
VALUES ('U1', 'UN1'),
       ('U2', 'UN2')
;

CREATE TABLE user_follows
(
    "user_id"        varchar(3),
    "user_follow_id" varchar(2)
)
;

INSERT INTO user_follows
    ("user_id", "user_follow_id")
VALUES ('U1', 'U2'),
       ('U1', 'U3'),
       ('U1', 'U4'),
       ('U2', 'U1'),
       ('U3', 'U2'),
       ('U4', 'U2'),
       ('U5', 'U2'),
       ('U6', 'U2'),
       ('U7', 'U2'),
       ('U8', 'U2'),
       ('U9', 'U2'),
       ('U10', 'U2'),
       ('U11', 'U2'),
       ('U12', 'U2')
;



-------------------------------------------------
-- for very city what is the top selling product
-- http://sqlfiddle.com/#!15/bebec8/38

CREATE TABLE sales
(
    "product_id"   varchar(3),
    "product_name" varchar(4),
    "city"         varchar(9),
    "date"         timestamp,
    "sales_amount" int
)
;

INSERT INTO sales
    ("product_id", "product_name", "city", "date", "sales_amount")
VALUES ('P7', 'PN7', 'Seattle', '2021-02-09 00:00:00', 700),
       ('P1', 'PN1', 'Seattle', '2021-02-05 00:00:00', 900),
       ('P1', 'PN1', 'Seattle', '2021-02-08 00:00:00', 300),
       ('P1', 'PN1', 'Portland', '2021-02-03 00:00:00', 100),
       ('P2', 'PN2', 'Chicago', '2021-02-04 00:00:00', 200),
       ('P3', 'PN3', 'Austin', '2021-02-05 00:00:00', 300),
       ('P4', 'PN4', 'Chicago', '2021-02-06 00:00:00', 400),
       ('P5', 'PN5', 'Spokane', '2021-02-07 00:00:00', 500),
       ('P6', 'PN6', 'Austin', '2021-02-08 00:00:00', 600),
       ('P8', 'PN8', 'Portland', '2021-02-10 00:00:00', 800),
       ('P9', 'PN9', 'Vancouver', '2021-02-11 00:00:00', 900),
       ('P10', 'PN10', 'Spokane', '2021-02-12 00:00:00', 1000)
;


-------------------------------------------------

CREATE TABLE customers
(
    "customer_id"   varchar(2),
    "customer_name" varchar(5)
)
;

INSERT INTO customers
    ("customer_id", "customer_name")
VALUES ('c1', 'John'),
       ('c2', 'Susan'),
       ('c3', 'Mike'),
       ('c4', 'Emma')
;


CREATE TABLE orders
(
    "order_id"    int,
    "customer_id" varchar(2)
)
;

INSERT INTO orders
    ("order_id", "customer_id")
VALUES (1, 'c1'),
       (2, 'c2'),
       (3, 'c3'),
       (4, 'c4'),
       (5, 'c1'),
       (6, 'c1'),
       (7, 'c4'),
       (8, 'c2'),
       (9, 'c2'),
       (10, 'c3'),
       (11, 'c2')
;

-- What is the difference between following 2 queries?

SELECT c.customer_id, o.order_id
FROM customers c
         LEFT JOIN orders o
                   ON c.customer_id = o.customer_id
                       AND o.customer_id = 'c1';

SELECT c.customer_id, o.order_id
FROM customers c
         LEFT JOIN orders o
                   ON c.customer_id = o.customer_id
WHERE o.customer_id = 'c1';

-------------------------------------------------

CREATE TABLE sales
(
    "sales_date"   timestamp,
    "sales_amount" int,
    "currency"     varchar(3)
)
;

INSERT INTO sales
    ("sales_date", "sales_amount", "currency")
VALUES ('2020-01-01 00:00:00', 500, 'INR'),
       ('2020-01-01 00:00:00', 100, 'GBP'),
       ('2020-01-02 00:00:00', 1000, 'INR'),
       ('2020-01-02 00:00:00', 500, 'GBP'),
       ('2020-01-03 00:00:00', 500, 'INR'),
       ('2020-01-17 00:00:00', 200, 'GBP')
;


CREATE TABLE exchange_rates
(
    "source_currency"      varchar(3),
    "target_currency"      varchar(3),
    "exchange_rate"        numeric,
    "effective_start_date" timestamp
)
;

INSERT INTO exchange_rates
("source_currency", "target_currency", "exchange_rate", "effective_start_date")
VALUES ('INR', 'USD', 0.01, '2019-12-31 00:00:00'),
       ('INR', 'USD', 0.02, '2020-01-02 00:00:00'),
       ('GBP', 'USD', 1.32, '2019-12-20 00:00:00'),
       ('GBP', 'USD', 1.3, '2020-01-01 00:00:00'),
       ('GBP', 'USD', 1.35, '2020-01-16 00:00:00')
;

