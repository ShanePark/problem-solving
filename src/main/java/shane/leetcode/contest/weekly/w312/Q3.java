package shane.leetcode.contest.weekly.w312;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3 {

    @Test
    public void test() {
        assertThat(goodIndices(new int[]{2, 1, 1, 1, 3, 4, 1}, 2)).containsExactly(2, 3);
        assertThat(goodIndices(new int[]{2, 1, 1, 2}, 2)).isEmpty();
    }

    public List<Integer> goodIndices(int[] nums, int k) {
        int[] left = new int[nums.length];
        int min = Integer.MAX_VALUE;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur <= min) {
                size++;
            } else {
                size = 1;
            }
            min = cur;
            left[i] = size;
        }

        int[] right = new int[nums.length];
        min = Integer.MAX_VALUE;
        size = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = nums[i];
            if (cur <= min) {
                size++;
            } else {
                size = 1;
            }
            min = cur;
            right[i] = size;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = k; i < nums.length - k; i++) {
            if (left[i - 1] >= k && right[i + 1] >= k) {
                answer.add(i);
            }
        }

        return answer;
    }

}
