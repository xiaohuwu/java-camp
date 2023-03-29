########################################
# MySQL Crash Course
# http://www.forta.com/books/0672327120/
# Example table creation scripts
########################################


########################
# Create customers table
########################
CREATE TABLE customers
(
  cust_id      int       NOT NULL AUTO_INCREMENT,
  cust_name    char(50)  NOT NULL ,
  cust_address char(50)  NULL ,
  cust_city    char(50)  NULL ,
  cust_state   char(5)   NULL ,
  cust_zip     char(10)  NULL ,
  cust_country char(50)  NULL ,
  cust_contact char(50)  NULL ,
  cust_email   char(255) NULL ,
  PRIMARY KEY (cust_id)
) ENGINE=InnoDB;

#########################
# Create orderitems table
#########################
CREATE TABLE orderitems
(
  order_num  int          NOT NULL ,
  order_item int          NOT NULL ,
  prod_id    char(10)     NOT NULL ,
  quantity   int          NOT NULL ,
  item_price decimal(8,2) NOT NULL ,
  PRIMARY KEY (order_num, order_item)
) ENGINE=InnoDB;


#####################
# Create orders table
#####################
CREATE TABLE orders
(
  order_num  int      NOT NULL AUTO_INCREMENT,
  order_date datetime NOT NULL ,
  cust_id    int      NOT NULL ,
  PRIMARY KEY (order_num)
) ENGINE=InnoDB;

#######################
# Create products table
#######################
CREATE TABLE products
(
  prod_id    char(10)      NOT NULL,
  vend_id    int           NOT NULL ,
  prod_name  char(255)     NOT NULL ,
  prod_price decimal(8,2)  NOT NULL ,
  prod_desc  text          NULL ,
  PRIMARY KEY(prod_id)
) ENGINE=InnoDB;

######################
# Create vendors table
######################
CREATE TABLE vendors
(
  vend_id      int      NOT NULL AUTO_INCREMENT,
  vend_name    char(50) NOT NULL ,
  vend_address char(50) NULL ,
  vend_city    char(50) NULL ,
  vend_state   char(5)  NULL ,
  vend_zip     char(10) NULL ,
  vend_country char(50) NULL ,
  PRIMARY KEY (vend_id)
) ENGINE=InnoDB;

###########################
# Create productnotes table
###########################
CREATE TABLE productnotes
(
  note_id    int           NOT NULL AUTO_INCREMENT,
  prod_id    char(10)      NOT NULL,
  note_date datetime       NOT NULL,
  note_text  text          NULL ,
  PRIMARY KEY(note_id),
  FULLTEXT(note_text)
) ENGINE=MyISAM;


#####################
# Define foreign keys
#####################
ALTER TABLE orderitems ADD CONSTRAINT fk_orderitems_orders FOREIGN KEY (order_num) REFERENCES orders (order_num);
ALTER TABLE orderitems ADD CONSTRAINT fk_orderitems_products FOREIGN KEY (prod_id) REFERENCES products (prod_id);
ALTER TABLE orders ADD CONSTRAINT fk_orders_customers FOREIGN KEY (cust_id) REFERENCES customers (cust_id);
ALTER TABLE products ADD CONSTRAINT fk_products_vendors FOREIGN KEY (vend_id) REFERENCES vendors (vend_id);

select order_num
from orderitems
where prod_id = 'TNT2';


select * from customers
where cust_id in(select cust_id
            from orders
            where order_num in (select order_num
                                from orderitems
                                where prod_id = 'TNT2'));

select cust_name,cust_state,
       (select count(*)
       from orders
       where customers.cust_id = customers.cust_id) as orders
from customers;

select c.cust_id,c.cust_name,cust_state,count(*) as orders
from orders
inner join customers c on orders.cust_id = c.cust_id
group by c.cust_id;


select * from orderitems;
start transaction;
delete from orderitems;
select * from orderitems;
rollback;
select * from orderitems;



SELECT *
INTO OUTFILE '/tmp/orderitems.csv'
    FIELDS TERMINATED BY ','
    LINES TERMINATED BY '\n'
FROM orderitems;

show create table orderitems;

create database test_app;

use test_app;

CREATE TABLE `orderitems` (`order_num` int NOT NULL,
                              `order_item` int NOT NULL,
                              `prod_id` char(10) NOT NULL,
                              `quantity` int NOT NULL,
                              `item_price` decimal(8,2) NOT NULL,
                              PRIMARY KEY (`order_num`,`order_item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



LOAD DATA INFILE '/tmp/orderitems.csv'
    INTO TABLE orderitems
    FIELDS TERMINATED BY ','
    LINES TERMINATED BY '\n';


show create table orderitems;

create database demo;


select * from goodsmaster;
Show binary logs;
FLUSH BINARY LOGS;
Show binary logs;
-- binlog.000011
drop database demo;
create database demo;
use demo;
-- source /tmp/mybackup.sql;
-- mysql -u root -p demo<mybackup.sql
select * from goodsmaster;
show binlog events  in 'binlog.000011';
-- mysqlbinlog --start-position=236 "/usr/local/var/mysql/binlog.000011" | mysql -u root -p

