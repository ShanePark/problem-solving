package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1639NumberOfWaysToFormATargetStringGivenADictionary {

    @Test
    void test() {
        assertThat(numWays(new String[]{"acca", "bbbb", "caca"}, "aba")).isEqualTo(6);
        assertThat(numWays(new String[]{"abba", "baab"}, "bab")).isEqualTo(4);
    }

    public int numWays(String[] words, String target) {
        final int MOD = (int) 1e9 + 7;
        int targetLength = target.length();

        long dp[] = new long[targetLength + 1];
        dp[0] = 1;

        for (int i = 0; i < words[0].length(); i++) {
            Map<Character, Integer> cntMap = new HashMap<>();
            for (String w : words) {
                cntMap.merge(w.charAt(i), 1, Integer::sum);
            }
            for (int j = targetLength - 1; j >= 0; j--) {
                dp[j + 1] += (dp[j] * cntMap.getOrDefault(target.charAt(j), 0)) % MOD;
            }
        }

        return (int) (dp[targetLength] % MOD);
    }

}
