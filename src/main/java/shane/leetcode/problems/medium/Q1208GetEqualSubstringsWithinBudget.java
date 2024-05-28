package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 97.52% of users with Java
 */
public class Q1208GetEqualSubstringsWithinBudget {

    @Test
    public void test() {
        assertThat(equalSubstring("abcd", "bcdf", 3)).isEqualTo(3);
        assertThat(equalSubstring("abcd", "cdef", 3)).isEqualTo(1);
        assertThat(equalSubstring("abcd", "acde", 0)).isEqualTo(1);
    }

    public int equalSubstring(String s, String t, int maxCost) {
        final int LENGTH = s.length();
        int[] costs = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int right = -1;
        int maxLength = 0;
        int curCost = 0;
        for (int left = 0; left < LENGTH; left++) {
            while (right + 1 < LENGTH) {
                int cost = costs[right + 1];
                if (maxCost < curCost + cost) {
                    break;
                }
                right++;
                curCost += cost;
                maxLength = Math.max(maxLength, right - left + 1);
            }
            curCost -= costs[left];
        }

        return maxLength;
    }

}
