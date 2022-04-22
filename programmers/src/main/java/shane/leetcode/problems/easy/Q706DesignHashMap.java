package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q706DesignHashMap {

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

        int[] table;

        public MyHashMap() {
            table = new int[(int) 1e6 + 1];
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
