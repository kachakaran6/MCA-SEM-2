import pymongo

# Connect to the MongoDB server
client = pymongo.MongoClient("mongodb://localhost:27017/")

# Select the database
db = client["mydatabase"]

# Access an existing collection or create it if it doesn't exist
collection = db["students"]

# Insert a single document
student = {"name": "John", "age": 20, "grade": "A"}
collection.insert_one(student)

# Insert multiple documents
students = [
    {"name": "Alice", "age": 22, "grade": "B"},
    {"name": "Bob", "age": 21, "grade": "C"},
]
collection.insert_many(students)

# Find a single document
result = collection.find_one({"name": "John"})
print(result)

# Find all documents that match a query
results = collection.find({"grade": "A"})
for result in results:
    print(result)

# Update a single document
collection.update_one({"name": "John"}, {"$set": {"age": 21}})

# Update multiple documents
collection.update_many({"grade": "B"}, {"$set": {"grade": "A"}})

# Delete a single document
collection.delete_one({"name": "John"})

# Delete multiple documents
collection.delete_many({"grade": "C"})
