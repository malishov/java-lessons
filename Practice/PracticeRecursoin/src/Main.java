public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }



    public static boolean isPowerOfThree(int n) {

        if(n == 1)
            return true;
        else
        if(n % 3 != 0 || n <= 0)
            return false;
        else
            return isPowerOfThree(n/3);

    }

    public static int func(int num) {

return 0;
    }
}