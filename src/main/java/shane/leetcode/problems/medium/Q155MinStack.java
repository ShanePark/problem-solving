package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q155MinStack {

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin()).isEqualTo(-3);
        minStack.pop();
        minStack.top();
        assertThat(minStack.getMin()).isEqualTo(-2);
    }

    @Test
    public void test2() {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(-1024);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(-1024);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(512);
    }

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> mins;

        public MinStack() {
            stack = new Stack<>();
            mins = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (mins.isEmpty() || mins.peek() >= val) {
                mins.push(val);
            }
        }

        public void pop() {
            Integer pop = stack.pop();
            if (pop.intValue() == mins.peek().intValue()) {
                mins.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }


}
