package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6ms Beats71.31% 
 */
public class Q2825MakeStringaSubsequenceUsingCyclicIncrements {

    @Test
    public void test() {
        assertThat(canMakeSubsequence("c", "b")).isFalse();
        assertThat(canMakeSubsequence("abc", "ad")).isTrue();
        assertThat(canMakeSubsequence("ab", "d")).isFalse();
        assertThat(canMakeSubsequence("zc", "ad")).isTrue();
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (possible(c, str2.charAt(j))) {
                j++;
                if (j == str2.length())
                    return true;
            }
        }
        return false;
    }

    private boolean possible(char c1, char c2) {
        int diff = c2 - c1;
        return diff == 0 || diff == 1 || diff == -25;
    }

}
