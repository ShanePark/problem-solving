package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1748SumOfUniqueElements {

    @Test
    public void test() {
        assertThat(sumOfUnique(new int[]{1, 2, 3, 2})).isEqualTo(4);
        assertThat(sumOfUnique(new int[]{1, 2, 3, 4, 5})).isEqualTo(15);
    }

    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num]++;
        }
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1)
                sum += i;
        }
        return sum;
    }
}
