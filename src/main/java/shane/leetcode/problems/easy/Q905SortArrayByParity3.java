package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 5ms Beats 8.89%of users with Java
 * Memory Details 44.83MB Beats 6.93%of users with Java
 */
public class Q905SortArrayByParity3 {

    @Test
    public void test() {
        assertThat(sortArrayByParity(new int[]{3, 1, 2, 4})).containsExactly(2, 4, 3, 1);
        assertThat(sortArrayByParity(new int[]{0})).containsExactly(0);
    }

    public int[] sortArrayByParity(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
                continue;
            }
            odd.add(num);
        }
        even.addAll(odd);
        return even.stream().mapToInt(Integer::valueOf).toArray();
    }

}
