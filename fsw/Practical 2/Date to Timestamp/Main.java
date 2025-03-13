import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        long timestamp = date.getTime();
        System.out.println("Date to Timestamp: " + timestamp);
    }
}
