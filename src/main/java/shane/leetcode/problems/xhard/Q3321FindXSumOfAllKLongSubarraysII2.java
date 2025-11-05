package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3321FindXSumOfAllKLongSubarraysII2 {

    @Test
    public void test() {
        assertThat(findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)).isEqualTo(new long[]{6, 10, 12});
        assertThat(findXSum(new int[]{3, 8, 7, 8, 7, 5}, 2, 2)).isEqualTo(new long[]{11, 15, 15, 15, 12});
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        assertThat(findXSum(arr, 1, 1)).isEqualTo(Arrays.stream(arr).mapToLong(Long::valueOf).toArray());
    }

    public long[] findXSum(int[] nums, int k, int x) {
        long[] answer = new long[nums.length - k + 1];
        if (x == 0) {
            return answer;
        }

        Map<Integer, Counter> map = new HashMap<>();
        TopXTracker tracker = new TopXTracker(x);

        for (int i = 0; i < k; i++) {
            Counter counter = map.computeIfAbsent(nums[i], Counter::new);
            tracker.increase(counter);
        }
        answer[0] = tracker.sum();

        for (int i = 1; i < answer.length; i++) {
            tracker.decrease(map.get(nums[i - 1]));
            Counter counter = map.computeIfAbsent(nums[i + k - 1], Counter::new);
            tracker.increase(counter);
            answer[i] = tracker.sum();
        }

        return answer;
    }

    static class TopXTracker {
        private final int limit;
        private final TreeSet<Counter> top = new TreeSet<>();
        private final TreeSet<Counter> rest = new TreeSet<>();
        private long sum = 0;

        TopXTracker(int limit) {
            this.limit = limit;
        }

        public void increase(Counter counter) {
            removeFromCurrentSet(counter);
            counter.count++;
            rest.add(counter);
            counter.state = State.REST;
            rebalance();
        }

        public void decrease(Counter counter) {
            removeFromCurrentSet(counter);
            counter.count--;
            if (counter.count > 0) {
                rest.add(counter);
                counter.state = State.REST;
            }
            rebalance();
        }

        public long sum() {
            return sum;
        }

        private void rebalance() {
            while (!rest.isEmpty() && top.size() < limit) {
                Counter best = rest.pollFirst();
                moveToTop(best);
            }
            while (!rest.isEmpty() && !top.isEmpty() && rest.first().compareTo(top.last()) < 0) {
                Counter bestRest = rest.pollFirst();
                Counter worstTop = top.pollLast();
                sum -= worstTop.weight();
                worstTop.state = State.NONE;
                if (worstTop.count > 0) {
                    rest.add(worstTop);
                    worstTop.state = State.REST;
                }
                moveToTop(bestRest);
            }
        }

        private void removeFromCurrentSet(Counter counter) {
            if (counter.state == State.TOP) {
                top.remove(counter);
                sum -= counter.weight();
            } else if (counter.state == State.REST) {
                rest.remove(counter);
            }
            counter.state = State.NONE;
        }

        private void moveToTop(Counter counter) {
            top.add(counter);
            counter.state = State.TOP;
            sum += counter.weight();
        }
    }

    enum State {
        NONE,
        TOP,
        REST
    }

    static class Counter implements Comparable<Counter> {
        final int num;
        int count = 0;
        State state = State.NONE;

        Counter(int num) {
            this.num = num;
        }

        long weight() {
            return (long) num * count;
        }

        @Override
        public int compareTo(Counter o) {
            if (this.count == o.count)
                return o.num - this.num;
            return Long.compare(o.count, this.count);
        }

        @Override
        public String toString() {
            return "Counter{" +
                    "num=" + num +
                    ", count=" + count +
                    '}';
        }
    }

}
