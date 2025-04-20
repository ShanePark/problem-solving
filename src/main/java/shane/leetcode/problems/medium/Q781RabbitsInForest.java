package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3
 * ms
 * Beats
 * 82.48%
 */
public class Q781RabbitsInForest {

    @Test
    public void test() {
        assertThat(numRabbits(new int[]{1, 1, 2})).isEqualTo(5);
        assertThat(numRabbits(new int[]{10, 10, 10})).isEqualTo(11);
    }

    public int numRabbits(int[] answers) {
        int sum = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int answer : answers) {
            if (cntMap.containsKey(answer)) {
                int newCnt = cntMap.merge(answer, 1, Integer::sum);
                if (answer + 1 == newCnt) {
                    cntMap.remove(answer);
                }
                continue;
            }
            sum += answer + 1;
            if (answer == 0)
                continue;
            cntMap.put(answer, 1);
        }
        return sum;
    }

}
