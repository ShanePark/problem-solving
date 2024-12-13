package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 194ms Beats27.45%
 */
public class Q2593FindScoreofanArrayAfterMarkingAllElements {

    @Test
    public void test() {
        assertThat(findScore(new int[]{29, 20, 36, 39, 50, 42, 46, 34, 47})).isEqualTo(135);
        assertThat(findScore(new int[]{2, 1, 3, 4, 5, 2})).isEqualTo(7);
        assertThat(findScore(new int[]{2, 3, 5, 1, 3, 2})).isEqualTo(5);
    }

    public long findScore(int[] nums) {
        PriorityQueue<Num> pq = new PriorityQueue<>();
        Set<Integer> marked = new HashSet<>();
        Num[] arr = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Num num = new Num(i, nums[i]);
            arr[i] = num;
            pq.offer(num);
        }

        long sum = 0;
        while (marked.size() < nums.length) {
            Num poll = pq.poll();
            if (poll.marked) {
                continue;
            }
            sum += poll.value;
            marked.add(poll.index);
            poll.mark();

            if (0 < poll.index) {
                marked.add(poll.index - 1);
                arr[poll.index - 1].mark();
            }
            if (poll.index < nums.length - 1) {
                marked.add(poll.index + 1);
                arr[poll.index + 1].mark();
            }
        }
        return sum;
    }

    static class Num implements Comparable<Num> {
        final int index;
        int value;
        boolean marked = false;

        public Num(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Num o) {
            if (this.value == o.value) {
                return this.index - o.index;
            }
            return this.value - o.value;
        }

        void mark() {
            this.marked = true;
        }
    }

}
