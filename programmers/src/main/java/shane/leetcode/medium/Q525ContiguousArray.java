package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Time Limit Exceeded
 */
public class Q525ContiguousArray {

    @Test
    void test() {
        Assertions.assertThat(findMaxLength(new int[]{0, 1})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{0, 1, 0})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1})).isEqualTo(6);
        Assertions.assertThat(findMaxLength(new int[]{1, 1, 1})).isEqualTo(0);
        Assertions.assertThat(findMaxLength(new int[]{0, 1, 1})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0})).isEqualTo(4);
        Assertions.assertThat(findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 1, 0})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1})).isEqualTo(54);
    }

    public int n3(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum * 2 == j - i + 1) {
                    int length = j - i + 1;
                    if (length == 54) {
                        System.out.println("length = " + length);
                        System.out.println("i = " + i);
                        System.out.println("j = " + j);
                    }
                    max = Math.max(max, length);
                }
            }
        }
        return max;
    }

    public int findMaxLength(int[] nums) {
        int[] temp = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = sum + (nums[i] == 1 ? 1 : -1);
            sum = temp[i];
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (temp[i] == temp[j]) {
                    max = Math.max(max, j - i);
                    break;
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[temp.length - i - 1] == 0) {
                return Math.max(max, temp.length - i);
            }
        }

        return max;
    }
}
