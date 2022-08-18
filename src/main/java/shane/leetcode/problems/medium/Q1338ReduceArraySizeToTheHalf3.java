package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 123 ms, faster than 30.36% of Java online submissions for Reduce Array Size to The Half.
 * Memory Usage: 86 MB, less than 58.82% of Java online submissions for Reduce Array Size to The Half.
 */
public class Q1338ReduceArraySizeToTheHalf3 {

    @Test
    public void test() {
        assertThat(minSetSize(new int[]{1, 9})).isEqualTo(1);
        assertThat(minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7})).isEqualTo(2);
        assertThat(minSetSize(new int[]{7, 7, 7, 7, 7, 7})).isEqualTo(1);
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> cntMap = new LinkedHashMap<>();
        for (int i : arr) {
            cntMap.merge(i, 1, Integer::sum);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer v : cntMap.values()) {
            pq.offer(v);
        }
        int sum = 0;
        while (sum < arr.length / 2) {
            sum += pq.poll();
        }
        return cntMap.size() - pq.size();
    }
}
