package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 67.93% of Java online submissions for Two Sum II - Input Array Is Sorted.
 * Memory Usage: 50.4 MB, less than 17.67% of Java online submissions for Two Sum II - Input Array Is Sorted.
 */
public class Q167TwoSumIIInputArrayIsSorted2 {

    @Test
    public void test() {
        assertThat(twoSum(new int[]{2, 7, 11, 15}, 9)).containsExactly(1, 2);
        assertThat(twoSum(new int[]{2, 3, 4}, 6)).containsExactly(1, 3);
        assertThat(twoSum(new int[]{1, 2, 3, 4, 8, 9}, 7)).containsExactly(3, 4);
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int current = numbers[left] + numbers[right];
        while (current != target) {
            if (current < target) {
                left++;
            } else {
                right--;
            }
            current = numbers[left] + numbers[right];
        }
        return new int[]{left + 1, right + 1};
    }
}
