import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] res = mergeSort(new int[]{1,2,3},3,  new int[]{7, 5, 6}, 3);

        for (int e : res)
            System.out.println(e);

        System.out.println("Hello world!");
    }

    public static int[] mergeSort(int[] nums1, int m, int[] nums2, int n) {

        int[] result = new int[m + n];

        int x = 0;
        int y = 0;
        int counter = 0;
        boolean isEnd = false;

        while (!isEnd) {


            if (x == m-1) {
                for (int j = y; j < n; j++)
                    result[counter++]  = nums2[j];
            }

            if (y == n - 1) {
                for (int j = x; j< m; j++)
                    result[counter++] = nums1[j];
            }

            if (nums1[x] == 0)
                x++;

            if (nums2[y] == 0)
                y++;

            int element = 0;



            if (nums1[x] * nums2[y] != 0) {

                if (nums1[x] <= nums2[y]) {

                    element = nums1[x];
                    x++;

                } else {

                    element = nums2[y];
                    y++;

                }

                result[counter] = element;
                counter++;

                if (counter > result.length)
                    isEnd = true;



            }


        }

//        for (int i = 0; i < result.length; i++) {
//
//            if (nums1[x] == 0)
//                x++;
//
//            if (nums2[y] == 0)
//                y++;
//
//            int element = 0;
//
//
//
//            if (nums1[x] <= nums2[y]) {
//                element = nums1[x];
//                x++;
//            } else {
//                element = nums2[y];
//                y++;
//            }
//
//            if (x == m-1)
//                break;
//
//            if (y == n-1)
//                break;
//
//            result[i] = element;
//        }
//
        return result;
    }
}