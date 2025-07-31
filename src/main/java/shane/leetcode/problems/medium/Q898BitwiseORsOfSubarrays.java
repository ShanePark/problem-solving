package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 336ms
 * Beats64.76%
 */
public class Q898BitwiseORsOfSubarrays {

    @Test
    public void test() {
        assertThat(subarrayBitwiseORs(new int[]{0})).isEqualTo(1);
        assertThat(subarrayBitwiseORs(new int[]{1, 1, 2})).isEqualTo(3);
        assertThat(subarrayBitwiseORs(new int[]{1, 2, 4})).isEqualTo(6);
    }

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> answer = new HashSet<>();
        Set<Integer> before = new HashSet<>();
        for (int i : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(i);
            for (Integer j : before) {
                next.add(i | j);
            }
            before = next;
            answer.addAll(next);
        }
        return answer.size();
    }

}
