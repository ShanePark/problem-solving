package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3508ImplementRouter {

    @Test
    public void test() {
        Router router = new Router(3);
        assertThat(router.addPacket(1, 4, 90)).isTrue();
        assertThat(router.addPacket(2, 5, 90)).isTrue();
        assertThat(router.addPacket(1, 4, 90)).isFalse();
        assertThat(router.addPacket(3, 5, 95)).isTrue();
        assertThat(router.addPacket(4, 5, 105)).isTrue();
        assertThat(router.forwardPacket()).isEqualTo(new int[]{2, 5, 90});
        assertThat(router.addPacket(5, 2, 110)).isTrue();
        assertThat(router.getCount(5, 100, 110)).isEqualTo(1);
    }

    @Test
    public void test2() {
        Router router = new Router(2);
        assertThat(router.addPacket(7, 4, 90)).isTrue();
        assertThat(router.forwardPacket()).isEqualTo(new int[]{7, 4, 90});
        assertThat(router.forwardPacket()).isEmpty();
    }

    class Router {
        Queue<int[]> q = new LinkedList<>();
        Set<String> packetSet = new HashSet<>();
        Map<Integer, TreeMap<Integer, Integer>> packetMap = new HashMap<>();
        private final int memoryLimit;

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            String key = source + " " + destination + " " + timestamp;
            if (!packetSet.add(key)) {
                return false;
            }

            q.offer(new int[]{source, destination, timestamp});
            packetMap.computeIfAbsent(destination, k -> new TreeMap<>())
                    .merge(timestamp, 1, Integer::sum);

            if (q.size() > memoryLimit) {
                int[] poll = q.poll();
                removePacket(poll);
            }
            return true;
        }

        private void removePacket(int[] poll) {
            String key = poll[0] + " " + poll[1] + " " + poll[2];
            packetSet.remove(key);

            TreeMap<Integer, Integer> tree = packetMap.get(poll[1]);
            Integer cnt = tree.merge(poll[2], -1, Integer::sum);
            if (cnt == 0) {
                tree.remove(poll[2]);
            }
        }

        public int[] forwardPacket() {
            if (q.isEmpty())
                return new int[0];
            int[] poll = q.poll();
            removePacket(poll);
            return poll;
        }

        public int getCount(int destination, int startTime, int endTime) {
            TreeMap<Integer, Integer> tree = packetMap.get(destination);
            if (tree == null) return 0;

            return tree.subMap(startTime, true, endTime, true)
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }
    }

}
