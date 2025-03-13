public class Main {
    public static void main(String args[]) {
        String str = "123";
        int num1 = Integer.parseInt(str);
        int num2 = Integer.valueOf(str);

        System.out.println("Input string: " + str);
        System.out.println("Using parseInt: " + num1);
        System.out.println("Using valueOf: " + num2);
    }
}