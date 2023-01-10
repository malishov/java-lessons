import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MyThread extends Thread{

    @Override
    public void run()    {



    }


    public void readFile(String input) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(input));

        List<String[]> result = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            result.add(line.split("\t"));
        }
    }
}
