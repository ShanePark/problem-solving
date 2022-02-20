package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Time Limit Exceeded
 */
@SuppressWarnings("DuplicatedCode")
public class Q421MaximumXorOfTwoNumbersInAnArray2 {

    @Test
    void test() {
        Assertions.assertThat(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8})).isEqualTo(28);
        Assertions.assertThat(findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70})).isEqualTo(127);
        Assertions.assertThat(findMaximumXOR(new int[]{0})).isEqualTo(0);
        Assertions.assertThat(findMaximumXOR(new int[]{1})).isEqualTo(0);
    }

    public int findMaximumXOR(int[] nums) {

        if (nums.length == 1) {
            if (nums[0] == 0)
                return 0;
            String str = Integer.toBinaryString(nums[0]);
            StringBuffer sb = new StringBuffer();
            for (char c : str.toCharArray()) {
                sb.append(c == '0' ? 1 : 0);
                return Integer.parseInt(sb.toString(), 2);
            }
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int num : nums) {
            Set<Integer> set = map.getOrDefault(log2(num), new HashSet<>());
            set.add(num);
            map.putIfAbsent(log2(num), set);
        }

        int max = 0;

        for (Integer i : map.keySet()) {
            max = Math.max(max, i);
        }

        int result = 0;
        for (Integer i : map.get(max)) {
            for (int j = 0; j < nums.length; j++) {
                result = Math.max(result, i ^ nums[j]);
            }
        }

        return result;
    }

    public int log2(int i) {
        return (int) (Math.log(i) / Math.log(2));
    }

}
