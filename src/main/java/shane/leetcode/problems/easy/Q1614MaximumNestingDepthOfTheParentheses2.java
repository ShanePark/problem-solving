package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q1614MaximumNestingDepthOfTheParentheses2 {

    @Test
    void test() {
        Assertions.assertThat(maxDepth("(1+(2*3)+((8)/4))+1")).isEqualTo(3);
        Assertions.assertThat(maxDepth("(1)+((2))+(((3)))")).isEqualTo(3);
    }

    public int maxDepth(String s) {
        int cnt = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

}
