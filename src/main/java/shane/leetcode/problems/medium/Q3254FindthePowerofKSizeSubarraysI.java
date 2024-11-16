package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime135msBeats5.34%
 */
public class Q3254FindthePowerofKSizeSubarraysI {

    @Test
    public void test() {
        assertThat(resultsArray(new int[]{1, 3, 4}, 2)).containsExactly(-1, 4);
        assertThat(resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)).containsExactly(3, 4, -1, -1, -1);
        assertThat(resultsArray(new int[]{2, 2, 2, 2, 2}, 4)).containsExactly(-1, -1);
        assertThat(resultsArray(new int[]{3, 2, 3, 2, 3, 2}, 2)).containsExactly(-1, 3, -1, 3, -1);
    }

    public int[] resultsArray(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        answer[0] = isSorted(list) ? list.get(k - 1) : -1;
        for (int i = k; i < nums.length; i++) {
            list.remove(0);
            list.add(nums[i]);
            if (isSorted(list)) {
                answer[i - k + 1] = list.get(k - 1);
                continue;
            }
            answer[i - k + 1] = -1;
        }
        return answer;
    }

    private boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) + 1 != list.get(i)) {
                return false;
            }
        }
        return true;
    }

}
