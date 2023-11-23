package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 101ms Beats 5.49%of users with Java
 * Memory Details 44.55MB Beats 25.00%of users with Java
 */
public class Q1630ArithmeticSubarrays2 {

    @Test
    public void test() {
        assertThat(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5})).containsExactly(true, false, true);
        assertThat(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0}, new int[]{1})).containsExactly(true);
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];
            result.add(isValid(nums, start, end));
        }
        return result;
    }

    private Boolean isValid(int[] nums, int start, int end) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = start; i <= end; i++) {
            set.add(nums[i]);
        }
        if (set.size() == 1)
            return true;
        if (set.size() != end - start + 1)
            return false;
        List<Integer> sorted = set.stream().sorted()
                .collect(Collectors.toList());
        int diff = sorted.get(1) - sorted.get(0);
        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i + 1) - sorted.get(i) != diff) {
                return false;
            }
        }
        return true;
    }

}
