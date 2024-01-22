package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12 ms Beats 20.23% of users with Java
 */
public class Q645SetMismatch2 {

    @Test
    public void test() {
        assertThat(findErrorNums(new int[]{1, 2, 2, 4})).containsExactly(2, 3);
        assertThat(findErrorNums(new int[]{1, 1})).containsExactly(1, 2);
    }

    public int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= length; i++) {
            set.add(i);
        }
        for (int num : nums) {
            if (!set.remove(num)) {
                answer[0] = num;
            }
        }
        answer[1] = set.iterator().next();
        return answer;
    }

}
