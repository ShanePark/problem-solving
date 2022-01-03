package shane.leetcode.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Assertions;

public class Q997FindTheTownJudge {
    public static void main(String[] args) {
        Assertions.assertEquals(2, findJudge(2, STool.convertToIntArray("[[1,2]]")));
        Assertions.assertEquals(3, findJudge(3, STool.convertToIntArray("[[1,3],[2,3]]")));
        Assertions.assertEquals(-1, findJudge(3, STool.convertToIntArray("[[1,3],[2,3],[3,1]]")));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] arr = new int[n + 1];
        for (int[] ints : trust) {
            arr[ints[0]]--;
            arr[ints[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == n - 1)
                return i;
        }
        return -1;
    }
}
