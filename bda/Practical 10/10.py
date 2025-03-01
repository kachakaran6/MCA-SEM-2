from pymongo import MongoClient

# Connect to MongoDB
client = MongoClient(
    "mongodb://localhost:27017/"
)  # Assuming MongoDB is running locally

# Select database and collection
db = client[
    "your_database_name"
]  # Replace 'your_database_name' with your actual database name
collection = db["Students"]

# Find all documents in the collection
cursor = collection.find()

# Iterate over the cursor to access the documents
for document in cursor:
    print(document)
