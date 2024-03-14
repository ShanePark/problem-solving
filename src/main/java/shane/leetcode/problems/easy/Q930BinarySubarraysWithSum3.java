package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q930BinarySubarraysWithSum3 {

    @Test
    public void test() {
        assertThat(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2)).isEqualTo(4);
        assertThat(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0)).isEqualTo(15);
    }

    @Test
    public void tle() {
        int[] arr = new int[3 * (int) 1e4];
        assertThat(numSubarraysWithSum(arr, 0)).isEqualTo(450015000);
    }

    @Test
    public void tle2() {
        int[] arr = new int[3 * (int) 1e4];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                arr[i] = 1;
        }
        assertThat(numSubarraysWithSum(arr, 10322)).isEqualTo(18714);
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int answer = 0;
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        for (int n : nums) {
            sum += n;
            if (sum >= goal) {
                answer += count[sum - goal];
            }
            count[sum]++;
        }
        return answer;
    }

}
