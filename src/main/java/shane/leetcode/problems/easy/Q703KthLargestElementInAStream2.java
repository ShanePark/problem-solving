package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q703KthLargestElementInAStream2 {

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

        PriorityQueue<Integer> pq;
        int capacity;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>(k);
            this.capacity = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (pq.size() == capacity && pq.peek() < val) {
                pq.poll();
            }
            if (pq.size() < capacity) {
                pq.offer(val);
            }
            return pq.peek();
        }
    }

}


