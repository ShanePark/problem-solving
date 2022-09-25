package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 9 ms, faster than 31.44% of Java online submissions for Design Circular Queue.
 * Memory Usage: 48.7 MB, less than 10.68% of Java online submissions for Design Circular Queue.
 */
public class Q622DesignCircularQueue {

    @Test
    public void test() {
        MyCircularQueue q = new MyCircularQueue(3);
        assertThat(q.enQueue(1)).isEqualTo(true);
        assertThat(q.enQueue(2)).isEqualTo(true);
        assertThat(q.enQueue(3)).isEqualTo(true);
        assertThat(q.enQueue(4)).isEqualTo(false);
        assertThat(q.Rear()).isEqualTo(3);
        assertThat(q.isFull()).isTrue();
        assertThat(q.deQueue()).isTrue();
        assertThat(q.enQueue(4)).isTrue();
        assertThat(q.Rear()).isEqualTo(4);
    }

    class MyCircularQueue {

        final int MAX_SIZE;
        Deque<Integer> q = new LinkedList<>();

        public MyCircularQueue(int k) {
            this.MAX_SIZE = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            q.offerLast(value);
            return true;
        }

        public boolean deQueue() {
            if (q.isEmpty())
                return false;
            q.removeFirst();
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return q.peekFirst();

        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return q.peekLast();
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }

        public boolean isFull() {
            return q.size() == MAX_SIZE;
        }
    }

}
