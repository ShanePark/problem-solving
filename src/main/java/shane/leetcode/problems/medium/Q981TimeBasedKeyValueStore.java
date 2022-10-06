package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 387 ms, faster than 37.75% of Java online submissions for Time Based Key-Value Store.
 * Memory Usage: 215.1 MB, less than 74.01% of Java online submissions for Time Based Key-Value Store.
 */
public class Q981TimeBasedKeyValueStore {

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

        Map<String, List<Pair>> map = new HashMap<>();

        public TimeMap() {
        }

        public void set(String key, String value, int timestamp) {
            List<Pair> list = map.getOrDefault(key, new ArrayList<>());
            list.add(new Pair(timestamp, value));
            map.put(key, list);
        }

        public String get(String key, int timestamp) {
            List<Pair> pairs = map.get(key);
            if (pairs == null)
                return "";
            int index = binarySearch(pairs, timestamp);
            if (index == -1)
                return "";
            return pairs.get(index).value;
        }

        private int binarySearch(List<Pair> pairs, int timestamp) {
            int left = 0;
            int right = pairs.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (pairs.get(mid).time == timestamp)
                    return mid;
                if (pairs.get(mid).time < timestamp) {
                    if (mid == pairs.size() - 1 || pairs.get(mid + 1).time > timestamp)
                        return mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }

        class Pair {
            int time;
            String value;

            public Pair(int time, String value) {
                this.time = time;
                this.value = value;
            }
        }
    }

}
