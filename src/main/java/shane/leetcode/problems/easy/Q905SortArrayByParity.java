package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q905SortArrayByParity {

    @Test
    public void test() {
        List<int[]> cases = new ArrayList<>();
        cases.add(new int[]{3, 1, 2, 4});
        cases.add(new int[]{0});
        for (int[] aCase : cases) {
            int[] after = sortArrayByParity(aCase);
            for (int i = 0; i < after.length; i++) {
                for (int j = i + 1; j < after.length; j++) {
                    Assertions.assertThat(after[i] % 2 <= after[j] % 2).isTrue();
                }
            }
        }

    }

    public int[] sortArrayByParity(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                answer[left++] = num;
            } else {
                answer[right--] = num;
            }
        }
        return answer;
    }

}
