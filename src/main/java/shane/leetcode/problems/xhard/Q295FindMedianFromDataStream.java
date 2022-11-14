package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 823 ms Beats 5.1%
 * Memory 107.5 MB Beats 80.73%
 */
public class Q295FindMedianFromDataStream {

    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertThat(medianFinder.findMedian()).isEqualTo(1.5);
        medianFinder.addNum(3);
        assertThat(medianFinder.findMedian()).isEqualTo(2);
    }

    class MedianFinder {

        List<Integer> list = new ArrayList<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            int index = binarySearch(list, num);
            list.add(index, num);
        }

        private int binarySearch(List<Integer> list, int num) {
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        public double findMedian() {
            if (list.size() % 2 == 1) {
                return list.get(list.size() / 2);
            }
            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
        }
    }

}
