package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q719FindKthSmallestPairDistance2 {

    @Test
    public void test() {
        assertThat(smallestDistancePair(new int[]{1, 6, 1}, 3)).isEqualTo(5);
        assertThat(smallestDistancePair(new int[]{9, 10, 7, 10, 6, 1, 5, 4, 9, 8}, 18))
                .isEqualTo(2);
        assertThat(smallestDistancePair(new int[]{1, 3, 1}, 1)).isEqualTo(0);
        assertThat(smallestDistancePair(new int[]{1, 1, 1}, 2)).isEqualTo(0);
    }

    @Test
    public void mle() {
        int[] arr = new int[10000];
        assertThat(smallestDistancePair(arr, 25000000)).isEqualTo(0);
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int minDistance = 0;
        int maxDistance = nums[nums.length - 1] - nums[0];

        while (minDistance < maxDistance) {
            int midDistance = minDistance + (maxDistance - minDistance) / 2;
            int count = 0;

            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                while (j < nums.length && nums[j] - nums[i] <= midDistance) {
                    j++;
                }
                count += j - i - 1;
            }

            if (count < k) {
                minDistance = midDistance + 1;
                continue;
            }
            maxDistance = midDistance;
        }

        return minDistance;
    }

}
