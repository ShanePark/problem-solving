package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1630ArithmeticSubarrays {

    @Test
    public void test() {
        assertThat(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5})).containsExactly(true, false, true);
        assertThat(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0}, new int[]{1})).containsExactly(true);
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            answer.add(isValid(nums, l[i], r[i]));
        }
        return answer;
    }

    private Boolean isValid(int[] nums, int l, int r) {
        if (r == l + 1) {
            return true;
        }
        int[] temp = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            temp[i - l] = nums[i];
        }
        Arrays.sort(temp);

        int gap = temp[1] - temp[0];
        for (int i = 1; i < temp.length - 1; i++) {
            if (temp[i + 1] - temp[i] != gap) {
                return false;
            }
        }
        return true;
    }
}
