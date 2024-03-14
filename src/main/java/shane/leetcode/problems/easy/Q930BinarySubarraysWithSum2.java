package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q930BinarySubarraysWithSum2 {

    @Test
    public void test() {
        assertThat(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2)).isEqualTo(4);
        assertThat(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0)).isEqualTo(15);
    }

    @Test
    public void tle() {
        int[] arr = new int[3 * (int) 1e4];
        assertThat(numSubarraysWithSum(arr, 0)).isEqualTo(450015000);
    }

    /**
     * 1 sec 391 ms
     */
    @Test
    public void tle2() {
        int[] arr = new int[3 * (int) 1e4];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                arr[i] = 1;
        }
        assertThat(numSubarraysWithSum(arr, 10322)).isEqualTo(18714);
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (goal == num)
                cnt++;
            if (num == 0) {
                cnt += cntMap.getOrDefault(goal, 0);
                cntMap.merge(0, 1, Integer::sum);
                continue;
            }
            Map<Integer, Integer> tmp = new HashMap<>();
            for (Map.Entry<Integer, Integer> e : cntMap.entrySet()) {
                int nextValue = e.getKey() + 1;
                if (nextValue == goal)
                    cnt += e.getValue();
                if (nextValue > goal || nums.length - i + nextValue < goal)
                    continue;
                tmp.merge(nextValue, e.getValue(), Integer::sum);
            }
            if (nums.length - i + 1 >= goal)
                tmp.merge(1, 1, Integer::sum);
            cntMap = tmp;
        }
        return cnt;
    }

}
