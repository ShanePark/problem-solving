package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 5
 * ms
 * Beats
 * 72.10%
 */
public class Q1394FindLuckyIntegerInAnArray {

    @Test
    public void test() {
        assertThat(findLucky(new int[]{2, 2, 3, 4})).isEqualTo(2);
        assertThat(findLucky(new int[]{1, 2, 2, 3, 3, 3})).isEqualTo(3);
        assertThat(findLucky(new int[]{2, 2, 2, 3, 3})).isEqualTo(-1);
    }

    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> cntMap = new TreeMap<>(Comparator.reverseOrder());
        for (int i : arr) {
            cntMap.merge(i, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : cntMap.entrySet()) {
            if ((int) e.getKey() == e.getValue())
                return e.getKey();
        }
        return -1;
    }

}
