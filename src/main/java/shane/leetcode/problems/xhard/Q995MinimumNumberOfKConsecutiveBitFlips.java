package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q995MinimumNumberOfKConsecutiveBitFlips {

    @Test
    public void test() {
        assertThat(minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3)).isEqualTo(3);
        assertThat(minKBitFlips(new int[]{0, 1, 0}, 1)).isEqualTo(2);
        assertThat(minKBitFlips(new int[]{1, 1, 0}, 2)).isEqualTo(-1);
    }

    /**
     * 2 sec 331 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i % 2;
        }
        assertThat(minKBitFlips(arr, 10000)).isEqualTo(50000);
    }

    public int minKBitFlips(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int flipCount = 0;

        for (int cur : nums) {
            if (q.isEmpty() && cur == 1) {
                continue;
            }
            q.offer(cur);
            if (q.size() == k) {
                flipCount++;
                Queue<Integer> nextQueue = new LinkedList<>();
                while (!q.isEmpty()) {
                    int poll = q.poll();
                    if (nextQueue.isEmpty() && poll == 0) {
                        continue;
                    }
                    nextQueue.offer(poll ^ 1);
                }
                q = nextQueue;
            }
        }

        if (!q.isEmpty()) {
            return -1;
        }

        return flipCount;
    }

}
