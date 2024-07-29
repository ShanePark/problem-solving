package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime12msBeats96.06%
 */
public class Q1395CountNumberOfTeams {

    @Test
    public void test() {
        assertThat(numTeams(new int[]{2, 5, 3, 4, 1})).isEqualTo(3);
        assertThat(numTeams(new int[]{2, 1, 3})).isEqualTo(0);
        assertThat(numTeams(new int[]{1, 2, 3, 4})).isEqualTo(4);
    }

    public int numTeams(int[] rating) {
        int answer = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int mid = rating[i];
            int leftSmallCnt = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < mid) {
                    leftSmallCnt++;
                }
            }
            int rightSmallCnt = 0;
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < mid) {
                    rightSmallCnt++;
                }
            }
            answer += leftSmallCnt * (rating.length - i - rightSmallCnt - 1);
            answer += (i - leftSmallCnt) * rightSmallCnt;
        }
        return answer;
    }

}
