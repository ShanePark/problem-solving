package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 575 ms Beats 8.18%
 * Memory 61.6 MB Beats 6.36%
 */
public class Q2141MaximumRunningTimeOfNComputers2 {

    @Test
    void test() {
        assertThat(maxRunTime(3, new int[]{10, 10, 3, 5})).isEqualTo(8);
        assertThat(maxRunTime(2, new int[]{1, 1, 1, 1})).isEqualTo(2);
        assertThat(maxRunTime(12, new int[]{11, 89, 16, 32, 70, 67, 35, 35, 31, 24, 41, 29, 6, 53, 78, 83})).isEqualTo(43);
        assertThat(maxRunTime(2, new int[]{31, 87, 85, 44, 47, 25})).isEqualTo(159);
        assertThat(maxRunTime(1, new int[]{53, 96})).isEqualTo(149);
        assertThat(maxRunTime(2, new int[]{3, 3, 3})).isEqualTo(4);
    }

    @Test
    void tle() {
        int[] arr = new int[10000];
        Arrays.fill(arr, (int) 1e9);
        assertThat(maxRunTime(2, arr)).isEqualTo(5000000000000L);
    }

    public long maxRunTime(int n, int[] batteries) {
        if (n == 1)
            return Arrays.stream(batteries).mapToLong(Long::valueOf).sum();

        List<Integer> list = Arrays.stream(batteries)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(list.remove(0));
        }

        int index = 0;
        while (index < list.size()) {
            Integer battery = list.get(index);
            Integer min = pq.poll();
            if (min + battery > pq.peek()) {
                pq.offer(min);
                break;
            }
            pq.offer(min + battery);
            index++;
        }
        if (index == list.size()) {
            return pq.peek();
        }
        long sum = 0;
        for (int i = index; i < list.size(); i++) {
            sum += list.get(i);
        }

        int min = pq.poll();
        int minSize = 1;

        while (!pq.isEmpty()) {
            int nextMin = pq.poll();
            int diff = nextMin - min;
            if (sum < minSize * diff) {
                break;
            }
            sum -= (minSize * diff);
            min = nextMin;
            minSize++;
        }

        return min + (sum / minSize);
    }

}
