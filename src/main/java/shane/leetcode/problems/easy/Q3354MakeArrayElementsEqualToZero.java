package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q3354MakeArrayElementsEqualToZero {

    @Test
    public void test() {
        assertThat(countValidSelections(new int[]{1, 0, 2, 0, 3})).isEqualTo(2);
        assertThat(countValidSelections(new int[]{2, 3, 4, 0, 4, 1, 0})).isEqualTo(0);
    }

    @Test
    public void test2() {
        assertThat(countValidSelections(new int[]{16, 13, 10, 0, 0, 0, 10, 6, 7, 8, 7})).isEqualTo(3);
        assertThat(countValidSelections(new int[]{0})).isEqualTo(2);
    }

    public int countValidSelections(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int answer = 0;
        int left = 0;
        for (int num : nums) {
            left += num;
            if (num != 0)
                continue;
            if (left * 2 == sum) {
                answer += 2;
                continue;
            }
            if (left * 2 + 1 == sum || left * 2 - 1 == sum) {
                answer++;
            }
        }
        return answer;
    }

}
