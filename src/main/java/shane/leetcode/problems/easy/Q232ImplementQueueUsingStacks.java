package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.2 MB Beats 83.10%
 */
public class Q232ImplementQueueUsingStacks {

    @Test
    public void test() {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        assertThat(q.peek()).isEqualTo(1);
        assertThat(q.pop()).isEqualTo(1);
        assertThat(q.pop()).isEqualTo(2);
    }

    @Test
    public void test2() {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        assertThat(q.pop()).isEqualTo(1);
        q.push(5);
        assertThat(q.pop()).isEqualTo(2);
        assertThat(q.pop()).isEqualTo(3);
        assertThat(q.pop()).isEqualTo(4);
    }

    class MyQueue {

        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        public MyQueue() {

        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            int pop = pop();
            stack2.push(pop);
            return pop;
        }

        public boolean empty() {
            return stack1.empty() && stack2.empty();
        }
    }

}
