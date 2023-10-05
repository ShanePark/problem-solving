package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 10ms Beats 49.32%of users with Java
 * Memory Details 46.40MB Beats 64.44%of users with Java
 */
public class Q229MajorityElementII {

    @Test
    public void test() {
        assertThat(majorityElement(new int[]{3, 2, 3})).containsExactlyInAnyOrder(3);
        assertThat(majorityElement(new int[]{1})).containsExactlyInAnyOrder(1);
        assertThat(majorityElement(new int[]{1, 2})).containsExactlyInAnyOrder(1, 2);
    }

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        return cnt.entrySet()
                .stream()
                .filter(e -> e.getValue() > nums.length / 3)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

}
