// MonthDay Class Example - Parsing a MonthDay from Text

import java.time.MonthDay;

public class Example1 {
    // Main driver method
    public static void main(String[] args) {
        // Store an instance of MonthDay from text --03-14
        MonthDay monthday = MonthDay.parse("--03-14");

        // Display the month using the instance of class
        System.out.println(monthday.getMonth());
    }
}
