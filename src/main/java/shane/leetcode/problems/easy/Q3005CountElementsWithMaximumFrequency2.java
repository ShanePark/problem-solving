package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4ms
 * Beats6.12%
 */
public class Q3005CountElementsWithMaximumFrequency2 {

    @Test
    public void test() {
        assertThat(maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4})).isEqualTo(4);
        assertThat(maxFrequencyElements(new int[]{1, 2, 3, 4, 5})).isEqualTo(5);
    }

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int answer = 0;
        int max = 0;
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int curCnt = e.getValue();
            if (curCnt < max)
                continue;
            if (max < curCnt) {
                answer = 0;
                max = curCnt;
            }
            answer += e.getValue();
        }
        return answer;
    }

}
