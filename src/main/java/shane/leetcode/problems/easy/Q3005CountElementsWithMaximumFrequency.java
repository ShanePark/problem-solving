package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 99.64% of users with Java
 */
public class Q3005CountElementsWithMaximumFrequency {

    @Test
    public void test() {
        assertThat(maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4})).isEqualTo(4);
        assertThat(maxFrequencyElements(new int[]{1, 2, 3, 4, 5})).isEqualTo(5);
    }

    public int maxFrequencyElements(int[] nums) {
        int maxCount = 0;
        int[] cnt = new int[101];
        for (int num : nums) {
            maxCount = Math.max(maxCount, ++cnt[num]);
        }
        int answer = 0;
        for (int i : cnt) {
            if (i == maxCount)
                answer += i;
        }
        return answer;
    }

}
