result = db.students.find()

result = db.students.find({"age": {"$gt": 20}})

result = db.students.find({}, {"name": 1, "age": 1})

result = db.students.find_one({"name": "John"})

result = db.students.find().limit(10)
