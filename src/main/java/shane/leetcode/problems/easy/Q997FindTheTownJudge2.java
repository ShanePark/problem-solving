package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Runtime 6 ms Beats 49.50%
 * Memory 50.7 MB Beats 39.98%
 */
public class Q997FindTheTownJudge2 {

    @Test
    public void test() {
        Assertions.assertEquals(2, findJudge(2, STool.convertToIntArray("[[1,2]]")));
        Assertions.assertEquals(3, findJudge(3, STool.convertToIntArray("[[1,3],[2,3]]")));
        Assertions.assertEquals(-1, findJudge(3, STool.convertToIntArray("[[1,3],[2,3],[3,1]]")));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int[] ints : trust) {
            ++arr[ints[1] - 1];
            set.add(ints[0]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == n - 1 && !set.contains(i + 1)) {
                return i + 1;
            }
        }
        return -1;
    }

}
