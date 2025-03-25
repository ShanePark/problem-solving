package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 94
 * ms
 * Beats
 * 69.30%
 */
public class Q3394CheckIfGridCanBeCutIntoSections2 {

    @Test
    public void test() {
        assertThat(checkValidCuts(4, Ps.intArray("[[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]"))).isFalse();
        assertThat(checkValidCuts(4, Ps.intArray("[[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]"))).isTrue();
        assertThat(checkValidCuts(5, Ps.intArray("[[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]"))).isTrue();
    }

    @Test
    public void test2() {
        assertThat(checkValidCuts(3, Ps.intArray("[[0,0,1,3],[1,0,2,2],[2,0,3,2],[1,2,3,3]]"))).isFalse();
    }

    @Test
    public void test3() {
        assertThat(checkValidCuts(4, Ps.intArray("[[0,0,1,4],[1,0,2,3],[2,0,3,3],[3,0,4,3],[1,3,4,4]]"))).isFalse();
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        return check(rectangles, 0) || check(rectangles, 1);
    }

    private static boolean check(int[][] rectangles, int start) {
        int end = start + 2;
        Arrays.sort(rectangles, Comparator.comparingInt(r -> r[start]));
        int lastEnd = rectangles[0][end];
        int cut = 0;
        for (int[] r : rectangles) {
            if (lastEnd <= r[start]) {
                if (++cut == 2)
                    return true;
            }
            lastEnd = Math.max(lastEnd, r[end]);
        }
        return false;
    }

}
