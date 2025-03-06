package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 7ms
 * Beats13.98%
 */
public class Q2965FindMissingAndRepeatedValues {

    @Test
    public void test() {
        assertThat(findMissingAndRepeatedValues(Ps.intArray("[[1,3],[2,2]]"))).isEqualTo(new int[]{2, 4});
        assertThat(findMissingAndRepeatedValues(Ps.intArray("[[9,1,7],[8,9,2],[3,4,6]]"))).isEqualTo(new int[]{9, 5});
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length * grid.length; i++) {
            set.add(i + 1);
        }
        int[] answer = new int[2];
        for (int[] ints : grid) {
            for (int i : ints) {
                if (!set.remove(i)) {
                    answer[0] = i;
                }
            }
        }
        answer[1] = set.stream().findAny().orElse(-1);
        return answer;
    }

}
