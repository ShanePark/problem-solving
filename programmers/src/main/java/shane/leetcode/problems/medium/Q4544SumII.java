package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 	Time Limit Exceeded
 */
public class Q4544SumII {

    @Test
    void test() {
        Assertions.assertThat(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2})).isEqualTo(2);
        Assertions.assertThat(fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0})).isEqualTo(1);
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for (int i : nums1) {
            list.add(i);
        }

        for (int i : nums2) {
            for (Integer j : list) {
                list2.add(i + j);
            }
        }

        for (int i : nums3) {
            for (Integer j : list2) {
                list3.add(i + j);
            }
        }

        int cnt = 0;

        for (int i : nums4) {
            for (Integer j : list3) {
                if (i + j == 0) {
                    cnt++;
                }
            }
        }

        return cnt;

    }

}
