package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4 ms Beats 80.63% of users with Java
 */
public class Q1750MinimumLengthOfStringAfterDeletingSimilarEnds {

    @Test
    public void test() {
        assertThat(minimumLength("bbbbbbbbbbbbbbbbbbb")).isEqualTo(0);
        assertThat(minimumLength("cbc")).isEqualTo(1);
        assertThat(minimumLength("cabaabac")).isEqualTo(0);
        assertThat(minimumLength("ca")).isEqualTo(2);
        assertThat(minimumLength("aabccabba")).isEqualTo(3);
    }

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (left == right)
                return 1;
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return right - left + 1;
            }
            while (s.charAt(left) == leftChar && left <= right) {
                if (left == s.length() - 1)
                    return 0;
                left++;
            }
            while (s.charAt(right) == leftChar && left <= right) {
                right--;
            }
        }
        return 0;
    }

}
