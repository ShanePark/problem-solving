package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Assertions;

public class Q1094CarPooling {

    public static void main(String[] args) {
        Assertions.assertEquals(false, carPooling(Ps.intArray("[[2,1,5],[3,3,7]]"), 4));
        Assertions.assertEquals(true, carPooling(Ps.intArray("[[2,1,5],[3,3,7]]"), 5));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for (int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];
            for (int i = from; i < to; i++) {
                int temp = (arr[i] += num);
                if (temp > capacity)
                    return false;
            }
        }
        return true;
    }

}
