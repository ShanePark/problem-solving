package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 7ms
 * Beats93.01%
 */
public class Q1578MinimumTimeToMakeRopeColorful3 {

    @Test
    public void test() {
        assertThat(minCost("abaac", new int[]{1, 2, 3, 4, 5})).isEqualTo(3);
        assertThat(minCost("abc", new int[]{1, 2, 3})).isEqualTo(0);
    }

    @Test
    public void test2() {
        assertThat(minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1})).isEqualTo(26);
    }

    public int minCost(String colors, int[] neededTime) {
        char before = ' ';
        int beforeRemoveTime = 0;
        int answer = 0;
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (before != c) {
                before = c;
                beforeRemoveTime = neededTime[i];
                continue;
            }
            int min = Math.min(neededTime[i], beforeRemoveTime);
            beforeRemoveTime = Math.max(neededTime[i], beforeRemoveTime);
            answer += min;
        }
        return answer;
    }

}
