package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 79 ms Beats 20.21%
 * Memory 128.4 MB Beats 6.43%
 */
@SuppressWarnings("DuplicatedCode")
public class Q146LRUCache2 {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1)).isEqualTo(1);
        cache.put(3, 3);
        assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(4, 4);
        assertThat(cache.get(1)).isEqualTo(-1);
        assertThat(cache.get(3)).isEqualTo(3);
        assertThat(cache.get(4)).isEqualTo(4);
    }

    @Test
    public void test2() {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        assertThat(cache.get(1)).isEqualTo(-1);
        assertThat(cache.get(2)).isEqualTo(3);
    }

    class LRUCache {

        final int capacity;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer value = map.get(key);
            if (value == null)
                return -1;
            map.remove(key);
            map.put(key, value);
            return value;
        }

        public void put(int key, int value) {
            map.remove(key);

            map.put(key, value);
            if (map.size() > capacity) {
                Map.Entry<Integer, Integer> entry = map.entrySet().stream().findFirst().get();
                map.remove(entry.getKey());
            }
        }
    }

}
