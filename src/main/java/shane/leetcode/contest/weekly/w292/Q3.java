package shane.leetcode.contest.weekly.w292;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3 {

    @Test
    public void test() {
        assertThat(countTexts("22233")).isEqualTo(8);
        assertThat(countTexts("2222")).isEqualTo(7);
        assertThat(countTexts("222222222222222222222222222222222222")).isEqualTo(82876089);
    }

    public int countTexts(String pressedKeys) {
        final int MOD = (int) 1e9 + 7;
        int[] dp = new int[pressedKeys.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < pressedKeys.length(); i++) {
            char c = pressedKeys.charAt(i);
            int count = (c == '7' || c == '9') ? 4 : 3;
            for (int j = i; j >= 0 && j > i - count; j--) {
                if (pressedKeys.charAt(j) == c) {
                    dp[i + 1] = (dp[i + 1] + dp[j]) % MOD;
                } else {
                    break;
                }
            }
        }
        return dp[pressedKeys.length()];
    }

}
