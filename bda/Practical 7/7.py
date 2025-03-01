# Using List to store student records
students_list = [
    {"roll_no": 101, "name": "Alice", "dob": "2002-05-14", "address": "New York"},
    {"roll_no": 102, "name": "Bob", "dob": "2001-09-23", "address": "Los Angeles"},
    {"roll_no": 103, "name": "Charlie", "dob": "2003-07-19", "address": "Chicago"},
]

# Using Set to store unique roll numbers
students_set = {101, 102, 103}

# Using Dictionary (Map) to store student details with roll_no as key
students_map = {
    101: {"name": "Alice", "dob": "2002-05-14", "address": "New York"},
    102: {"name": "Bob", "dob": "2001-09-23", "address": "Los Angeles"},
    103: {"name": "Charlie", "dob": "2003-07-19", "address": "Chicago"},
}


# Function to add a new student
def add_student(roll_no, name, dob, address):
    if roll_no in students_set:
        print(f"Student with Roll No {roll_no} already exists.")
        return
    students_list.append(
        {"roll_no": roll_no, "name": name, "dob": dob, "address": address}
    )
    students_set.add(roll_no)
    students_map[roll_no] = {"name": name, "dob": dob, "address": address}
    print(f"Student {name} added successfully.")


# Function to display all students
def display_students():
    print("\nStudent Records:")
    for student in students_list:
        print(student)


# Function to find a student by roll number
def find_student(roll_no):
    if roll_no in students_map:
        print(f"\nDetails of Roll No {roll_no}: {students_map[roll_no]}")
    else:
        print(f"Student with Roll No {roll_no} not found.")


# Adding a new student
add_student(104, "David", "2004-01-12", "Houston")

# Display all students
display_students()

# Find a student
find_student(102)
