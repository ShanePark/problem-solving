package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q341FlattenNestedListIterator2 {

    @Test
    public void test() {
        List<NestedInteger> list = new ArrayList<>();
        NestedIterator nestedIterator = new NestedIterator(list);
        assertThat(nestedIterator.hasNext()).isFalse();
    }

    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            ListIterator<NestedInteger> listIterator = nestedList.listIterator(nestedList.size());
            while (listIterator.hasPrevious()) {
                stack.push(listIterator.previous());
            }
        }

        @Override
        public Integer next() {
            if (hasNext())
                return stack.pop().getInteger();
            return null;
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                List<NestedInteger> list = stack.pop().getList();
                ListIterator<NestedInteger> listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    stack.push(listIterator.previous());
                }
            }
            return !stack.isEmpty();
        }
    }

    /**
     * This is the interface that allows for creating nested lists.
     * You should not implement it, or speculate about its implementation
     */
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
