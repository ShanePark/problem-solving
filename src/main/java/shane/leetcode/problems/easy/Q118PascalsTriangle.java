package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q118PascalsTriangle {

    @Test
    public void test() {
        assertThat(generate(5)).isEqualTo(STool.convertToIntList("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]"));
        assertThat(generate(1)).isEqualTo(STool.convertToIntList("[[1]]"));
    }

    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                dp[i][j] = (j > 0 ? dp[i - 1][j - 1] : 0) + dp[i - 1][j];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            for (int j = 0; j <= i; j++) {
                list.add(dp[i][j]);
            }
        }
        return result;
    }
}
