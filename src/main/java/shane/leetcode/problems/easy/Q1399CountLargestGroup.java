package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 13ms
 * Beats35.13%
 */
public class Q1399CountLargestGroup {

    @Test
    public void test() {
        assertThat(countLargestGroup(13)).isEqualTo(4);
        assertThat(countLargestGroup(2)).isEqualTo(2);
    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> digitCntSum = new HashMap<>();
        int maxCnt = 0;
        while (0 < n) {
            int digitSum = digitCnt(n--);
            maxCnt = Math.max(maxCnt, digitCntSum.merge(digitSum, 1, Integer::sum));
        }
        int answer = 0;
        for (Integer value : digitCntSum.values()) {
            if (value == maxCnt)
                answer++;
        }
        return answer;
    }

    private int digitCnt(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

}
