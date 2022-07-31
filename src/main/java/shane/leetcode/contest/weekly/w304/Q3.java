package shane.leetcode.contest.weekly.w304;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3 {

    @Test
    public void test() {
        assertThat(closestMeetingNode(new int[]{5, 4, 5, 4, 3, 6, -1}, 0, 1)).isEqualTo(-1);
        assertThat(closestMeetingNode(new int[]{2, 0, 0}, 2, 0)).isEqualTo(0);
        assertThat(closestMeetingNode(new int[]{4, 4, 4, 5, 1, 2, 2}, 1, 1)).isEqualTo(1);
        assertThat(closestMeetingNode(new int[]{4, 3, 0, 5, 3, -1}, 4, 0)).isEqualTo(4);
        assertThat(closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1)).isEqualTo(2);
        assertThat(closestMeetingNode(new int[]{1, 2, -1}, 0, 2)).isEqualTo(2);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2)
            return node1;
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

        Node n1 = map.get(node1);
        Node n2 = map.get(node2);

        Map<Node, Integer> n1DepthMap = new HashMap<>();
        Map<Node, Integer> n2DepthMap = new HashMap<>();
        n1DepthMap.put(n1, 0);
        n2DepthMap.put(n2, 0);
        int n1Depth = 0;
        int n2Depth = 0;

        while (n1.next != null || n2.next != null) {
            boolean n1Changed = false;
            boolean n2Changed = false;
            if (n1.next != null && !n1DepthMap.containsKey(n1.next)) {
                n1 = n1.next;
                n1DepthMap.put(n1, ++n1Depth);
                n1Changed = true;
            }
            if (n2.next != null && !n2DepthMap.containsKey(n2.next)) {
                n2 = n2.next;
                n2DepthMap.put(n2, ++n2Depth);
                n2Changed = true;
            }
            if (!n1Changed && !n2Changed) {
                return -1;
            }
            if (n1DepthMap.containsKey(n2) && n2DepthMap.containsKey(n1)) {
                return Math.min(n1.num, n2.num);
            }
            if (n1DepthMap.containsKey(n2)) {
                return n2.num;
            } else if (n2DepthMap.containsKey(n1)) {
                return n1.num;
            }
        }
        return -1;
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
