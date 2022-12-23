import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < 6; i++)
            arr.add(i);

        System.out.println(reorderList(arr));

    }

    public static List<Integer> reorderList(List<Integer> nums) {

        List<Integer> result = new ArrayList<>();

        result.add(nums.get(0));
        result.add(nums.get(nums.size() - 1));

        nums.remove(0);
        nums.remove(nums.size() - 1);

        if (1 < nums.size())
            result = Stream.concat(result.stream(), reorderList(nums).stream())
                    .collect(Collectors.toList());
        else
            result = Stream.concat(result.stream(), nums.stream())
                    .collect(Collectors.toList());

        return result;
    }
}