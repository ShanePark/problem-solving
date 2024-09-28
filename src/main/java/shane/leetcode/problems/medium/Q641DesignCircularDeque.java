package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime5msBeats37.86%
 */
public class Q641DesignCircularDeque {

    @Test
    public void test() {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        assertThat(myCircularDeque.insertLast(1)).isTrue();
        assertThat(myCircularDeque.insertLast(2)).isTrue();
        assertThat(myCircularDeque.insertFront(3)).isTrue();
        assertThat(myCircularDeque.insertFront(4)).isFalse();
        assertThat(myCircularDeque.getRear()).isEqualTo(2);
        assertThat(myCircularDeque.isFull()).isTrue();
        assertThat(myCircularDeque.deleteLast()).isTrue();
        assertThat(myCircularDeque.insertFront(4)).isTrue();
        assertThat(myCircularDeque.getFront()).isEqualTo(4);
    }

    class MyCircularDeque {

        final int maxSize;
        List<Integer> list = new ArrayList<>();

        public MyCircularDeque(int k) {
            this.maxSize = k;
        }

        public boolean insertFront(int value) {
            if (list.size() == maxSize)
                return false;
            list.add(0, value);
            return true;
        }

        public boolean insertLast(int value) {
            int size = list.size();
            if (size == maxSize)
                return false;
            list.add(size, value);
            return true;
        }

        public boolean deleteFront() {
            if (list.isEmpty())
                return false;
            list.remove(0);
            return true;
        }

        public boolean deleteLast() {
            if (list.isEmpty())
                return false;
            list.remove(list.size() - 1);
            return true;
        }

        public int getFront() {
            if (list.isEmpty())
                return -1;
            return list.get(0);
        }

        public int getRear() {
            if (list.isEmpty())
                return -1;
            return list.get(list.size() - 1);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public boolean isFull() {
            return list.size() == maxSize;
        }
    }

}
