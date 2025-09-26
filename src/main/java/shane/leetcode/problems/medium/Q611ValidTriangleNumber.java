package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q611ValidTriangleNumber {

    @Test
    public void test() {
        assertThat(triangleNumber(new int[]{2, 2, 3, 4})).isEqualTo(3);
        assertThat(triangleNumber(new int[]{4, 2, 3, 4})).isEqualTo(4);
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                    continue;
                }
                left++;
            }
        }

        return count;
    }

}
