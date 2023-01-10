import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Main {

    public static String input = "data.txt";
    static Semaphore semaphore = new Semaphore(1);
    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws IOException, InterruptedException {


        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        String line;


        while((line = reader.readLine()) != null){
            final String tempLine = line;

            executorService.submit(() -> {

                System.out.println(Thread.currentThread().getName() + "-" + tempLine.split(" ").length);

            });


        }

        executorService.shutdown();

//
//        while((line = reader.readLine()) != null){
//            final String tempLine = line;
//
//            semaphore.acquire();
//
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + "-" + tempLine.split(" ").length);
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                semaphore.release();
//            }).start();;
//        }

//        System.out.println("Start");
//
//        Thread t = new MyThread();
//        t.start();
//        System.out.println("main thread");

//        IntStream.range(0, 200)
//                .parallel()
//                .forEach(i -> System.out.println(Thread.currentThread().getName() + " - " + i));
    }
}