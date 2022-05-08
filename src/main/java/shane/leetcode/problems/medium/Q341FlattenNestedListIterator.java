package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q341FlattenNestedListIterator {

    @Test
    public void test() {
        List<NestedInteger> list = new ArrayList<>();
        NestedIterator nestedIterator = new NestedIterator(list);
        assertThat(nestedIterator.hasNext()).isFalse();
    }

    public class NestedIterator implements Iterator<Integer> {

        List<Integer> list;
        Iterator<Integer> it;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            traverse(nestedList);
            it = list.iterator();
        }

        private void traverse(List<NestedInteger> nestedList) {
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    this.list.add(ni.getInteger());
                } else {
                    traverse(ni.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
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
