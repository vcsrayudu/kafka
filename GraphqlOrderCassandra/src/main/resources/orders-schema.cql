CREATE TYPE IF NOT EXISTS product (
  product_id uuid,
  product_quantity int,
  product_name text,
 product_price decimal
);
CREATE TABLE IF NOT EXISTS orders (orderid uuid,order_desc text, product_list list<frozen <product>>, order_created_at timestamp, PRIMARY KEY (orderid));