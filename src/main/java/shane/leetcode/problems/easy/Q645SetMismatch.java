package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Set Mismatch.
 * Memory Usage: 44 MB, less than 89.51% of Java online submissions for Set Mismatch.
 */
public class Q645SetMismatch {

    @Test
    public void test() {
        assertThat(findErrorNums(new int[]{1, 2, 2, 4})).containsExactly(2, 3);
        assertThat(findErrorNums(new int[]{1, 1})).containsExactly(1, 2);
    }

    public int[] findErrorNums(int[] nums) {
        int[] bucket = new int[nums.length];
        for (int num : nums) {
            bucket[num - 1]++;
        }

        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (bucket[i] == 0) {
                answer[1] = i + 1;
            } else if (bucket[i] == 2) {
                answer[0] = i + 1;
            }
        }
        return answer;
    }

}
