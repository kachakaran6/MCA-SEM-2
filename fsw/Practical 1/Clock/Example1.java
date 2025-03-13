// Clock Class Example - Using systemDefaultZone() Method

import java.time.Clock;

public class Example1 {
    // Main method
    public static void main(String[] args) {
        // Creating a Clock instance using systemDefaultZone() method
        Clock clock = Clock.systemDefaultZone();

        // Printing system clock details
        System.out.println(clock);

        // Printing the time zone of the clock instance
        System.out.println("Time Zone : " + clock.getZone());
    }
}
