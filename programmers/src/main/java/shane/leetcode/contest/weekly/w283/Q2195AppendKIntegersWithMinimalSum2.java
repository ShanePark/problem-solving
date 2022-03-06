package shane.leetcode.contest.weekly.w283;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TLE
 */
public class Q2195AppendKIntegersWithMinimalSum2 {

    @Test
    void test() {
        Assertions.assertThat(minimalKSum(new int[]{1, 4, 25, 10, 25}, 2)).isEqualTo(5);
        Assertions.assertThat(minimalKSum(new int[]{5, 6}, 6)).isEqualTo(25);
        Assertions.assertThat(minimalKSum(new int[]{53, 41, 90, 33, 84, 26, 50, 32, 63, 47, 66, 43, 29, 88, 71, 28, 83}, 76)).isEqualTo(3444);
    }

    public long minimalKSum(int[] nums, int k) {
        int i = 1;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (list.size() < k) {
            if (!set.contains(i)) {
                list.add(i);
            }
            i++;
        }
        return list.stream().mapToLong(l -> l).sum();
    }
}
