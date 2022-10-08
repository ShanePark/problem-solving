package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 13 ms, faster than 39.09% of Java online submissions for Sort Array by Increasing Frequency.
 * Memory Usage: 42.8 MB, less than 88.04% of Java online submissions for Sort Array by Increasing Frequency.
 */
public class Q1636SortArrayByIncreasingFrequency2 {

    @Test
    public void test() {
        assertThat(frequencySort(new int[]{1, 1, 2, 2, 2, 3})).containsExactly(3, 1, 1, 2, 2, 2);
        assertThat(frequencySort(new int[]{2, 3, 1, 3, 2})).containsExactly(1, 3, 3, 2, 2);
        assertThat(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})).containsExactly(5, -1, 4, 4, -6, -6, 1, 1, 1);
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(n -> map.merge(n, 1, Integer::sum));
        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            if ((int) map.get(a) == map.get(b)) {
                return Integer.compare(b, a);
            }
            return Integer.compare(map.get(a), map.get(b));
        }).mapToInt(i -> i).toArray();
    }

}
