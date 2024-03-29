package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 39.29% of users with Java
 */
public class Q2962CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    @Test
    public void test() {
        assertThat(countSubarrays(new int[]{21, 11, 13, 15, 16, 21, 8, 9, 6, 21}, 2)).isEqualTo(10);
        assertThat(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2)).isEqualTo(6);
        assertThat(countSubarrays(new int[]{1, 4, 2, 1}, 3)).isEqualTo(0);
    }

    @Test
    public void overflow() {
        int[] arr = new int[(int) 1e5];
        assertThat(countSubarrays(arr, 1)).isEqualTo(5000050000L);
    }

    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int left = 0;
        int right = 0;
        long answer = 0;
        int cnt = 0;
        if (nums[0] == max)
            cnt++;
        while (left < nums.length) {
            while (cnt < k && right < nums.length - 1) {
                int n = nums[++right];
                if (n == max) {
                    cnt++;
                }
            }
            if (cnt == k) {
                int length = nums.length - right;
                answer += length;
            }
            if (nums[left++] == max) {
                cnt--;
            }
        }

        return answer;
    }

}
