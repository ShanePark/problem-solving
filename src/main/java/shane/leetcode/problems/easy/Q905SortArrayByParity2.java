package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q905SortArrayByParity2 {

    @Test
    public void test() {
        assertThat(sortArrayByParity(new int[]{3, 1, 2, 4})).containsExactly(2, 4, 1, 3);
    }

    public int[] sortArrayByParity(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i : nums) {
            if (i % 2 == 0) {
                answer[left++] = i;
            } else {
                answer[right--] = i;
            }
        }
        return answer;
    }
}
