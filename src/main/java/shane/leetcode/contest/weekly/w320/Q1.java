package shane.leetcode.contest.weekly.w320;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(unequalTriplets(new int[]{4, 4, 2, 4, 5})).isEqualTo(3);
        assertThat(unequalTriplets(new int[]{1, 1, 1, 1, 1})).isEqualTo(0);
        assertThat(unequalTriplets(new int[]{1, 1, 2, 2, 3, 3})).isEqualTo(8);
    }

    public int unequalTriplets(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[k] != nums[i]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
