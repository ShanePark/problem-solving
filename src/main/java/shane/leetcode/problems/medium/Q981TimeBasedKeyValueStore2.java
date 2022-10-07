package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 168 ms, faster than 92.17% of Java online submissions for Time Based Key-Value Store.
 * Memory Usage: 117.8 MB, less than 86.80% of Java online submissions for Time Based Key-Value Store.
 */
public class Q981TimeBasedKeyValueStore2 {

    @Test
    public void test() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);

        assertThat(timeMap.get("foo", 1)).isEqualTo("bar");
        assertThat(timeMap.get("foo", 3)).isEqualTo("bar");
        timeMap.set("foo", "bar2", 4);
        assertThat(timeMap.get("foo", 4)).isEqualTo("bar2");
        assertThat(timeMap.get("foo", 5)).isEqualTo("bar2");
    }

    class TimeMap {

        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        public TimeMap() {
        }

        public void set(String key, String value, int timestamp) {
            map.compute(key, (k, v) -> {
                if (v == null)
                    v = new TreeMap<>();
                v.put(timestamp, value);
                return v;
            });
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> tree = map.get(key);
            Integer floor = tree == null ? null : tree.floorKey(timestamp);
            if (floor == null)
                return "";
            return tree.get(floor);
        }
    }

}
