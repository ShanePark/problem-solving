package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q922SortArrayByParityII {

    @Test
    public void test() {
        assertThat(sortArrayByParityII(new int[]{4, 2, 5, 7})).containsExactly(4, 5, 2, 7);
        assertThat(sortArrayByParityII(new int[]{2, 3})).containsExactly(2, 3);
    }

    public int[] sortArrayByParityII(int[] nums) {
        int[] answer = new int[nums.length];
        int odd = 1;
        int even = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                answer[even] = num;
                even += 2;
            } else {
                answer[odd] = num;
                odd += 2;
            }
        }
        return answer;
    }
}
