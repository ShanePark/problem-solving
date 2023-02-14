package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 100%
 * Memory 52.3 MB Beats 100%
 */
public class Q2545SortTheStudentsByTheirKthScore {

    @Test
    public void test() {
        assertThat(sortTheStudents(Ps.intArray("[[10,6,9,1],[7,5,11,2],[4,8,3,15]]"), 2))
                .isDeepEqualTo(Ps.intArray("[[7,5,11,2],[10,6,9,1],[4,8,3,15]]"));
        assertThat(sortTheStudents(Ps.intArray("[[3,4],[5,6]]"), 0))
                .isDeepEqualTo(Ps.intArray("[[5,6],[3,4]]"));
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
        return score;
    }
}
