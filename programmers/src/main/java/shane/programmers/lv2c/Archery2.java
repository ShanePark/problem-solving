package shane.programmers.lv2c;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Archery2 {

    @Test
    void test() {
        Assertions.assertThat(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})).containsExactly(0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0);
        Assertions.assertThat(solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})).containsExactly(-1);
        Assertions.assertThat(solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})).containsExactly(1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0);
        Assertions.assertThat(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})).containsExactly(1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2);
    }

    int[] lionBest;
    int maxScore;

    public int[] solution(int n, int[] info) {
        int apeachScore = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != 0)
                apeachScore += (10 - i);
        }
        maxScore = -apeachScore;

        backTracking(n, new int[11], info, -apeachScore, 10);

        return maxScore > 0 ? lionBest : new int[]{-1};
    }

    private void backTracking(int arrow, int[] lion, int[] apeach, int currentScore, int i) {
        if (arrow == 0 || i < 0) {
            if (currentScore > maxScore) {
                lionBest = Arrays.copyOf(lion, 11);
                lionBest[10] += arrow;
                maxScore = currentScore;
            }
            return;
        }

        // shoot
        int required = apeach[i] + 1;
        if (arrow >= required) {
            lion[i] = required;
            int bonus = required == 1 ? (10 - i) : 2 * (10 - i);
            backTracking(arrow - required, lion, apeach, currentScore + bonus, i - 1);
            lion[i] = 0;
        }

        // skip
        backTracking(arrow, lion, apeach, currentScore, i - 1);

    }

}
