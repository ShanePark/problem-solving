package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    @Test
    public void test() {
        assertThat(maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3})).isEqualTo(4);
        assertThat(maxArea(5, 4, new int[]{3, 1}, new int[]{1})).isEqualTo(6);
        assertThat(maxArea(5, 4, new int[]{3}, new int[]{3})).isEqualTo(9);
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHeight = 0;
        int maxWidth = 0;
        int y = 0;
        for (int cut : horizontalCuts) {
            maxHeight = Math.max(maxHeight, cut - y);
            y = cut;
        }
        maxHeight = Math.max(maxHeight, h - y);

        int x = 0;
        for (int cut : verticalCuts) {
            maxWidth = Math.max(maxWidth, (cut - x));
            x = cut;
        }
        maxWidth = Math.max(maxWidth, w - x);

        return (int) ((long) maxHeight * maxWidth % 1000000007);
    }
}
