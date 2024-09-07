package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime5msBeats31.80%
 */
public class Q2028FindMissingObservations {

    @Test
    public void test() {
        assertThat(missingRolls(new int[]{3, 2, 4, 3}, 4, 2)).containsExactlyInAnyOrder(6, 6);
        assertThat(missingRolls(new int[]{1, 5, 6}, 3, 4)).containsExactlyInAnyOrder(3, 2, 2, 2);
        assertThat(missingRolls(new int[]{1, 2, 3, 4}, 6, 4)).isEmpty();
        assertThat(missingRolls(new int[]{3, 5, 3}, 5, 3)).isEmpty();
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int totalLength = rolls.length + n;
        int sum = totalLength * mean;
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum < n || n * 6 < sum) {
            return new int[]{};
        }
        int[] answer = new int[n];
        int mod = sum % n;
        for (int i = 0; i < n; i++) {
            answer[i] = sum / n;
            if (i < mod) {
                answer[i]++;
            }
        }
        return answer;
    }

}
