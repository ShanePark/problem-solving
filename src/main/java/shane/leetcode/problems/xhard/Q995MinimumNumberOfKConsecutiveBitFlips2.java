package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q995MinimumNumberOfKConsecutiveBitFlips2 {

    @Test
    public void test() {
        assertThat(minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3)).isEqualTo(3);
        assertThat(minKBitFlips(new int[]{0, 1, 0}, 1)).isEqualTo(2);
        assertThat(minKBitFlips(new int[]{1, 1, 0}, 2)).isEqualTo(-1);
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i % 2;
        }
        assertThat(minKBitFlips(arr, 10000)).isEqualTo(50000);
    }

    public int minKBitFlips(int[] nums, int k) {
        int[] isFlipped = new int[nums.length];
        int flipCount = 0;
        int flip = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                flip ^= isFlipped[i - k];
            }
            if (nums[i] == flip) {
                if (i + k > nums.length) {
                    return -1;
                }
                flip ^= 1;
                isFlipped[i] = 1;
                flipCount++;
            }
        }

        return flipCount;
    }

}
