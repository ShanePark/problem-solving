package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SheepAndWolf {

    @Test
    public void test() {
        assertThat(solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, Ps.intArray("[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]"))).isEqualTo(5);
        assertThat(solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0}, Ps.intArray("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]"))).isEqualTo(5);
    }

    int answer;

    public int solution(int[] info, int[][] edges) {
        answer = 0;
        Node[] nodes = new Node[info.length];
        for (int i = 0; i < info.length; i++) {
            nodes[i] = new Node(info[i]);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].children.add(nodes[edge[1]]);
        }

        dfs(nodes[0], 0, 0, new HashSet<>());
        return answer;
    }

    private void dfs(Node cur, int sheep, int wolf, Set<Node> visitableNodes) {
        sheep += cur.sheep;
        wolf += cur.wolf;
        if (sheep <= wolf) {
            return;
        }
        answer = Math.max(answer, sheep);

        Set<Node> copy = new HashSet<>(visitableNodes);
        copy.remove(cur);
        copy.addAll(cur.children);

        for (Node node : copy) {
            dfs(node, sheep, wolf, copy);
        }
    }

    static class Node {
        final int sheep;
        final int wolf;
        Set<Node> children = new HashSet<>();

        public Node(int isWolf) {
            this.sheep = 1 - isWolf;
            this.wolf = isWolf;
        }
    }

}
