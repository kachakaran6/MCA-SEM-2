-- Inner Join between customers and orders
SELECT 
  c.customer_id, 
  c.name, 
  o.order_date, 
  o.amount
FROM customers c
JOIN orders o
ON c.customer_id = o.customer_id;