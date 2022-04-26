package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q705DesignHashSet {

    @Test
    public void test() {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        assertThat(set.contains(1)).isTrue();
        assertThat(set.contains(3)).isFalse();
        set.add(2);
        assertThat(set.contains(2)).isTrue();
        set.remove(2);
        assertThat(set.contains(2)).isFalse();

    }

    class MyHashSet {
        boolean[] arr = new boolean[1000001];

        public MyHashSet() {

        }

        public void add(int key) {
            arr[key] = true;
        }

        public void remove(int key) {
            arr[key] = false;
        }

        public boolean contains(int key) {
            return arr[key];
        }
    }
}
