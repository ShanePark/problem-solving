package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 14 ms, faster than 58.58% of Java online submissions for Minimum Time to Make Rope Colorful.
 * Memory Usage: 97 MB, less than 37.01% of Java online submissions for Minimum Time to Make Rope Colorful.
 */
public class Q1578MinimumTimeToMakeRopeColorful {

    @Test
    public void test() {
        assertThat(minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1})).isEqualTo(26);
        assertThat(minCost("abaac", new int[]{1, 2, 3, 4, 5})).isEqualTo(3);
        assertThat(minCost("abc", new int[]{1, 2, 3})).isEqualTo(0);
        assertThat(minCost("aabaa", new int[]{1, 2, 3, 4, 1})).isEqualTo(2);
    }

    public int minCost(String colors, int[] neededTime) {
        int answer = 0;
        char before = ' ';
        int beforeIndex = -1;

        for (int i = 0; i < colors.length(); i++) {
            char currentColor = colors.charAt(i);
            if (currentColor == before) {
                answer += Math.min(neededTime[beforeIndex], neededTime[i]);
                if (neededTime[beforeIndex] < neededTime[i]) {
                    beforeIndex = i;
                }
            } else {
                beforeIndex = i;
                before = currentColor;
            }
        }
        return answer;
    }

}
