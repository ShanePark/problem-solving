package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q225ImplementStackUsingQueues {

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
        Queue<Integer> temp = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            q.offer(x);
        }

        public int pop() {
            temp = new LinkedList<>();
            while (q.size() > 1) {
                temp.offer(q.poll());
            }
            int result = q.poll();
            q = temp;
            return result;
        }

        public int top() {
            temp = new LinkedList<>();
            while (q.size() > 1) {
                temp.offer(q.poll());
            }
            int result = q.poll();
            temp.offer(result);
            q = temp;
            return result;
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
