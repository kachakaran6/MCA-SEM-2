public class Main {
    public static void main(String[] args) {
        String octal = "12";
        int decimal = -Integer.parseInt(octal, 8);
        System.out.println("Octal to decimal : " + decimal);
    }
}