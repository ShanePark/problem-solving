package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * FAIL
 */
public class Q2560HouseRobberIV {

    @Test
    public void test() {
        assertThat(minCapability(new int[]{2, 3, 5, 9}, 2)).isEqualTo(5);
        assertThat(minCapability(new int[]{2, 7, 9, 3, 1}, 2)).isEqualTo(2);
    }

    @Test
    public void fail() {
        assertThat(minCapability(new int[]{9, 6, 20, 21, 8}, 3)).isEqualTo(20);
    }

    public int minCapability(int[] nums, int k) {
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            Num num = new Num(i, nums[i]);
            pq.offer(num);
        }
        Set<Integer> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            Num poll = pq.poll();
            int index = poll.index;
            if (visited.contains(index - 1) || visited.contains(index + 1)) {
                continue;
            }
            visited.add(index);
            if (visited.size() == k)
                return poll.value;
        }
        return -1;
    }

    static class Num implements Comparable<Num> {
        final int index;
        final int value;

        Num(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Num o) {
            return value - o.value;
        }

        @Override
        public String toString() {
            return "Num{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }


}
