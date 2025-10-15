package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3350AdjacentIncreasingSubarraysDetectionII {

    @Test
    public void test() {
        assertThat(maxIncreasingSubarrays(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1))).isEqualTo(3);
        assertThat(maxIncreasingSubarrays(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7))).isEqualTo(2);
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        final int SIZE = nums.size();
        int last = 0;
        int cur = 1;
        int answer = 0;

        for (int i = 1; i < SIZE; ++i) {
            if (nums.get(i - 1) < nums.get(i)) {
                cur++;
            } else {
                last = cur;
                cur = 1;
            }
            answer = Math.max(answer, Math.max(cur / 2, Math.min(last, cur)));
        }
        return answer;
    }

}
