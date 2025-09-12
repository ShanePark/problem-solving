package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4ms
 * Beats79.79%
 */
public class Q3227VowelsGameInAString {

    @Test
    public void test() {
        assertThat(doesAliceWin("leetcoder")).isTrue();
        assertThat(doesAliceWin("bbcd")).isFalse();
    }

    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                return true;
        }
        return false;
    }

}
