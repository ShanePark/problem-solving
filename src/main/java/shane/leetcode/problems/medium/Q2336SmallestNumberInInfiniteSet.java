package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 11 ms Beats 88.39%
 * Memory 43 MB Beats 77.5%
 */
public class Q2336SmallestNumberInInfiniteSet {

    @Test
    public void test() {
        SmallestInfiniteSet set = new SmallestInfiniteSet();
        set.addBack(2);
        assertThat(set.popSmallest()).isEqualTo(1);
        assertThat(set.popSmallest()).isEqualTo(2);
        assertThat(set.popSmallest()).isEqualTo(3);
        set.addBack(1);
        set.addBack(1);
        assertThat(set.popSmallest()).isEqualTo(1);
        assertThat(set.popSmallest()).isEqualTo(4);
        assertThat(set.popSmallest()).isEqualTo(5);
    }

    class SmallestInfiniteSet {

        int min = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> pqset = new HashSet<>();

        public SmallestInfiniteSet() {

        }

        public int popSmallest() {
            if (pq.isEmpty())
                return min++;
            Integer peek = pq.peek();
            if (peek < min) {
                pqset.remove(peek);
                return pq.poll();
            }
            if (peek == min) {
                min++;
                return pq.poll();
            }
            throw new IllegalArgumentException();
        }

        public void addBack(int num) {
            if (min <= num)
                return;
            if (pqset.contains(num))
                return;
            pq.offer(num);
            pqset.add(num);
        }
    }

}
