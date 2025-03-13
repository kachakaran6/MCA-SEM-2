
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        // Creating a JSON Object
        JSONObject student = new JSONObject();
        student.put("name", "Rahul");
        student.put("age", 21);
        student.put("course", "Computer Science");

        // Nested JSON Object for Marks
        JSONObject marks = new JSONObject();
        marks.put("math", 90);
        marks.put("science", 85);
        marks.put("english", 88);

        student.put("marks", marks);

        // Creating a JSON Array
        JSONArray studentsArray = new JSONArray();

        JSONObject student1 = new JSONObject();
        student1.put("name", "Rahul");
        student1.put("age", 21);
        student1.put("course", "CS");

        JSONObject student2 = new JSONObject();
        student2.put("name", "Aditi");
        student2.put("age", 22);
        student2.put("course", "IT");

        JSONObject student3 = new JSONObject();
        student3.put("name", "Rohan");
        student3.put("age", 20);
        student3.put("course", "ECE");

        studentsArray.put(student1);
        studentsArray.put(student2);
        studentsArray.put(student3);

        // Printing JSON Object and JSON Array
        System.out.println("JSON Object:");
        System.out.println(student.toString(4)); // Pretty print with 4 spaces

        System.out.println("\nJSON Array:");
        System.out.println(studentsArray.toString(4));

        // Accessing values from JSON Object
        System.out.println("\nStudent Name: " + student.getString("name"));

        // Accessing values from JSON Array
        System.out.println("First Student in Array: " + studentsArray.getJSONObject(0).getString("name"));
    }
}
