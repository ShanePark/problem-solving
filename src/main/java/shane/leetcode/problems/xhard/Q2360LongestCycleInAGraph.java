package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 372 ms Beats 11.97%
 * Memory 78.5 MB Beats 50.19%
 */
public class Q2360LongestCycleInAGraph {

    @Test
    void test() {
        assertThat(longestCycle(new int[]{3, 3, 4, 2, 3})).isEqualTo(3);
        assertThat(longestCycle(new int[]{2, -1, 3, 1})).isEqualTo(-1);
    }

    public int longestCycle(int[] edges) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(i, new Node(i));
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == -1)
                continue;
            map.get(i).next = map.get(edges[i]);
        }
        Set<Node> visited = new HashSet<>();
        int max = -1;
        for (int i = 0; i < edges.length; i++) {
            Node node = map.get(i);
            max = Math.max(max, node.getMaxCycle(visited));
        }
        return max;
    }

    class Node {
        int index;
        Node next;

        public Node(int i) {
            this.index = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return index == node.index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }

        public int getMaxCycle(Set<Node> visited) {
            Node cur = this;
            Map<Node, Integer> distances = new HashMap();
            int distance = 0;
            while (cur != null && !distances.containsKey(cur)) {
                distances.put(cur, distance++);
                if (!visited.add(cur)) {
                    return -1;
                }
                cur = cur.next;
            }
            if (cur == null)
                return -1;
            return distance - distances.get(cur);
        }
    }

}
