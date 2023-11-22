package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 53 / 56 testcases passed
 */
public class Q1424DiagonalTraverseII {

    @Test
    public void test() {
        assertThat(findDiagonalOrder(Ps.intList("[[1,2,3],[4,5,6],[7,8,9]]"))).isEqualTo(new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9});
        assertThat(findDiagonalOrder(Ps.intList("[[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]"))).isEqualTo(new int[]{1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16});
    }

    @Test
    public void test2() {
        assertThat(findDiagonalOrder(Ps.intList("[[1],[2],[3],[4],[5],[6]]"))).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(findDiagonalOrder(Ps.intList("[[1,2,3,4,5,6]]"))).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    public void tle() {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(List.of(1));
        }
        assertThat(findDiagonalOrder(list)).hasSize(100000);
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int max = nums.size();
        for (List<Integer> num : nums) {
            max = Math.max(max, num.size());
        }
        List<Integer> answer = new ArrayList<>();
        final int HEIGHT = nums.size();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j <= i; j++) {
                List<Integer> row = nums.get(i - j);
                if (j < row.size()) {
                    answer.add(row.get(j));
                }
            }
        }


        for (int j = 1; j < max; j++) {
            for (int i = 0; i < max; i++) {
                int rowIndex = HEIGHT - 1 - i;
                if (rowIndex < 0)
                    continue;
                List<Integer> row = nums.get(rowIndex);
                if (j + i < row.size()) {
                    answer.add(row.get(j + i));
                }
            }
        }

        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

}
