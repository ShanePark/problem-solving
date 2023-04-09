package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MLE
 */
public class Q1857LargestColorValueInADirectedGraph {

    @Test
    void test() {
        assertThat(largestPathValue("hhqhuqhqff", Ps.intArray("[[0,1],[0,2],[2,3],[3,4],[3,5],[5,6],[2,7],[6,7],[7,8],[3,8],[5,8],[8,9],[3,9],[6,9]]"))).isEqualTo(3);
        assertThat(largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}})).isEqualTo(3);
        assertThat(largestPathValue("a", new int[][]{{0, 0}})).isEqualTo(-1);
    }

    @Test
    void memoryLimitExceeded() {
        assertThat(largestPathValue("hwuyyyyuyhwwhuhwwwwhuyhuuhwwyuwyuhwhuwuyhuhhuyuuwuhw", Ps.intArray("[[0,1],[1,2],[2,3],[3,4],[4,5],[5,6],[3,6],[6,7],[7,8],[4,8],[8,9],[7,9],[7,10],[10,11],[8,12],[8,13],[11,13],[12,14],[13,14],[10,14],[8,15],[15,16],[12,16],[11,16],[16,17],[9,17],[13,17],[15,18],[17,18],[9,19],[13,19],[18,20],[19,20],[16,20],[15,21],[20,21],[17,21],[18,21],[18,22],[21,22],[21,23],[22,23],[21,24],[24,25],[20,25],[12,25],[14,26],[25,27],[25,28],[26,28],[28,29],[27,29],[23,29],[27,30],[29,30],[10,30],[28,31],[29,31],[27,31],[30,31],[23,32],[31,32],[20,33],[27,33],[33,34],[30,34],[32,34],[28,34],[31,35],[4,35],[25,35],[34,35],[31,36],[30,36],[34,36],[35,36],[26,36],[33,37],[37,38],[36,38],[34,38],[33,39],[36,39],[38,39],[38,40],[39,40],[37,40],[33,40],[36,40],[40,41],[39,41],[35,41],[25,41],[23,42],[27,42],[39,42],[18,43],[35,43],[42,44],[33,45],[34,46],[43,46],[45,46],[44,47],[46,47],[37,48],[40,48],[36,49],[47,49],[37,49],[46,49],[48,49],[48,50],[49,50],[48,51]]")
        )).isEqualTo(12);
    }

    public int largestPathValue(String colors, int[][] edges) {
        int length = colors.length();
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < length; i++) {
            nodes.put(i, new Node(i, colors.charAt(i)));
        }
        for (int[] edge : edges) {
            Node from = nodes.get(edge[0]);
            Node to = nodes.get(edge[1]);
            from.addNext(to);
        }
        List<ColorResult>[] dp = new List[length];

        int max = 0;
        for (int i = 0; i < length; i++) {
            try {
                HashSet<Integer> visited = new HashSet<>();
                List<ColorResult> colorResults = getColorResult(nodes, i, dp, visited);
                for (ColorResult colorResult : colorResults) {
                    max = Math.max(max, colorResult.getMax());
                }
            } catch (HasCycleException e) {
                return -1;
            }
        }
        return max;
    }

    private List<ColorResult> getColorResult(Map<Integer, Node> nodes, int i, List<ColorResult>[] dp, HashSet<Integer> visited) {
        if (!visited.add(i)) {
            throw new HasCycleException();
        }
        if (dp[i] != null)
            return dp[i];
        Node node = nodes.get(i);

        Set<Node> nextNodes = node.next;

        if (nextNodes.isEmpty()) {
            ColorResult colorResult = new ColorResult(node);
            dp[i] = Collections.singletonList(colorResult);
            return dp[i];
        }

        List<ColorResult> cur = new ArrayList<>();
        for (Node next : nextNodes) {
            List<ColorResult> nextColorResult = getColorResult(nodes, next.index, dp, new HashSet(visited));
            for (ColorResult colorResult : nextColorResult) {
                cur.add(new ColorResult(node, colorResult));
            }
        }
        dp[i] = cur;
        return cur;
    }

    class Node {
        int index;
        char color;
        Set<Node> next = new HashSet<>();

        public Node(int index, char color) {
            this.index = index;
            this.color = color;
        }

        public void addNext(Node node) {
            next.add(node);
        }
    }

    class ColorResult {
        int[] counts = new int[26];
        Set<Integer> visited = new HashSet<>();

        public ColorResult(Node node, ColorResult nextColorResult) {
            this(node);
            if (nextColorResult.visited.contains(node.index))
                throw new HasCycleException();
            for (int i = 0; i < 26; i++) {
                this.counts[i] += nextColorResult.counts[i];
            }
        }

        public ColorResult(Node node) {
            counts[node.color - 'a']++;
            this.visited.add(node.index);
        }

        int getMax() {
            return Arrays.stream(counts).max().getAsInt();
        }
    }

    class HasCycleException extends RuntimeException {

    }

}
