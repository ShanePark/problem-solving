package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 13 ms Beats 81.41%
 * Memory 47.9 MB Beats 5%
 */
public class Q347TopKFrequentElements2 {

    @Test
    public void test() {
        assertThat(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).containsExactlyInAnyOrder(1, 2);
        assertThat(topKFrequent(new int[]{1}, 1)).containsExactlyInAnyOrder(1);
    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.stream(nums).forEach(i -> count.merge(i, 1, Integer::sum));
        return count.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .limit(k)
                .mapToInt(e -> e.getKey())
                .toArray();
    }

}
