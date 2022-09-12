package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 4 ms, faster than 60.64% of Java online submissions for Bag of Tokens.
 * Memory Usage: 43.8 MB, less than 15.66% of Java online submissions for Bag of Tokens.
 */
public class Q948BagOfTokens {

    @Test
    public void test() {
        assertThat(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200)).isEqualTo(2);
        assertThat(bagOfTokensScore(new int[]{100}, 50)).isEqualTo(0);
        assertThat(bagOfTokensScore(new int[]{100, 200}, 150)).isEqualTo(1);
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int max = 0;
        while (left <= right) {
            if (tokens[left] <= power) {
                max = Math.max(max, ++score);
                power -= tokens[left++];
            } else if (score > 0) {
                score--;
                power += tokens[right--];
            } else {
                break;
            }
        }
        return max;
    }

}
