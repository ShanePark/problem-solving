package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1221SplitaStringinBalancedStrings {

    @Test
    void test() {
        Assertions.assertThat(balancedStringSplit("RLRRLLRLRL")).isEqualTo(4);
        Assertions.assertThat(balancedStringSplit("RLLLLRRRLR")).isEqualTo(3);
        Assertions.assertThat(balancedStringSplit("LLLLRRRR")).isEqualTo(1);
    }

    public int balancedStringSplit(String s) {
        int cnt = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                right++;
            } else {
                right--;
            }
            if (right == 0)
                cnt++;

        }
        return cnt;
    }

}
