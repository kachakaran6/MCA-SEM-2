class Main {
    public static void main(String[] args) {
        int num = 456;
        String str1 = String.valueOf(num);
        String str2 = Integer.toString(num);

        System.out.println("Input Integer: " + num);
        System.out.println("Using String.valueOf: " + str1);
        System.out.println("Using toString: " + str2);
    }
}