package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 51.55%
 * Memory 43.1 MB Beats 44.66%
 */
public class Q223RectangleArea {

    @Test
    public void test() {
        assertThat(computeArea(-2, -2, 2, 2, 3, 3, 4, 4)).isEqualTo(17);
        assertThat(computeArea(-3, 0, 3, 4, 0, -1, 9, 2)).isEqualTo(45);
        assertThat(computeArea(-2, -2, 2, 2, -2, -2, 2, 2)).isEqualTo(16);
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int dimA = (ax2 - ax1) * (ay2 - ay1);
        int dimB = (bx2 - bx1) * (by2 - by1);
        int area = dimA + dimB;

        int duplicatedX = (ax1 < bx1) ? (Math.min(ax2, bx2) - bx1) : (Math.min(ax2, bx2) - ax1);
        int duplicatedY = (ay1 < by1) ? (Math.min(ay2, by2) - by1) : (Math.min(ay2, by2) - ay1);

        if (duplicatedX > 0 && duplicatedY > 0) {
            area -= duplicatedX * duplicatedY;
        }
        return area;
    }
}
