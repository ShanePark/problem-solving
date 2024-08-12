package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime14msBeats51.46%
 */
public class Q703KthLargestElementInAStream4 {

    @Test
    public void test() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertThat(kthLargest.add(3)).isEqualTo(4);
        assertThat(kthLargest.add(5)).isEqualTo(5);
        assertThat(kthLargest.add(10)).isEqualTo(5);
        assertThat(kthLargest.add(9)).isEqualTo(8);
        assertThat(kthLargest.add(4)).isEqualTo(8);
    }

    @Test
    public void test2() {
        KthLargest kthLargest = new KthLargest(1, new int[]{});
        assertThat(kthLargest.add(-3)).isEqualTo(-3);
        assertThat(kthLargest.add(-2)).isEqualTo(-2);
        assertThat(kthLargest.add(-4)).isEqualTo(-2);
        assertThat(kthLargest.add(0)).isEqualTo(0);
        assertThat(kthLargest.add(4)).isEqualTo(4);
    }

    @Test
    public void test3() {
        KthLargest kthLargest = new KthLargest(2, new int[]{0});
        assertThat(kthLargest.add(-1)).isEqualTo(-1);
        assertThat(kthLargest.add(1)).isEqualTo(0);
        assertThat(kthLargest.add(-2)).isEqualTo(0);
        assertThat(kthLargest.add(-4)).isEqualTo(0);
        assertThat(kthLargest.add(3)).isEqualTo(1);
    }

    class KthLargest {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                pq.offer(num);
            }
            while (pq.size() > k) {
                pq.poll();
            }
        }

        public int add(int val) {
            if (pq.size() < k) {
                pq.offer(val);
                return pq.peek();
            }
            if (val <= pq.peek()) {
                return pq.peek();
            }
            pq.poll();
            pq.offer(val);
            return pq.peek();
        }

    }

}


