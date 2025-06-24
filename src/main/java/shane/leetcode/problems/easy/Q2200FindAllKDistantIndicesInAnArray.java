package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats97.25%
 */
public class Q2200FindAllKDistantIndicesInAnArray {

    @Test
    public void test() {
        assertThat(findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1)).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2)).containsExactly(0, 1, 2, 3, 4);
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> answer = new ArrayList<>();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int left = Math.max(min + 1, Math.max(0, i - k));
                for (int j = left; j <= i + k && j < nums.length; j++) {
                    answer.add(j);
                    min = j;
                }
            }
        }
        return answer;
    }

}
