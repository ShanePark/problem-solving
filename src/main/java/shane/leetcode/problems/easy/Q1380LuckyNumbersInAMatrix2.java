package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime3msBeats42.69%
 */
public class Q1380LuckyNumbersInAMatrix2 {

    @Test
    public void test() {
        assertThat(luckyNumbers(Ps.intArray("[[3,7,8],[9,11,13],[15,16,17]]"))).containsExactly(15);
        assertThat(luckyNumbers(Ps.intArray("[[1,10,4,2],[9,3,8,7],[15,16,17,12]]"))).containsExactly(12);
        assertThat(luckyNumbers(Ps.intArray("[[7,8],[1,2]]"))).containsExactly(7);
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> minSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j : matrix[i]) {
                min = Math.min(min, j);
            }
            minSet.add(min);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int max = 0;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            if (minSet.contains(max)) {
                answer.add(max);
            }
        }
        return answer;
    }

}
