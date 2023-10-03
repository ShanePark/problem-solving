package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime Details 3ms Beats 5.22%of users with Java
 * Memory Details 40.63MB Beats 7.26%of users with Java
 */
public class Q1512NumberOfGoodPairs2 {

    @Test
    public void test() {
        Assertions.assertEquals(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}), 4);
        Assertions.assertEquals(numIdenticalPairs(new int[]{1, 1, 1, 1}), 6);
        Assertions.assertEquals(numIdenticalPairs(new int[]{1, 2, 3}), 0);
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        return cnt.values()
                .stream()
                .mapToInt(n -> n * (n - 1) / 2)
                .sum();
    }

}
