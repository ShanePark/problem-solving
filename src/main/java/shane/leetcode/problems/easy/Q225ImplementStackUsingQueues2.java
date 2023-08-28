package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 40.69MB Beats 9.94%of users with Java
 */
public class Q225ImplementStackUsingQueues2 {

    @Test
    public void test() {
        MyStack myStack = new MyStack();
        Stack<Integer> stack = new Stack<>();
        myStack.push(1);
        stack.push(1);
        myStack.push(2);
        stack.push(2);
        assertThat(stack.peek()).isEqualTo(myStack.top());
        assertThat(stack.pop()).isEqualTo(myStack.pop());
        assertThat(stack.isEmpty()).isEqualTo(myStack.empty());
    }

    class MyStack {

        Queue<Integer> q = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            int size = q.size();
            q.offer(x);
            for (int i = 0; i < size; i++) {
                q.offer(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

}
