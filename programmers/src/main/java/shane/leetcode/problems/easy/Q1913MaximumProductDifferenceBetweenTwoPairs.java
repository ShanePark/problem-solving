package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1913MaximumProductDifferenceBetweenTwoPairs {

    @Test
    public void test() {
        assertThat(maxProductDifference(new int[]{5, 6, 2, 7, 4})).isEqualTo(34);
    }

    public int maxProductDifference(int[] nums) {
        int largest = 0, secondLargest = 0;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > secondLargest) {
                secondLargest = num;
                if (largest < secondLargest) {
                    secondLargest = largest;
                    largest = num;
                }
            }
            if (num < secondSmallest) {
                secondSmallest = num;
                if (secondSmallest < smallest) {
                    secondSmallest = smallest;
                    smallest = num;
                }
            }
        }
        return largest * secondLargest - smallest * secondSmallest;
    }

}
