package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4ms
 * Beats76.56%
 */
public class Q1769MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    @Test
    public void test() {
        assertThat(minOperations("110")).isEqualTo(new int[]{1, 1, 3});
        assertThat(minOperations("001011")).isEqualTo(new int[]{11, 8, 5, 4, 3, 4});
    }

    public int[] minOperations(String boxes) {
        int leftSum = 0;
        int leftCnt = 0;
        int rightSum = 0;
        int rightCnt = 0;
        final int LENGTH = boxes.length();
        int[] answer = new int[LENGTH];
        for (int i = 1; i < LENGTH; i++) {
            if (boxes.charAt(i) == '1') {
                rightSum += i;
                rightCnt++;
            }
        }
        for (int i = 0; i < LENGTH; i++) {
            answer[i] = leftSum + rightSum;
            if (boxes.charAt(i) == '1') {
                leftCnt++;
            }
            rightSum -= rightCnt;
            leftSum += leftCnt;
            if (i < LENGTH - 1 && boxes.charAt(i + 1) == '1') {
                rightCnt--;
            }
        }
        return answer;
    }

}
