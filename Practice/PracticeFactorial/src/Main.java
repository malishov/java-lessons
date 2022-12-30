public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println(factorial(3));
    }

    public static long factorial(long num) {
        if (num == 1 || num == 0)
            return 1;
        else
            return factorial(num-1) * num;

    }
}