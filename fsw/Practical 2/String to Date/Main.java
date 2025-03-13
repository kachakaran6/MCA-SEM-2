import java.text.SimpleDateFormat;
import java.util.Date;

class Main {
    public static void main(String args[]) {
        String dateStr = "2025-01-17";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setLenient(false);
            Date date = formatter.parse(dateStr);
            System.out.println("Input String: " + dateStr);
            System.out.println("Converted Date: " + date);
        } catch (Exception e) {
            System.out.println("Invalid date format: " + e);
        }
    }
}