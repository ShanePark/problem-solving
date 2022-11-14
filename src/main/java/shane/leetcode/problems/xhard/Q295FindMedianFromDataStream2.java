package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 211 ms Beats 64.14%
 * Memory 126.1 MB Beats 19.33%
 */
public class Q295FindMedianFromDataStream2 {

    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertThat(medianFinder.findMedian()).isEqualTo(1.5);
        medianFinder.addNum(3);
        assertThat(medianFinder.findMedian()).isEqualTo(2);
    }

    @Test
    public void test2() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        assertThat(medianFinder.findMedian()).isEqualTo(1);
        medianFinder.addNum(2);
        assertThat(medianFinder.findMedian()).isEqualTo(1.5);
        medianFinder.addNum(3);
        assertThat(medianFinder.findMedian()).isEqualTo(2);
        medianFinder.addNum(4);
        assertThat(medianFinder.findMedian()).isEqualTo(2.5);
        medianFinder.addNum(5);
        assertThat(medianFinder.findMedian()).isEqualTo(3);
        medianFinder.addNum(6);
        assertThat(medianFinder.findMedian()).isEqualTo(3.5);
        medianFinder.addNum(7);
        assertThat(medianFinder.findMedian()).isEqualTo(4);
        medianFinder.addNum(8);
        assertThat(medianFinder.findMedian()).isEqualTo(4.5);
        medianFinder.addNum(9);
        assertThat(medianFinder.findMedian()).isEqualTo(5);
        medianFinder.addNum(10);
        assertThat(medianFinder.findMedian()).isEqualTo(5.5);
    }

    class MedianFinder {

        PriorityQueue<Integer> bigger = new PriorityQueue<>();
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());

        public MedianFinder() {

        }

        public void addNum(int num) {
            smaller.offer(num);
            bigger.offer(smaller.poll());
            if (smaller.size() < bigger.size() - 1) {
                smaller.offer(bigger.poll());
            }
        }

        public double findMedian() {
            if (smaller.size() == bigger.size()) {
                return (smaller.peek() + bigger.peek()) / 2.0;
            }
            return bigger.peek();
        }
    }

}
