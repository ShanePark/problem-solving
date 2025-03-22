package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 26
 * ms
 * Beats
 * 15.41%
 */
public class Q2685CountTheNumberOfCompleteComponents {

    @Test
    public void test() {
        assertThat(countCompleteComponents(6, Ps.intArray("[[0,1],[0,2],[1,2],[3,4],[3,5]]"))).isEqualTo(1);
        assertThat(countCompleteComponents(6, Ps.intArray("[[0,1],[0,2],[1,2],[3,4]]"))).isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(countCompleteComponents(4, Ps.intArray("[[1,0],[2,0],[3,1],[3,2]]]"))).isEqualTo(0);
    }

    public int countCompleteComponents(int n, int[][] edges) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            nodes[i] = node;
        }
        for (int[] edge : edges) {
            Node node1 = nodes[edge[0]];
            Node node2 = nodes[edge[1]];
            node1.addConnection(node2);
        }
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (visited[i])
                continue;
            Node node = nodes[i];
            if (visitAllAndReturnIsCycle(node, visited)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean visitAllAndReturnIsCycle(Node node, boolean[] visited) {
        visited[node.index] = true;
        if (node.connections.isEmpty())
            return true;

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int groupSize = 1;
        Set<Integer> connectionSize = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                connectionSize.add(poll.connections.size());
                for (Node next : poll.connections) {
                    if (visited[next.index])
                        continue;
                    visited[next.index] = true;
                    q.offer(next);
                    groupSize++;
                }
            }
        }
        if (groupSize <= 2)
            return true;
        if (connectionSize.size() > 2)
            return false;
        return connectionSize.stream().findFirst().get() == groupSize - 1;
    }

    static class Node {
        final int index;
        Set<Node> connections = new HashSet<>();

        Node(int index) {
            this.index = index;
        }

        public void addConnection(Node node) {
            this.connections.add(node);
            node.connections.add(this);
        }
    }

}
