package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 9 ms Beats 65.84% of users with Java
 */
public class Q506RelativeRanks {

    @Test
    public void test() {
        assertThat(findRelativeRanks(new int[]{5, 4, 3, 2, 1})).isEqualTo(new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"});
        assertThat(findRelativeRanks(new int[]{10, 3, 8, 9, 4})).isEqualTo(new String[]{"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"});
    }

    public String[] findRelativeRanks(int[] score) {
        int[][] arr = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            arr[i] = new int[]{i, score[i]};
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> -a[1]));
        String[] answer = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = i + 1;
            int index = arr[i][0];
            String rankText;
            switch (rank) {
                case 1:
                    rankText = "Gold Medal";
                    break;
                case 2:
                    rankText = "Silver Medal";
                    break;
                case 3:
                    rankText = "Bronze Medal";
                    break;
                default:
                    rankText = String.valueOf(rank);
            }
            answer[index] = rankText;
        }
        return answer;
    }

}
