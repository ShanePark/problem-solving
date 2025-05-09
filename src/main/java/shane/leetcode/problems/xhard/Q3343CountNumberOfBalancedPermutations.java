package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not mine
 */
public class Q3343CountNumberOfBalancedPermutations {

    @Test
    public void test() {
        assertThat(countBalancedPermutations("123")).isEqualTo(2);
        assertThat(countBalancedPermutations("112")).isEqualTo(1);
        assertThat(countBalancedPermutations("12345")).isEqualTo(0);
    }

    final int MOD = (int) 1e9 + 7;

    public int countBalancedPermutations(String num) {
        int sum = 0;
        int[] digits = new int[10];
        for (char ch : num.toCharArray()) {
            int n = ch - '0';
            digits[n]++;
            sum += n;
        }
        if (sum % 2 != 0) return 0;

        int target = sum / 2;
        int maxHalfCnt = (num.length() + 1) / 2;
        long[][] comb = new long[maxHalfCnt + 1][maxHalfCnt + 1];
        long[][] dp = new long[target + 1][maxHalfCnt + 1];

        for (int i = 0; i <= maxHalfCnt; i++) {
            comb[i][i] = comb[i][0] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }

        dp[0][0] = 1;
        int digitsUsed = 0;
        int totSum = 0;
        for (int i = 0; i <= 9; i++) {
            digitsUsed += digits[i];
            totSum += i * digits[i];
            for (int oddCnt = Math.min(digitsUsed, maxHalfCnt); oddCnt >= Math.max(0, digitsUsed - (num.length() - maxHalfCnt)); oddCnt--) {
                int evenCnt = digitsUsed - oddCnt;
                for (int curr = Math.min(totSum, target); curr >= Math.max(0, totSum - target); curr--) {
                    long res = 0;
                    for (int j = Math.max(0, digits[i] - evenCnt); j <= Math.min(digits[i], oddCnt) && i * j <= curr; j++) {
                        long ways = (comb[oddCnt][j] * comb[evenCnt][digits[i] - j]) % MOD;
                        res = (res + ((ways * dp[curr - i * j][oddCnt - j]) % MOD)) % MOD;
                    }
                    dp[curr][oddCnt] = res % MOD;
                }
            }
        }
        return (int) dp[target][maxHalfCnt];
    }

}
