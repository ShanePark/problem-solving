package shane.leetcode.contest.weekly.w289;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2246LongestPathWithDifferentAdjacentCharacters2 {

    @Test
    public void test() {
        assertThat(longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe")).isEqualTo(3);
        assertThat(longestPath(new int[]{-1, 0, 0, 0}, "aabc")).isEqualTo(3);
        assertThat(longestPath(new int[]{-1, 0, 1, 2, 3, 4}, "zzabab")).isEqualTo(5);
        assertThat(longestPath(new int[]{-1, 137, 65, 60, 73, 138, 81, 17, 45, 163, 145, 99, 29, 162, 19, 20, 132, 132, 13, 60, 21, 18, 155, 65, 13, 163, 125, 102, 96, 60, 50, 101, 100, 86, 162, 42, 162, 94, 21, 56, 45, 56, 13, 23, 101, 76, 57, 89, 4, 161, 16, 139, 29, 60, 44, 127, 19, 68, 71, 55, 13, 36, 148, 129, 75, 41, 107, 91, 52, 42, 93, 85, 125, 89, 132, 13, 141, 21, 152, 21, 79, 160, 130, 103, 46, 65, 71, 33, 129, 0, 19, 148, 65, 125, 41, 38, 104, 115, 130, 164, 138, 108, 65, 31, 13, 60, 29, 116, 26, 58, 118, 10, 138, 14, 28, 91, 60, 47, 2, 149, 99, 28, 154, 71, 96, 60, 106, 79, 129, 83, 42, 102, 34, 41, 55, 31, 154, 26, 34, 127, 42, 133, 113, 125, 113, 13, 54, 132, 13, 56, 13, 42, 102, 135, 130, 75, 25, 80, 159, 39, 29, 41, 89, 85, 19}, "ajunvefrdrpgxltugqqrwisyfwwtldxjgaxsbbkhvuqeoigqssefoyngykgtthpzvsxgxrqedntvsjcpdnupvqtroxmbpsdwoswxfarnixkvcimzgvrevxnxtkkovwxcjmtgqrrsqyshxbfxptuvqrytctujnzzydhpal")).isEqualTo(17);
    }

    Map<Integer, Integer> childrenDp;

    public int longestPath(int[] parent, String s) {

        childrenDp = new HashMap<>();
        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < parent.length; i++) {
            Node node = new Node(i, s.charAt(i), parent[i]);
            map.put(i, node);
        }

        for (int i = 0; i < parent.length; i++) {
            Node node = map.get(i);
            if (node.parent >= 0) {
                map.get(node.parent).addChild(node);
            }
        }

        int max = 0;
        for (Node node : map.values()) {
            max = Math.max(max, maxDepth(node, new HashSet<>()));
        }
        return max;
    }

    private int maxDepth(Node node, Set<Integer> visited) {
        if (childrenDp.get(node.n) != null)
            return childrenDp.get(node.n);

        if (visited.contains(node.n)) {
            return 0;
        }

        visited.add(node.n);

        int maxDepth = 0;
        for (Node child : node.children) {
            if (node.c == child.c) continue;
            maxDepth = Math.max(maxDepth, maxDepth(child, visited));
            for (Node child2 : node.children) {
                if ( node.c == child2.c || child.c == child2.c) {
                    continue;
                }
                maxDepth = Math.max(maxDepth, maxDepth(child, visited) + maxDepth(child2, visited));
            }
        }
        visited.remove(node.n);
        childrenDp.put(node.n, maxDepth + 1);
        return maxDepth + 1;
    }

    class Node {
        int n;
        char c;
        int parent;

        public Node(int n, char c, int parent) {
            this.n = n;
            this.c = c;
            this.parent = parent;
        }

        List<Node> children = new ArrayList<>();

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
