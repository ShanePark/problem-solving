package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 20ms Beats96.14%
 */
public class Q3243ShortestDistanceAfterRoadAdditionQueriesI {

    @Test
    public void test() {
        assertThat(shortestDistanceAfterQueries(5, Ps.intArray("[[2,4],[0,2],[0,4]]"))).containsExactly(3, 2, 1);
        assertThat(shortestDistanceAfterQueries(4, Ps.intArray("[[0,3],[0,2]]"))).containsExactly(1, 1);
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] answer = new int[queries.length];
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, n - i - 1);
            if (i == 0)
                continue;
            nodes[i - 1].addNext(nodes[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            addQuery(nodes, query);
            answer[i] = nodes[0].distance;
        }
        return answer;
    }

    private void addQuery(Node[] nodes, int[] query) {
        Node from = nodes[query[0]];
        Node to = nodes[query[1]];

        if (to.distance + 1 < from.distance) {
            refreshDistance(from, to.distance + 1);
        }

        from.addNext(to);
    }

    private void refreshDistance(Node node, int distance) {
        node.distance = distance;
        for (Node before : node.before) {
            if (distance + 1 < before.distance) {
                refreshDistance(before, distance + 1);
            }
        }
    }

    static class Node {
        Set<Node> before = new HashSet<>();
        Set<Node> next = new HashSet<>();
        final int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public void addNext(Node node) {
            this.next.add(node);
            node.before.add(this);
        }
    }

}
