package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 7 ms Beats 9.07% of users with Java
 */
public class Q268MissingNumber2 {

    @Test
    public void test() {
        assertThat(missingNumber(new int[]{3, 0, 1})).isEqualTo(2);
        assertThat(missingNumber(new int[]{0, 1})).isEqualTo(2);
        assertThat(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
    }

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }
        return set.stream().findAny().get();
    }

}
