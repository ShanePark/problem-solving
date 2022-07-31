package shane.leetcode.contest.weekly.w304;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q4_2 {

    @Test
    public void test() {
        assertThat(longestCycle(new int[]{3, 4, 0, 2, -1, 2})).isEqualTo(3);
        assertThat(longestCycle(new int[]{1, 2, 0, 4, 5, 6, 3, 8, 9, 7})).isEqualTo(4);
        assertThat(longestCycle(new int[]{3, 3, 4, 2, 3})).isEqualTo(3);
        assertThat(longestCycle(new int[]{2, -1, 3, 1})).isEqualTo(-1);
    }

    public int longestCycle(int[] edges) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            Node node = map.getOrDefault(i, new Node(i));
            map.putIfAbsent(i, node);

            int nextNum = edges[i];
            if (nextNum >= 0) {
                Node next = map.getOrDefault(nextNum, new Node(nextNum));
                node.next = next;
                map.putIfAbsent(nextNum, next);
            }
        }

        Set<Integer> counted = new HashSet<>();
        int max = -1;
        for (int i = 0; i < edges.length; i++) {
            if (counted.contains(i)) {
                continue;
            }
            int distance = 0;
            Node node = map.get(i);
            Map<Node, Integer> visited = new HashMap<>();
            visited.put(node, 0);
            while (node.next != null) {
                node = node.next;
                distance++;
                if (visited.containsKey(node)) {
                    max = Math.max(max, distance - visited.get(node));
                    break;
                }
                if (!counted.add(node.num)) {
                    break;
                }
                visited.put(node, distance);
            }

        }
        return max;
    }

    class Node {
        int num;
        Node next;

        public Node(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", next=" + (next == null ? -1 : next.num) +
                    '}';
        }
    }

}
