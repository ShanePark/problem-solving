package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1850MinimumAdjacentSwapsToReachTheKthSmallestNumber {

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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = -1;
        int length = nums.length;

        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i];
            if (pq.isEmpty() || max <= num) {
                pq.offer(num);
                max = Math.max(max, num);
            } else {
                int j = i;
                pq.offer(num);
                while (num >= pq.peek()) {
                    nums[++j] = pq.poll();
                }
                nums[i] = pq.poll();
                while (!pq.isEmpty()) {
                    nums[++j] = pq.poll();
                }
                return;
            }
        }

        // reverse array
        for (int i = 0; i < length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[length - 1 - i];
            nums[length - 1 - i] = tmp;
        }
    }
}
