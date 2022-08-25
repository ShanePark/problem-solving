package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime: 56 ms, faster than 91.69% of Java online submissions for Sort Integers by The Power Value.
 * Memory Usage: 41.9 MB, less than 95.29% of Java online submissions for Sort Integers by The Power Value.
 */
@SuppressWarnings("ALL")
public class Q1387SortIntegersByThePowerValue2 {

    @Test
    public void test() {
        assertThat(getKth(12, 15, 2)).isEqualTo(13);
        assertThat(getKth(7, 11, 4)).isEqualTo(7);
    }

    public int getKth(int lo, int hi, int k) {
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = lo; i <= hi; i++) {
            list.add(new int[]{i, power(i, dp)});
        }
        list.sort((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        return list.get(k - 1)[0];
    }

    private Integer power(int i, Map<Integer, Integer> dp) {
        if (i == 1)
            return 0;
        Integer memo = dp.get(i);
        if (memo != null)
            return memo;
        if (i % 2 == 0) {
            dp.put(i, power(i / 2, dp) + 1);
        } else {
            dp.put(i, power(i * 3 + 1, dp) + 1);
        }
        return dp.get(i);
    }
}
