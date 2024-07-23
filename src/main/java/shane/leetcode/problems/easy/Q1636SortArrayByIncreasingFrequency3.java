package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 9msBeats33.22%
 */
public class Q1636SortArrayByIncreasingFrequency3 {

    @Test
    public void test() {
        assertThat(frequencySort(new int[]{1, 1, 2, 2, 2, 3})).containsExactly(3, 1, 1, 2, 2, 2);
        assertThat(frequencySort(new int[]{2, 3, 1, 3, 2})).containsExactly(1, 3, 3, 2, 2);
        assertThat(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})).containsExactly(5, -1, 4, 4, -6, -6, 1, 1, 1);
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        int[] answer = new int[nums.length];
        AtomicInteger index = new AtomicInteger(0);
        cnt.entrySet().stream()
                .sorted(Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue())
                        .thenComparingInt(e -> -e.getKey())
                ).forEach(e -> {
                    int count = e.getValue();
                    for (int i = 0; i < count; i++) {
                        answer[index.getAndIncrement()] = e.getKey();
                    }
                });
        return answer;
    }

}
