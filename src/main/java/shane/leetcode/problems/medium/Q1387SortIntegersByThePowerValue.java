package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 119 ms, faster than 31.62% of Java online submissions for Sort Integers by The Power Value.
 * Memory Usage: 49.7 MB, less than 58.97% of Java online submissions for Sort Integers by The Power Value.
 */
public class Q1387SortIntegersByThePowerValue {

    @Test
    public void test() {
        assertThat(getKth(12, 15, 2)).isEqualTo(13);
        assertThat(getKth(7, 11, 4)).isEqualTo(7);
    }

    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = lo; i <= hi; i++) {
            map.put(i, power(i));
        }
        return map.entrySet().stream().sorted((a, b) -> {
            if (a.getValue() == (int) b.getValue()) {
                return Integer.compare(a.getKey(), b.getKey());
            }
            return Integer.compare(a.getValue(), b.getValue());
        }).collect(Collectors.toList()).get(k - 1).getKey();
    }

    private Integer power(int i) {
        int cnt = 0;
        while (i > 1) {
            if (i % 2 == 0) {
                i /= 2;
            } else {
                i = i * 3 + 1;
            }
            cnt++;
        }
        return cnt;
    }
}
