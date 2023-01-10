import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {
//
    public static String input = "data.txt";
    public ExecutorService executorService = Executors.newFixedThreadPool(3);
//
    @Override
    public Integer call() throws Exception {

        int count = 0;

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                final String tmpLine = line;

                Callable<Integer> callable = () -> {

                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " " + tmpLine.split(" ").length);
                    return tmpLine.split(" ").length; };

                Future<Integer> future = executorService.submit(callable);

//                FutureTask<Integer> future = new FutureTask<>(callable);
//                new Thread(future).start();

                count += future.get();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            executorService.shutdown();
        }

        return count;
    }
}
