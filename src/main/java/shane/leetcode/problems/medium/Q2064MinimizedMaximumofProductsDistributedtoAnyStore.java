package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 44ms Beats77.86% 
 */
public class Q2064MinimizedMaximumofProductsDistributedtoAnyStore {

    @Test
    public void test() {
        assertThat(minimizedMaximum(2, new int[]{5, 7})).isEqualTo(7);
        assertThat(minimizedMaximum(6, new int[]{11, 6})).isEqualTo(3);
        assertThat(minimizedMaximum(7, new int[]{15, 10, 10})).isEqualTo(5);
        assertThat(minimizedMaximum(1, new int[]{100000})).isEqualTo(100000);

    }

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 100000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int calcStore = calcStoreCount(quantities, mid);
            if (calcStore <= n) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    private int calcStoreCount(int[] quantities, int size) {
        int sum = 0;
        for (int quantity : quantities) {
            sum += quantity / size;
            if (quantity % size > 0)
                sum++;
        }
        return sum;
    }

}
