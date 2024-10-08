package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1963MinimumNumberOfSwapsToMakeTheStringBalanced {

    @Test
    public void test() {
        assertThat(minSwaps("][][")).isEqualTo(1);
        assertThat(minSwaps("]]][[[")).isEqualTo(2);
        assertThat(minSwaps("[]")).isEqualTo(0);
    }

    public int minSwaps(String s) {
        int open = 0;
        int answer = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                open++;
                continue;
            }
            if (open == 0) {
                open++;
                answer++;
                continue;
            }
            open--;
        }
        return answer;
    }

}
