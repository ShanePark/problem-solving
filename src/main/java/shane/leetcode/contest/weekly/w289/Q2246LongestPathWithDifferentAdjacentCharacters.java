package shane.leetcode.contest.weekly.w289;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2246LongestPathWithDifferentAdjacentCharacters {

    @Test
    public void test() {
        assertThat(longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe")).isEqualTo(3);
        assertThat(longestPath(new int[]{-1, 0, 0, 0}, "aabc")).isEqualTo(3);
        assertThat(longestPath(new int[]{-1, 0, 1, 2, 3, 4}, "zzabab")).isEqualTo(5);
    }

    public int longestPath(int[] parent, String s) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            Node node = new Node(i, s.charAt(i), map.get(parent[i]));
            map.put(i, node);
            if (parent[i] >= 0) {
                map.get(parent[i]).addChild(node);
            }
        }

        int max = 0;
        for (Node node : map.values()) {
            max = Math.max(max, dfsLength(node, new HashSet<>()));
        }
        return max;
    }

    private int dfsLength(Node node, Set<Integer> visited) {
        if (visited.contains(node.n)) {
            return 0;
        }

        visited.add(node.n);

        int maxDepth = 0;
        for (Node child : node.children) {
            if (node.c != child.c)
                maxDepth = Math.max(maxDepth, dfsLength(child, visited));
        }
        if (node.parent != null && node.c != node.parent.c)
            maxDepth = Math.max(maxDepth, dfsLength(node.parent, visited));

        visited.remove(node.n);
        return maxDepth + 1;
    }

    class Node {
        int n;
        char c;

        public Node(int n, char c, Node parent) {
            this.n = n;
            this.c = c;
            this.parent = parent;
        }

        List<Node> children = new ArrayList<>();
        Node parent;

        public void addChild(Node node) {
            this.children.add(node);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "n=" + n +
                    ", c=" + c +
                    '}';
        }
    }


}
