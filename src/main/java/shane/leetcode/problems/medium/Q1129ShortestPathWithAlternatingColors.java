package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 8 ms Beats 40.14%
 * Memory 42.6 MB Beats 95.46%
 */
public class Q1129ShortestPathWithAlternatingColors {

    @Test
    void test() {
        assertThat(shortestAlternatingPaths(5, STool.convertToIntArray("[[0,1],[1,2],[2,3],[3,4]]"), STool.convertToIntArray("[[1,2],[2,3],[3,1]]")))
                .isEqualTo(new int[]{0, 1, 2, 3, 7});
        assertThat(shortestAlternatingPaths(3, new int[][]{{0, 1}}, new int[][]{{2, 1}})).isEqualTo(new int[]{0, 1, -1});
        assertThat(shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{})).isEqualTo(new int[]{0, 1, -1});
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node(i));
        }
        for (int[] redEdge : redEdges) {
            Node node1 = nodes.get(redEdge[0]);
            Node node2 = nodes.get(redEdge[1]);
            node1.addRed(node2);
        }
        for (int[] blueEdge : blueEdges) {
            Node node1 = nodes.get(blueEdge[0]);
            Node node2 = nodes.get(blueEdge[1]);
            node1.addBlue(node2);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;

        Queue<Condition> q = new LinkedList<>();
        q.offer(new Condition(nodes.get(0), Color.BLUE));
        q.offer(new Condition(nodes.get(0), Color.RED));
        Set<String> visited = new HashSet<>();
        visited.add("0" + Color.BLUE);
        visited.add("0" + Color.RED);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Condition poll = q.poll();
                Set<Node> next = poll.getNext();
                for (Node node : next) {
                    int index = node.index;
                    if (visited.add(String.valueOf(index) + poll.color.opposite())) {
                        Condition nextCondition = poll.nextCondition(node);
                        q.offer(nextCondition);
                        if (answer[index] == -1)
                            answer[index] = nextCondition.distance;
                    }
                }
            }
        }

        return answer;
    }

    class Node {
        int index;
        Set<Node> nextRed = new HashSet<>();
        Set<Node> nextBlue = new HashSet<>();

        public Node(int index) {
            this.index = index;
        }

        public void addRed(Node node) {
            this.nextRed.add(node);
        }

        public void addBlue(Node node) {
            this.nextBlue.add(node);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", nextRed=" + indexesOfNodes(nextRed) +
                    ", nextBlue=" + indexesOfNodes(nextBlue) +
                    '}';
        }

        private List<Integer> indexesOfNodes(Set<Node> nodes) {
            return nodes.stream().map(n -> n.index).collect(Collectors.toList());
        }
    }

    class Condition {
        Node node;
        Color color;
        int distance = 0;

        public Condition(Node node, Color color) {
            this.node = node;
            this.color = color;
        }

        public Set<Node> getNext() {
            return this.color == Color.BLUE ? node.nextRed : node.nextBlue;
        }

        public Condition nextCondition(Node node) {
            Condition condition = new Condition(node, this.color.opposite());
            condition.distance = this.distance + 1;
            return condition;
        }

        @Override
        public String toString() {
            return "Condition{" +
                    "node=" + node +
                    ", color=" + color +
                    ", distance=" + distance +
                    '}';
        }
    }

    enum Color {
        RED, BLUE;

        public Color opposite() {
            return this == RED ? BLUE : RED;
        }
    }

}
