package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my answer
 */
public class Q3508ImplementRouter2 {

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
        private final int memoryLimit;
        private final TreeSet<Packet> uniquePackets = new TreeSet<>();
        private final Queue<Packet> packetQueue = new LinkedList<>();
        private final Map<Integer, List<Integer>> destinationTimestamps = new HashMap<>();
        private final Map<Integer, Integer> processedPacketIndex = new HashMap<>();

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            Packet packet = new Packet(source, destination, timestamp);
            if (uniquePackets.contains(packet))
                return false;

            if (packetQueue.size() == memoryLimit)
                forwardPacket();

            packetQueue.add(packet);
            uniquePackets.add(packet);
            destinationTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
            return true;
        }

        public int[] forwardPacket() {
            if (packetQueue.isEmpty())
                return new int[0];

            Packet nextPacket = packetQueue.poll();
            uniquePackets.remove(nextPacket);
            processedPacketIndex.merge(nextPacket.destination, 1, Integer::sum);
            return new int[]{nextPacket.source, nextPacket.destination, nextPacket.timestamp};
        }

        public int getCount(int destination, int startTime, int endTime) {
            if (!destinationTimestamps.containsKey(destination))
                return 0;

            List<Integer> timestamps = destinationTimestamps.get(destination);
            final int startIndex = processedPacketIndex.getOrDefault(destination, 0);
            final int lowerBoundIndex = firstGreaterEqual(timestamps, startIndex, startTime);
            final int upperBoundIndex = firstGreater(timestamps, lowerBoundIndex, endTime);
            return upperBoundIndex - lowerBoundIndex;
        }

        private int firstGreaterEqual(List<Integer> timestamps, int startIndex, int startTime) {
            int l = startIndex;
            int r = timestamps.size();
            while (l < r) {
                final int m = (l + r) / 2;
                if (timestamps.get(m) >= startTime)
                    r = m;
                else
                    l = m + 1;
            }
            return l;
        }

        private int firstGreater(List<Integer> timestamps, int startIndex, int endTime) {
            int l = startIndex;
            int r = timestamps.size();
            while (l < r) {
                final int m = (l + r) / 2;
                if (timestamps.get(m) > endTime)
                    r = m;
                else
                    l = m + 1;
            }
            return l;
        }
    }

    class Packet implements Comparable<Packet> {
        public int source;
        public int destination;
        public int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Packet other) {
            if (source != other.source)
                return Integer.compare(source, other.source);
            if (destination != other.destination)
                return Integer.compare(destination, other.destination);
            return Integer.compare(timestamp, other.timestamp);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet packet = (Packet) o;
            return source == packet.source && destination == packet.destination &&
                    timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

}
