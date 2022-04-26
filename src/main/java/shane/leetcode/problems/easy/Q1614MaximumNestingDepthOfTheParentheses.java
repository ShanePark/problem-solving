package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

public class Q1614MaximumNestingDepthOfTheParentheses {

    @Test
    void test() {
//        Assertions.assertThat(maxDepth("(1+(2*3)+((8)/4))+1")).isEqualTo(3);
//        Assertions.assertThat(maxDepth("(1)+((2))+(((3)))")).isEqualTo(3);
        System.out.println(2.0 / (double)(1/2.0));
    }

    public int maxDepth(String s) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cur++;
            } else if (s.charAt(i) == ')') {
                cur--;
            }
            max = Math.max(cur, max);
        }
        return max;
    }

}
