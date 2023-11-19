package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 74ms Beats 20.39%of users with Java
 * Memory Details 55.14MB Beats 30.92%of users with Java
 */
public class Q1887ReductionOperationsToMakeTheArrayElementsEqual {

    @Test
    public void test() {
        assertThat(reductionOperations(new int[]{5, 1, 3})).isEqualTo(3);
        assertThat(reductionOperations(new int[]{1, 1, 1})).isEqualTo(0);
        assertThat(reductionOperations(new int[]{1, 1, 2, 2, 3})).isEqualTo(4);
        assertThat(reductionOperations(new int[]{7, 9, 10, 8, 6, 4, 1, 5, 2, 3})).isEqualTo(45);
    }

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        LinkedHashMap<Integer, Integer> cnt = new LinkedHashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        List<Integer> keys = cnt.keySet().stream().collect(Collectors.toList());
        int targets = 0;
        int answer = 0;
        for (int i = keys.size() - 1; i > 0; i--) {
            int key = keys.get(i);
            targets += cnt.get(key);
            answer += targets;
        }
        return answer;
    }

}
