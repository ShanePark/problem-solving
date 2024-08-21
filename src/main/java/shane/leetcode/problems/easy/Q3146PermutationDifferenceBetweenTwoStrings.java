package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3146PermutationDifferenceBetweenTwoStrings {

    @Test
    public void test() {
        assertThat(findPermutationDifference("abc", "bac")).isEqualTo(2);
        assertThat(findPermutationDifference("abcde", "edbac")).isEqualTo(12);
        assertThat(findPermutationDifference("rwohu", "rwuoh")).isEqualTo(4);
    }

    public int findPermutationDifference(String s, String t) {
        int LENGTH = s.length();
        int sum = 0;
        for (int i = 0; i < LENGTH; i++) {
            char c = s.charAt(i);
            for (int j = 0; j < LENGTH; j++) {
                if (t.charAt(j) == c) {
                    sum += Math.abs(i - j);
                    break;
                }
            }
        }
        return sum;
    }

}
