package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 32ms Beats 24.67%of users with Java
 * Memory Details 54.35MB Beats 19.02%of users with Java
 */
public class Q706DesignHashMap2 {

    @Test
    public void test() {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        assertThat(map.get(1)).isEqualTo(1);
        assertThat(map.get(3)).isEqualTo(-1);
        map.put(2, 1);
        assertThat(map.get(2)).isEqualTo(1);
        map.remove(2);
        assertThat(map.get(2)).isEqualTo(-1);
    }

    class MyHashMap {

        int[] table = new int[1000001];

        public MyHashMap() {
            Arrays.fill(table, -1);
        }

        public void put(int key, int value) {
            table[key] = value;
        }

        public int get(int key) {
            return table[key];
        }

        public void remove(int key) {
            table[key] = -1;
        }
    }

}
