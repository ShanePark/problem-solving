package shane.leetcode.contest.biweekly.w73;

import com.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * FAIL
 */
public class Q2192AllAncestorsOfANodeInADirectedAcyclicGraph {

    @Test
    void test() {
        Assertions.assertThat(getAncestors(8, Ps.intArray("[[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]"))).containsExactly(
                Arrays.asList(), Arrays.asList(), Arrays.asList(), Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(0, 1, 3), Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(0, 1, 2, 3)
        );
        Assertions.assertThat(getAncestors(6, Ps.intArray("[[0,3],[5,0],[2,3],[4,3],[5,3],[1,3],[2,5],[0,1],[4,5],[4,2],[4,0],[2,1],[5,1]]"))).containsExactly(
                Arrays.asList(2, 4, 5), Arrays.asList(0, 2, 4, 5), Arrays.asList(4), Arrays.asList(0, 1, 2, 4, 5), Arrays.asList(), Arrays.asList(2, 4)
        );
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> parents = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parents.add(new ArrayList<>());
        }

        Map<Integer, Node> map = new HashMap<>();

        for (int[] edge : edges) {
            Node parent = map.get(edge[0]);
            if (parent == null) {
                parent = new Node(edge[0]);
                map.put(edge[0], parent);
            }
            Node child = map.get(edge[1]);
            if (child == null) {
                child = new Node(edge[1]);
                map.put(edge[1], child);
            }
            child.addParent(parent);
        }

        for (int i = 0; i < parents.size(); i++) {
            Node node = map.get(i);
            if (node == null)
                continue;
            for (Node parent : node.parents) {
                parents.get(i).add(parent.num);
            }
            Collections.sort(parents.get(i));
        }

        return parents;
    }

    class Node {
        int num;
        Set<Node> parents = new HashSet<>();

        public Node(int num) {
            this.num = num;
        }

        public void addParent(Node parent) {
            this.parents.add(parent);
            Set<Node> allParent = new HashSet<>();
            allParents(this.parents, allParent);
            parents.addAll(allParent);
        }


        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", parents=" + parents +
                    '}';
        }
    }

    private void allParents(Set<Node> parents, Set<Node> allParents) {
        for (Node parent : parents) {
            allParents.add(parent);
            allParents(parent.parents, allParents);
        }
    }


}
