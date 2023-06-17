package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my idea
 */
public class Q1187MakeArrayStrictlyIncreasing {

    @Test
    void test() {
        assertThat(makeArrayIncreasing(new int[]{0, 11, 6, 1, 4, 3}, new int[]{0, 1, 4, 5, 10, 11})).isEqualTo(5);
        assertThat(makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{1, 6, 3, 3})).isEqualTo(-1);
        assertThat(makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{4, 3, 1})).isEqualTo(2);
        assertThat(makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{1, 3, 2, 4})).isEqualTo(1);
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < arr2.length; i++)
            treeSet.add(arr2[i]);

        int length = arr1.length;
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = -1;

        for (int i = 1; i <= length; i++) {
            int before = arr1[i - 1];
            for (int j = 0; j <= i; j++) {
                if (dp[j][i - 1] < before) {
                    dp[j][i] = before;
                }
                if (j > 0) {
                    Integer higher = treeSet.higher(dp[j - 1][i - 1]);
                    if (higher != null) {
                        dp[j][i] = Math.min(dp[j][i], higher);
                    }
                }
                if (i == length && dp[j][i] != Integer.MAX_VALUE) {
                    return j;
                }
            }
        }
        return -1;
    }

}
