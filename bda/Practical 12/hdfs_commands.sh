# Create directories in HDFS
hdfs dfs -mkdir -p /user/hive/warehouse/customers
hdfs dfs -mkdir -p /user/hive/warehouse/orders

# Put local files into HDFS
hdfs dfs -put customers.csv /user/hive/warehouse/customers/
hdfs dfs -put orders.csv /user/hive/warehouse/orders/