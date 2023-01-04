package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 78 ms Beats 47.48%
 * Memory 101.7 MB Beats 53.57%
 */
public class Q2244MinimumRoundsToCompleteAllTasks {

    @Test
    public void test() {
        assertThat(minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4})).isEqualTo(4);
        assertThat(minimumRounds(new int[]{2, 3, 3})).isEqualTo(-1);
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int task : tasks) {
            cntMap.merge(task, 1, Integer::sum);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> e : cntMap.entrySet()) {
            Integer value = e.getValue();
            if (value == 1)
                return -1;
            cnt += e.getValue() / 3;
            if (e.getValue() % 3 != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
