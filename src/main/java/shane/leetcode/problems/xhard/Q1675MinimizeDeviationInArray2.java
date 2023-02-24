package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 148 ms Beats 62.26%
 * Memory 94.3 MB Beats 7.55%
 */
public class Q1675MinimizeDeviationInArray2 {

    @Test
    public void test() {
        assertThat(minimumDeviation(new int[]{165, 319, 305})).isEqualTo(25);
        assertThat(minimumDeviation(new int[]{399, 908, 648, 357, 693, 502, 331, 649, 596, 698})).isEqualTo(315);
        assertThat(minimumDeviation(new int[]{4, 9, 4, 5})).isEqualTo(5);
        assertThat(minimumDeviation(new int[]{1, 2, 3, 4})).isEqualTo(1);
        assertThat(minimumDeviation(new int[]{4, 1, 5, 20, 3})).isEqualTo(3);
        assertThat(minimumDeviation(new int[]{2, 10, 8})).isEqualTo(3);
    }

    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            tree.add(nums[i] % 2 == 0 ? nums[i] : nums[i] * 2);
        }

        int minDiff = Integer.MAX_VALUE;
        while (true) {
            Integer max = tree.pollLast();
            if (max % 2 == 1) {
                break;
            }
            tree.add(max / 2);
            minDiff = Math.min(minDiff, tree.last() - tree.first());
        }
        return minDiff;
    }

}
