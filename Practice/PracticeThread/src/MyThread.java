import java.util.stream.IntStream;

public class MyThread extends Thread{

    @Override
    public void run() {

        IntStream.range(0, 20).forEach(System.out::println);

    }
}
