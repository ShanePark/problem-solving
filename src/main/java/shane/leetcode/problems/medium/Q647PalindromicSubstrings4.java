package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 13 ms Beats 28.53% of users with Java
 */
public class Q647PalindromicSubstrings4 {

    @Test
    public void test() {
        assertThat(countSubstrings("hello")).isEqualTo(6);
        assertThat(countSubstrings("abc")).isEqualTo(3);
        assertThat(countSubstrings("aaa")).isEqualTo(6);

    }

    public int countSubstrings(String s) {
        int LENGTH = s.length();
        char[] arr = s.toCharArray();
        Boolean[][] dp = new Boolean[LENGTH][LENGTH];
        int cnt = 0;
        for (int i = 0; i < LENGTH; i++) {
            dp[i][i] = true;
            for (int j = i; j < LENGTH; j++) {
                if (isPalindrome(arr, i, j, dp)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isPalindrome(char[] arr, int i, int j, Boolean[][] dp) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (arr[i] != arr[j]) {
            return dp[i][j] = false;
        }
        if (j - i <= 2) {
            return dp[i][j] = true;
        }
        return dp[i][j] = isPalindrome(arr, i + 1, j - 1, dp);
    }

}
