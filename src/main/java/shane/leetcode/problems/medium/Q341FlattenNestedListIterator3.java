package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 2ms Beats 100.00%of users with Java
 * Memory Details 44.68MB Beats 30.39%of users with Java
 */
public class Q341FlattenNestedListIterator3 {

    @Test
    public void test() {
        List<NestedInteger> list = new ArrayList<>();
        NestedInteger one = NestedIntegerImpl.ofInteger(1);
        NestedInteger two = NestedIntegerImpl.ofInteger(2);
        list.add(NestedIntegerImpl.ofList(one, one));
        list.add(two);
        list.add(NestedIntegerImpl.ofList(one, one));
        NestedIterator nestedIterator = new NestedIterator(list);

        assertThat(nestedIterator.next()).isEqualTo(1);
        assertThat(nestedIterator.next()).isEqualTo(1);
        assertThat(nestedIterator.next()).isEqualTo(2);
        assertThat(nestedIterator.next()).isEqualTo(1);
        assertThat(nestedIterator.next()).isEqualTo(1);
        assertThat(nestedIterator.hasNext()).isFalse();
    }

    public class NestedIterator implements Iterator<Integer> {

        Queue<Integer> q = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                add(nestedInteger);
            }
        }

        private void add(NestedInteger nestedInteger) {
            if (nestedInteger.isInteger()) {
                q.offer(nestedInteger.getInteger());
                return;
            }
            for (NestedInteger i : nestedInteger.getList()) {
                add(i);
            }
        }

        @Override
        public Integer next() {
            if (q.isEmpty())
                return null;
            return q.poll();
        }

        @Override
        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    public static class NestedIntegerImpl implements NestedInteger {

        List<NestedInteger> list = new ArrayList();
        boolean isInteger = false;
        int value;

        public static NestedInteger ofList(NestedInteger... values) {
            NestedIntegerImpl nestedInteger = new NestedIntegerImpl();

            for (NestedInteger value : values) {
                nestedInteger.list.add(value);
            }
            return nestedInteger;
        }

        public static NestedInteger ofInteger(int value) {
            NestedIntegerImpl nestedInteger = new NestedIntegerImpl();
            nestedInteger.value = value;
            nestedInteger.isInteger = true;
            return nestedInteger;
        }

        @Override
        public boolean isInteger() {
            return isInteger;
        }

        @Override
        public Integer getInteger() {
            return value;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }

}
