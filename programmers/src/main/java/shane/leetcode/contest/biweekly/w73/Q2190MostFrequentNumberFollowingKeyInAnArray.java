package shane.leetcode.contest.biweekly.w73;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2190MostFrequentNumberFollowingKeyInAnArray {

    @Test
    void test() {
        assertThat(mostFrequent(new int[]{1, 100, 200, 1, 100}, 1)).isEqualTo(100);
        assertThat(mostFrequent(new int[]{2, 2, 2, 2, 3}, 2)).isEqualTo(2);
    }

    public int mostFrequent(int[] nums, int key) {
        int[] arr = new int[1001];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == key) {
                arr[nums[i]]++;
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                maxIndex = i;
                max = arr[i];
            }
        }
        return maxIndex;
    }


}
