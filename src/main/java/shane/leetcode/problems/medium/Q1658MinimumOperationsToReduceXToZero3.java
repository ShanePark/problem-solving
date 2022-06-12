package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1658MinimumOperationsToReduceXToZero3 {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{1, 1, 1, 1, 1, 1}, 6)).isEqualTo(6);
        assertThat(minOperations(new int[]{1, 1}, 3)).isEqualTo(-1);
        assertThat(minOperations(new int[]{1, 1, 4, 2, 3}, 0)).isEqualTo(0);
        assertThat(minOperations(new int[]{1, 1, 4, 2, 3}, 5)).isEqualTo(2);
        assertThat(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10)).isEqualTo(5);
        assertThat(minOperations(new int[]{5, 6, 7, 8, 9}, 4)).isEqualTo(-1);
        assertThat(minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365)).isEqualTo(16);
        assertThat(minOperations(new int[]{1241, 8769, 9151, 3211, 2314, 8007, 3713, 5835, 2176, 8227, 5251, 9229, 904, 1899, 5513, 7878, 8663, 3804, 2685, 3501, 1204, 9742, 2578, 8849, 1120, 4687, 5902, 9929, 6769, 8171, 5150, 1343, 9619, 3973, 3273, 6427, 47, 8701, 2741, 7402, 1412, 2223, 8152, 805, 6726, 9128, 2794, 7137, 6725, 4279, 7200, 5582, 9583, 7443, 6573, 7221, 1423, 4859, 2608, 3772, 7437, 2581, 975, 3893, 9172, 3, 3113, 2978, 9300, 6029, 4958, 229, 4630, 653, 1421, 5512, 5392, 7287, 8643, 4495, 2640, 8047, 7268, 3878, 6010, 8070, 7560, 8931, 76, 6502, 5952, 4871, 5986, 4935, 3015, 8263, 7497, 8153, 384, 1136}
                , 894887480)).isEqualTo(-1);

    }

    public int minOperations(int[] nums, int x) {
        int LENGTH = nums.length;
        int[] lefts = new int[LENGTH + 1];
        int[] rights = new int[LENGTH + 1];
        for (int i = 1; i <= LENGTH; i++) {
            lefts[i] = lefts[i - 1] + nums[i - 1];
            rights[LENGTH - i] = rights[LENGTH - i + 1] + nums[LENGTH - i];
        }
        int min = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= LENGTH; i++) {
            if (lefts[i] <= x) {
                map.put(x - lefts[i], i);
            }
        }

        for (int i = LENGTH; i >= 0 && rights[i] <= x; i--) {
            Integer leftIndex = map.get(rights[i]);
            if (leftIndex != null && leftIndex <= i) {
                int size = leftIndex + LENGTH - i;
                min = min < 0 ? size : Math.min(min, size);
            }
        }

        return min;
    }

}
