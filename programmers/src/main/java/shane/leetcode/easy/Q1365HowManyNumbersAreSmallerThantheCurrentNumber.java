package shane.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1365HowManyNumbersAreSmallerThantheCurrentNumber {

    @Test
    void test() {
        assertThat(smallerNumbersThanCurrent(new int[]{6, 5, 4, 9})).containsExactly(2, 1, 0, 3);
        assertThat(smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})).containsExactly(0, 0, 0, 0);
        assertThat(smallerNumbersThanCurrent(new int[]{0, 1, 2, 3})).containsExactly(0, 1, 2, 3);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[101];
        for (int i : nums) {
            arr[i]++;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1] = arr[i] + arr[i + 1];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 0;
            } else {
                answer[i] = arr[nums[i] - 1];
            }
        }

        return answer;
    }
}
