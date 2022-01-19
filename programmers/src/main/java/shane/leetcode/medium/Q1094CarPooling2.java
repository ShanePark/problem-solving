package shane.leetcode.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Assertions;

public class Q1094CarPooling2 {

    public static void main(String[] args) {
        Assertions.assertEquals(false, carPooling(STool.convertToIntArray("[[2,1,5],[3,3,7]]"), 4));
        Assertions.assertEquals(true, carPooling(STool.convertToIntArray("[[2,1,5],[3,3,7]]"), 5));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }

        int inCar = 0;
        for (int i = 0; i < 1001; i++) {
            inCar += arr[i];
            if (inCar > capacity)
                return false;
        }
        return true;
    }

}
