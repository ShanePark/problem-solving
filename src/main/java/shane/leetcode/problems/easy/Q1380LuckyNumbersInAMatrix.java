package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1380LuckyNumbersInAMatrix {

    @Test
    public void test() {
        assertThat(luckyNumbers(STool.convertToIntArray("[[3,7,8],[9,11,13],[15,16,17]]"))).containsExactly(15);
        assertThat(luckyNumbers(STool.convertToIntArray("[[1,10,4,2],[9,3,8,7],[15,16,17,12]]"))).containsExactly(12);
        assertThat(luckyNumbers(STool.convertToIntArray("[[7,8],[1,2]]"))).containsExactly(7);
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[] maxes = new int[width];
        for (int i = 0; i < width; i++) {
            int max = 0;
            for (int j = 0; j < height; j++) {
                if (max < matrix[j][i]) {
                    max = matrix[j][i];
                    maxes[i] = j;
                }
            }
        }
        int[] mins = new int[height];
        for (int i = 0; i < height; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < width; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    mins[i] = j;
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            if (mins[maxes[i]] == i) {
                answer.add(matrix[maxes[i]][i]);
            }
        }
        return answer;
    }
}
