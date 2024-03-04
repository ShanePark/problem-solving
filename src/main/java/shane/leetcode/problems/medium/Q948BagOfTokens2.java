package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 5.73% of users with Java
 */
public class Q948BagOfTokens2 {

    @Test
    public void test() {
        assertThat(bagOfTokensScore(new int[]{59, 0, 15, 33, 79, 72, 34, 62, 4, 16}, 99)).isEqualTo(6);
        assertThat(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200)).isEqualTo(2);
        assertThat(bagOfTokensScore(new int[]{100}, 50)).isEqualTo(0);
        assertThat(bagOfTokensScore(new int[]{100, 200}, 150)).isEqualTo(1);
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int token = 0;
        int max = 0;
        while (left <= right) {
            int rightRemember = right;
            // get tokens as possible
            int powerTmp = power;
            int tokenTmp = token;
            int leftTmp = left;
            while (leftTmp < tokens.length && tokens[leftTmp] <= powerTmp && leftTmp <= right) {
                powerTmp -= tokens[leftTmp++];
                tokenTmp++;
            }
            max = Math.max(max, tokenTmp);
            if (leftTmp != left) {
                power -= tokens[left++];
                token++;
            }
            // use tokens as possible
            for (int i = 0; i < token && right >= 0; i++) {
                token--;
                power += tokens[right--];
            }
            if (left == right || right == rightRemember) {
                break;
            }
        }
        return max;
    }

}
