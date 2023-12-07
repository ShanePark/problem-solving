package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 100.00%of users with Java
 * Memory Details 44.44MB Beats 60.00%of users with Java
 */
public class Q1903LargestOddNumberInString {

    @Test
    public void test() {
        assertThat(largestOddNumber("52")).isEqualTo("5");
        assertThat(largestOddNumber("4206")).isEqualTo("");
        assertThat(largestOddNumber("35427")).isEqualTo("35427");
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int n = num.charAt(i) - '0';
            if (n % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

}
