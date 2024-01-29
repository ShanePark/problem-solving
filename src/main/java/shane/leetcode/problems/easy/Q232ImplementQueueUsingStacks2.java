package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q232ImplementQueueUsingStacks2 {

    @Test
    public void test() {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        assertThat(q.peek()).isEqualTo(1);
        assertThat(q.pop()).isEqualTo(1);
        assertThat(q.empty()).isFalse();
    }

    class MyQueue {

        Stack<Integer> store = new Stack<>();
        Stack<Integer> buffer = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            store.push(x);
        }

        public int pop() {
            if (buffer.isEmpty()) {
                emptyStore();
            }
            return buffer.pop();
        }

        public int peek() {
            if (buffer.isEmpty()) {
                emptyStore();
            }
            return buffer.peek();
        }

        public boolean empty() {
            return buffer.isEmpty() && store.isEmpty();
        }

        private void emptyStore() {
            while (!store.isEmpty()) {
                buffer.push(store.pop());
            }
        }
    }

}
