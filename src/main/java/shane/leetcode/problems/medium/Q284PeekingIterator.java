package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q284PeekingIterator {

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator i = new PeekingIterator(list.iterator());
        assertThat(i.next()).isEqualTo(1);
        assertThat(i.peek()).isEqualTo(2);
        assertThat(i.next()).isEqualTo(2);
        assertThat(i.next()).isEqualTo(3);
    }

    class PeekingIterator implements Iterator<Integer> {
        Queue<Integer> q = new LinkedList<>();

        public PeekingIterator(Iterator<Integer> iterator) {
            while (iterator.hasNext()) {
                q.offer(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return q.peek();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return q.poll();
        }

        @Override
        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

}
