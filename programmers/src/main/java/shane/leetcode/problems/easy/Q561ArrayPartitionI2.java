package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q561ArrayPartitionI2 {
    @Test
    public void test() {
        assertThat(arrayPairSum(new int[]{1, 4, 3, 2})).isEqualTo(4);
        assertThat(arrayPairSum(new int[]{6, 2, 6, 5, 1, 2})).isEqualTo(9);
    }

    public int arrayPairSum(int[] nums) {
        int[] arr = new int[200001];
        for (int num : nums) {
            arr[num + 10000]++;
        }
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (flag) {
                    sum += i - 10000;
                }
                arr[i]--;
                flag = !flag;
            }
        }
        return sum;
    }
}
