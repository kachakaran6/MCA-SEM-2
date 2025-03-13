// OffsetTime Class Example - Using now() Method

import java.time.OffsetTime;
import java.time.temporal.ChronoField;

public class Example {

    // Main driver method
    public static void main(String[] args) {
        // Creating an object of OffsetTime class
        OffsetTime offset = OffsetTime.now();

        int h = offset.get(ChronoField.HOUR_OF_DAY); // Get hour of day
        System.out.println(h);

        int m = offset.get(ChronoField.MINUTE_OF_DAY); // Get minute of day
        System.out.println(m);

        int s = offset.get(ChronoField.SECOND_OF_DAY); // Get second of day
        System.out.println(s);
    }
}
