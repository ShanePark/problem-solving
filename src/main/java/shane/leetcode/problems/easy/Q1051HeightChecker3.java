package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 86.45% of users with Java
 */
public class Q1051HeightChecker3 {

    @Test
    public void test() {
        assertThat(heightChecker(new int[]{1, 1, 4, 2, 1, 3})).isEqualTo(3);
        assertThat(heightChecker(new int[]{5, 1, 2, 3, 4})).isEqualTo(5);
        assertThat(heightChecker(new int[]{1, 2, 3, 4, 5})).isEqualTo(0);
    }

    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                cnt++;
            }
        }
        return cnt;
    }

}
