package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my
 */
public class Q3333FindTheOriginalTypedStringII {

    @Test
    public void test() {
        assertThat(possibleStringCount("aabbccdd", 7)).isEqualTo(5);
        assertThat(possibleStringCount("aabbccdd", 8)).isEqualTo(1);
        assertThat(possibleStringCount("aaabbb", 3)).isEqualTo(8);
    }


    final int MOD = (int) 1e9 + 7;

    public int possibleStringCount(String word, int k) {
        int cnt = 1;
        List<Integer> groups = new ArrayList<>();
        for (int i = 1; i < word.length(); ++i) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
                continue;
            }
            groups.add(cnt);
            cnt = 1;
        }
        groups.add(cnt);

        long totalWays = 1;
        for (int o : groups) {
            totalWays = (totalWays * o) % MOD;
        }
        if (groups.size() >= k) {
            return (int) totalWays;
        }

        int[] dp = new int[k];
        Arrays.fill(dp, 1);

        for (int groupCnt : groups) {
            int[] ways = new int[k];
            for (int j = 1; j < k; j++) {
                ways[j] = dp[j - 1];
                if (j - groupCnt - 1 >= 0) {
                    ways[j] = (ways[j] - dp[j - groupCnt - 1] + MOD) % MOD;
                }
            }
            int[] newDp = new int[k];
            newDp[0] = ways[0];
            for (int j = 1; j < k; j++) {
                newDp[j] = (newDp[j - 1] + ways[j]) % MOD;
            }
            dp = newDp;
        }

        return (int) ((totalWays - dp[k - 1] + MOD) % MOD);
    }

}
