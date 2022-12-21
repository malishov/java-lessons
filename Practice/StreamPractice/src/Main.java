import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {5, 5, 5, 5, 4, 3, 4, 3 };

        int count = 0;

        HashMap<Integer, Integer> pairs = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            if (pairs.containsKey(numbers[i])) {

                int tmp = pairs.get(numbers[i]) + 1;

                count = count +  tmp;

                pairs.put(numbers[i], tmp);
            } else {
                pairs.put(numbers[i], 0);
            }

        }


        System.out.println(count);


    }
}