package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 244 ms Beats 5.64%
 * Memory 137.6 MB Beats 32.91%
 */
public class Q460LFUCache {

    @Test
    public void test() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        assertThat(lfuCache.get(1)).isEqualTo(1);
        lfuCache.put(3, 3);
        assertThat(lfuCache.get(2)).isEqualTo(-1);
        assertThat(lfuCache.get(3)).isEqualTo(3);
        lfuCache.put(4, 4);
        assertThat(lfuCache.get(1)).isEqualTo(-1);
        assertThat(lfuCache.get(3)).isEqualTo(3);
        assertThat(lfuCache.get(4)).isEqualTo(4);
    }

    @Test
    public void test2() {
        LFUCache lfuCache = new LFUCache(10);
        String inputs = "\"put\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"put\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\",\"get\",\"put\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"get\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"get\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\",\"put\",\"get\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"put\",\"put\",\"put\"";
        String parameters = "10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26";
        String answerStr = "null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,14,null,null,18,null,null,11,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,11,null,null,null,null,29,null,null,null,null,17,-1,18,null,null,null,-1,null,null,null,20,null,null,null,29,18,18,null,null,null,null,20,null,null,null,null,null,null,null";
        List<String> methods = Arrays.stream(inputs.split(",")).map(s -> s.substring(1, s.length() - 1)).collect(Collectors.toList());
        List<String> params = Arrays.stream(parameters.split("],\\[")).collect(Collectors.toList());
        List<String> answers = Arrays.stream(answerStr.split(",")).collect(Collectors.toList());
        for (int i = 0; i < methods.size(); i++) {
            String param = params.get(i);
            String answer = answers.get(i);
            String method = methods.get(i);
            if (method.equals("get")) {
                int val = lfuCache.get(Integer.parseInt(param));
                assertThat(val).isEqualTo(Integer.parseInt(answer));
            } else { // put
                String[] split = param.split(",");
                int key = Integer.parseInt(split[0]);
                int val = Integer.parseInt(split[1]);
                lfuCache.put(key, val);
            }
        }
    }

    @Test
    public void capacityZero() {
        LFUCache lfuCache = new LFUCache(0);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        assertThat(lfuCache.get(1)).isEqualTo(-1);
        lfuCache.put(3, 3);
        assertThat(lfuCache.get(2)).isEqualTo(-1);
    }

    class LFUCache {
        PriorityQueue<Cache> pq = new PriorityQueue<>();
        int[] counter = new int[100001];
        final int capacity;
        Map<Integer, Cache> map = new HashMap<>();

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Cache cache = map.get(key);
            if (cache == null || capacity == 0) {
                return -1;
            }
            return cache.getValue(pq);
        }

        public void put(int key, int value) {
            counter[key]++;
            if (map.containsKey(key)) {
                Cache cache = map.get(key);
                cache.value = value;
                pq.remove(cache);
                pq.offer(cache);
            } else if (pq.size() == capacity && capacity > 0) {
                Cache cacheToDelete = pq.poll();
                map.remove(cacheToDelete.key);

                Cache cache = new Cache(key, value, counter);
                map.put(key, cache);
                pq.offer(cache);
            } else {
                Cache cache = new Cache(key, value, counter);
                map.put(key, cache);
                pq.offer(cache);
            }
        }


        class Cache implements Comparable {
            private int key;
            private int value;
            private int[] counter;
            private LocalDateTime lastUsed = LocalDateTime.now();

            public Cache(int key, int value, int[] counter) {
                this.key = key;
                this.value = value;
                this.counter = counter;
                counter[key] = 1;
            }

            public int getValue(PriorityQueue<Cache> pq) {
                counter[key]++;
                this.lastUsed = LocalDateTime.now();

                pq.remove(this);
                pq.offer(this);

                return this.value;
            }

            @Override
            public int compareTo(Object o) {
                Cache c = (Cache) o;
                if (counter[this.key] == counter[c.key]) {
                    return this.lastUsed.compareTo(c.lastUsed);
                }
                return Integer.compare(counter[this.key], counter[c.key]);
            }

            @Override
            public String toString() {
                return "Cache{" +
                        "key=" + key +
                        ", value=" + value +
                        ", counter=" + counter[this.key] +
                        ", lastUsed=" + lastUsed +
                        '}';
            }
        }

    }

}
