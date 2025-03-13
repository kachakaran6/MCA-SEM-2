// Clock Class Example - Creating an Instance of Clock

import java.time.Clock;

public class Example {
    // Main method
    public static void main(String[] args) {
        // Creating a Clock instance using systemUTC() method
        Clock clock = Clock.systemUTC();
        // Getting the current instant defined by clock
        System.out.println("UTC time = " + clock.instant());
    }
}
