import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Start");
//
//        Thread t = new MyThread();
//        t.start();
//        System.out.println("main thread");

        IntStream.range(0, 200)
                .parallel()
                .forEach(i -> System.out.println(Thread.currentThread().getName() + " - " + i));
    }
}