package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 252ms Beats 9.03%of users with Java
 * Memory Details 57.53mb Beats 90.80%of users with Java
 */
public class Q239SlidingWindowMaximum2 {

    @Test
    public void test() {
        assertThat(maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)).containsExactly(3, 3, 2, 5);
        assertThat(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)).containsExactly(3, 3, 5, 5, 6, 7);
        assertThat(maxSlidingWindow(new int[]{1, -1}, 1)).containsExactly(1, -1);
        assertThat(maxSlidingWindow(new int[]{1}, 1)).containsExactly(1);
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10000);
        }
        assertThat(maxSlidingWindow(arr, 30000)).isNotEqualTo(arr);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> tree = new TreeSet<>();
        Map<Integer, Integer> cntMap = new HashMap<>();
        int[] answer = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            tree.add(num);
            cntMap.merge(num, 1, Integer::sum);

            if (i >= k - 1) {
                answer[i - k + 1] = tree.last();
                int target = nums[i - k + 1];
                int cnt = cntMap.get(target) - 1;
                cntMap.put(target, cnt);
                if (cnt == 0) {
                    tree.remove(target);
                }
            }
        }
        return answer;
    }

}
