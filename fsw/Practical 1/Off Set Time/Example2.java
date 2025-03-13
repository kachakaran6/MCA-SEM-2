// OffsetDateTime Class Example - Using format() Method

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Example2 {
    public static void main(String[] args) {
        // Parse the date1
        OffsetDateTime date1 = OffsetDateTime.parse("2018-12-12T13:30:30+05:00");

        System.out.println("Date1: " + date1);

        // Using ISO_TIME formatter
        DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;
        System.out.println(formatter.format(date1));
    }
}
