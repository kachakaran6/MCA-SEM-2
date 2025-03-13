// MonthDay Class Example - Creating an Instance of MonthDay

import java.time.Month;
import java.time.MonthDay;

public class Example {
    // Main driver method
    public static void main(String[] args) {
        // Creating an object of MonthDay class
        MonthDay monthday = MonthDay.of(Month.MARCH, 14);
        // Print and display the value stored
        System.out.println(monthday);
    }
}