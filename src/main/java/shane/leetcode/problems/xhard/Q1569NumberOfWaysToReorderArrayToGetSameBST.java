package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1569NumberOfWaysToReorderArrayToGetSameBST {

    @Test
    public void test() {
        assertThat(numOfWays(new int[]{2, 1, 3})).isEqualTo(1);
        assertThat(numOfWays(new int[]{3, 4, 5, 1, 2})).isEqualTo(5);
        assertThat(numOfWays(new int[]{1, 2, 3})).isEqualTo(0);
    }

    private int MOD = (int) 1e9 + 7;

    public int numOfWays(int[] nums) {
        int length = nums.length;

        long[][] dp = new long[length][length];
        for (int i = 0; i < length; ++i) {
            dp[i][0] = dp[i][i] = 1;
        }
        for (int i = 2; i < length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        List<Integer> arrList = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        return (int) ((dfs(arrList, dp) - 1) % MOD);
    }

    private long dfs(List<Integer> nums, long[][] dp) {
        int m = nums.size();
        if (m < 3) {
            return 1;
        }

        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        for (int i = 1; i < m; ++i) {
            if (nums.get(i) < nums.get(0)) {
                leftNodes.add(nums.get(i));
            } else {
                rightNodes.add(nums.get(i));
            }
        }
        long left = dfs(leftNodes, dp) % MOD;
        long right = dfs(rightNodes, dp) % MOD;

        return (((left * right) % MOD) * dp[m - 1][leftNodes.size()]) % MOD;
    }
}
