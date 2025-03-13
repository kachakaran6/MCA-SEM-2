// OffsetTime Class Example - Using getHour() Method

import java.time.OffsetTime;

public class Example1 {
    public static void main(String[] args) {
        // Creating an instance of OffsetTime class
        OffsetTime offset = OffsetTime.now();
        // Getting the hour of the day field
        int h = offset.getHour();
        // Print and display the hours
        System.out.println(h + " hours");
    }
}
