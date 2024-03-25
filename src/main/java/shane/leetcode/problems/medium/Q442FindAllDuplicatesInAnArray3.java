package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 24 ms Beats 15.01% of users with Java
 */
public class Q442FindAllDuplicatesInAnArray3 {

    @Test
    public void test() {
        assertThat(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})).containsExactly(2, 3);
        assertThat(findDuplicates(new int[]{1, 1, 2})).containsExactly(1);
        assertThat(findDuplicates(new int[]{1})).containsExactly();
    }

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        return cnt.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
