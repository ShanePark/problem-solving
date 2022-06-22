package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1850MinimumAdjacentSwapsToReachTheKthSmallestNumber2 {

    @Test
    public void test() {
        assertThat(getMinSwaps("059", 5)).isEqualTo(3);
        assertThat(getMinSwaps("5489355142", 4)).isEqualTo(2);
        assertThat(getMinSwaps("11112", 4)).isEqualTo(4);
        assertThat(getMinSwaps("00123", 1)).isEqualTo(1);
    }

    public int getMinSwaps(String num, int k) {
        int length = num.length();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = num.charAt(i) - '0';
        }
        for (int i = 0; i < k; i++) {
            nextPermutation(arr);
        }

        int cnt = 0;
        for (int i = 0; i < length; i++) {
            int n = num.charAt(i) - '0';
            if (n != arr[i]) {
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] == n) {
                        while (i < j) {
                            int tmp = arr[j];
                            arr[j] = arr[j - 1];
                            arr[j - 1] = tmp;
                            j--;
                            cnt++;
                        }
                        break;
                    }
                }
            }
        }

        return cnt;
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return;

        int n = length - 2;
        while (n >= 0 && nums[n] >= nums[n + 1])
            n--;

        if (n >= 0) {
            int j = length - 1;
            while (j > n && nums[j] <= nums[n]) {
                j--;
            }
            int tmp = nums[n];
            nums[n] = nums[j];
            nums[j] = tmp;
        }

        while (n + 1 < length - 1) {
            int tmp = nums[n + 1];
            nums[n + 1] = nums[length - 1];
            nums[length - 1] = tmp;
            n++;
            length--;
        }
    }
}
