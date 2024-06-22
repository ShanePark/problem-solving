package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1248CountNumberOfNiceSubarrays {

    @Test
    public void test() {
        assertThat(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3)).isEqualTo(2);
        assertThat(numberOfSubarrays(new int[]{2, 4, 6}, 1)).isEqualTo(0);
        assertThat(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2)).isEqualTo(16);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int odd = 0;
        int answer = 0;
        int left = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                odd++;
                count = 0;
            }
            while (odd == k) {
                if (nums[left++] % 2 == 1) {
                    odd--;
                }
                count++;
            }
            answer += count;
        }
        return answer;
    }

}
