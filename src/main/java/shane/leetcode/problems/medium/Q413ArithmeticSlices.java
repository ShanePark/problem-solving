package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q413ArithmeticSlices {

    @Test
    void test() {
        Assertions.assertThat(numberOfArithmeticSlices(new int[]{1, 2, 3, 4})).isEqualTo(3);
        Assertions.assertThat(numberOfArithmeticSlices(new int[]{1})).isEqualTo(0);
        Assertions.assertThat(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 6, 8})).isEqualTo(4);
        Assertions.assertThat(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(10);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;

        int sum = 0;
        int startIndex = 0;
        int gap = nums[1] - nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            int cur = nums[i];
            if (nums[i + 1] - cur != gap) {
                if (i - startIndex >= 2) {
                    int elementsNum = i - startIndex + 1;
                    sum += ((elementsNum * elementsNum) - 3 * elementsNum + 2) / 2;
                }

                startIndex = i;
                gap = nums[i + 1] - cur;
            }
        }

        if (startIndex <= nums.length - 2) {
            int elementsNum = nums.length - 1 - startIndex + 1;
            sum += ((elementsNum * elementsNum) - 3 * elementsNum + 2) / 2;
        }

        return sum;
    }

}
