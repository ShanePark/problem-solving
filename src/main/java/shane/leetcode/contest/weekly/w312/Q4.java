package shane.leetcode.contest.weekly.w312;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q4 {

    @Test
    public void test() {
        assertThat(numberOfGoodPaths(new int[]{1, 3, 2, 1, 3}, STool.convertToIntArray("[[0,1],[0,2],[2,3],[2,4]]"))).isEqualTo(6);
        assertThat(numberOfGoodPaths(new int[]{1, 1, 2, 2, 3}, STool.convertToIntArray("[[0,1],[1,2],[2,3],[2,4]]"))).isEqualTo(7);
        assertThat(numberOfGoodPaths(new int[]{1}, STool.convertToIntArray("[]"))).isEqualTo(1);
    }

    @Test
    public void pathTest() {
        assertThat(new Path(1, 2)).isEqualTo(new Path(1, 2));
        assertThat(new Path(1, 2)).isEqualTo(new Path(2, 1));
        assertThat(new Path(1, 2)).isNotEqualTo(new Path(1, 3));
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            Node node = new Node(i, vals[i]);
            nodeMap.put(i, node);
        }

        for (int[] edge : edges) {
            Node n1 = nodeMap.get(edge[0]);
            Node n2 = nodeMap.get(edge[1]);
            n1.addConnection(n2);
        }

        Set<Path> goodPaths = new HashSet<>();

        for (Node node : nodeMap.values()) {
            dfs(node, node.index, node.val, new boolean[vals.length], goodPaths);
        }

        return vals.length + goodPaths.size();
    }

    private void dfs(Node node, int startIndex, int startValue, boolean[] visited, Set<Path> goodPaths) {
        visited[node.index] = true;

        for (Node next : node.connections) {
            if (visited[next.index]) {
                continue;
            }
            if (next.val == startValue) {
                goodPaths.add(new Path(startIndex, next.index));
            }
            if (next.val <= startValue) {
                dfs(next, startIndex, startValue, visited, goodPaths);
            }
        }

    }

    class Node {
        int index;
        int val;
        List<Node> connections = new ArrayList<>();

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }

        public void addConnection(Node node) {
            this.connections.add(node);
            node.connections.add(this);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    "connections=" + connections.stream().map(n -> n.index).collect(Collectors.toList()) +
                    '}';
        }
    }

    class Path {
        int start;
        int end;

        public Path(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;
            Path aCase = (Path) o;
            return (start == aCase.start && end == aCase.end) || (start == aCase.end && end == aCase.start);
        }

        @Override
        public int hashCode() {
            return Objects.hash((start + end) * start * end);
        }

        @Override
        public String toString() {
            return "Path{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}
