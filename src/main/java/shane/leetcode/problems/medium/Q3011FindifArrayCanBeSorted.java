package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3ms Beats48.57%
 */
public class Q3011FindifArrayCanBeSorted {

    @Test
    public void test() {
        assertThat(canSortArray(new int[]{20, 16})).isFalse();
        assertThat(canSortArray(new int[]{3, 16, 8, 4, 2})).isFalse();
        assertThat(canSortArray(new int[]{8, 4, 2, 30, 15})).isTrue();
        assertThat(canSortArray(new int[]{1, 2, 3, 4, 5})).isTrue();
    }

    public boolean canSortArray(int[] nums) {
        int max = 0;
        List<Integer> sameBitCnt = new ArrayList<>();
        int bitCnt = -1;
        for (int num : nums) {
            if (num < max) {
                return false;
            }
            int curBitCnt = Integer.bitCount(num);
            if (bitCnt == curBitCnt) {
                sameBitCnt.add(num);
                continue;
            }
            for (Integer n : sameBitCnt) {
                if (num < n)
                    return false;
                max = Math.max(max, n);
            }
            sameBitCnt.add(num);
            bitCnt = curBitCnt;
        }
        return true;
    }

}
