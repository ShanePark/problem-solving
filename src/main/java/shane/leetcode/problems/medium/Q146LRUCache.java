package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q146LRUCache {

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
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer value = map.get(key);
            if (value == null)
                return -1;
            q.remove(key);
            q.offer(key);
            return value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                q.remove(key);
            }
            map.put(key, value);
            q.offer(key);
            if (q.size() > capacity) {
                Integer poll = q.poll();
                map.remove(poll);
            }
        }
    }

}
