-- Create external table for customers
CREATE EXTERNAL TABLE IF NOT EXISTS customers (
  customer_id INT,
  name STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/warehouse/customers';

-- Create external table for orders
CREATE EXTERNAL TABLE IF NOT EXISTS orders (
  customer_id INT,
  order_date STRING,
  amount DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/warehouse/orders';