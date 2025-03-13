public class Main {
    public static void main(String[] args) {
        String str = "A";
        if (str.length() == 1) {
            char ch = str.charAt(0);
            System.out.println("input String :" + str);
            System.out.println("converted Character :" + ch);
        } else {
            System.out.println("input is not a Single character String");
        }
    }
}
