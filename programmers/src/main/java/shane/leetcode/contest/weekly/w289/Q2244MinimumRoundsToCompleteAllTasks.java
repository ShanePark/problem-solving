package shane.leetcode.contest.weekly.w289;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2244MinimumRoundsToCompleteAllTasks {

    @Test
    public void test() {
        assertThat(minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4})).isEqualTo(4);
        assertThat(minimumRounds(new int[]{2, 3, 3})).isEqualTo(-1);
        assertThat(minimumRounds(new int[]{1})).isEqualTo(-1);
        assertThat(minimumRounds(new int[]{1, 1, 1})).isEqualTo(1);
        assertThat(minimumRounds(new int[]{5, 5, 5, 5})).isEqualTo(2);
        assertThat(minimumRounds(new int[]{5, 5, 5, 5, 5})).isEqualTo(2);
        assertThat(minimumRounds(new int[]{5, 5, 5, 5, 5, 5})).isEqualTo(2);
        assertThat(minimumRounds(new int[]{5, 5, 5, 5, 5, 5, 5})).isEqualTo(3);
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.merge(task, 1, (i1, i2) -> i1 + i2);
        }
        int cnt = 0;
        for (Integer n : map.keySet()) {
            Integer numberOfN = map.get(n);
            if (numberOfN == 1) {
                return -1;
            }
            cnt += (numberOfN + 2) / 3;
        }

        return cnt;
    }
}
