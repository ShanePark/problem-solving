package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats100.00%
 */
public class Q2965FindMissingAndRepeatedValues2 {

    @Test
    public void test() {
        assertThat(findMissingAndRepeatedValues(Ps.intArray("[[1,3],[2,2]]"))).isEqualTo(new int[]{2, 4});
        assertThat(findMissingAndRepeatedValues(Ps.intArray("[[9,1,7],[8,9,2],[3,4,6]]"))).isEqualTo(new int[]{9, 5});
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int sum = (grid.length * grid.length + 1) * grid.length * grid.length / 2;
        boolean[] visit = new boolean[grid.length * grid.length + 1];
        int duplicated = -1;
        for (int[] ints : grid) {
            for (int i : ints) {
                if (visit[i]) {
                    duplicated = i;
                }
                visit[i] = true;
                sum -= i;
            }
        }
        return new int[]{duplicated, duplicated + sum};
    }

}
