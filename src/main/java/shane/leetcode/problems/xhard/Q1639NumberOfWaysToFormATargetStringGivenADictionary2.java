package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my own solution
 */
public class Q1639NumberOfWaysToFormATargetStringGivenADictionary2 {

    @Test
    void test() {
        assertThat(numWays(new String[]{"acca", "bbbb", "caca"}, "aba")).isEqualTo(6);
        assertThat(numWays(new String[]{"abba", "baab"}, "bab")).isEqualTo(4);
    }

    public int numWays(String[] words, String target) {
        final int MOD = (int) 1e9 + 7;

        int wordLen = words[0].length();
        int targetLen = target.length();

        int[][] freq = new int[26][wordLen];
        for (String word : words) {
            for (int i = 0; i < wordLen; i++) {
                freq[word.charAt(i) - 'a'][i]++;
            }
        }

        long[] dp = new long[targetLen + 1];
        dp[0] = 1;

        for (int i = 0; i < wordLen; i++) {
            for (int j = targetLen - 1; j >= 0; j--) {
                dp[j + 1] = (dp[j + 1] + dp[j] * freq[target.charAt(j) - 'a'][i]) % MOD;
            }
        }

        return (int) dp[targetLen];
    }

}
