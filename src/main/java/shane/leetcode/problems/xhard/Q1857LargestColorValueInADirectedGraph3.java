package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 276 ms Beats 10%
 * Memory 175.6 MB Beats 5.45%
 */
public class Q1857LargestColorValueInADirectedGraph3 {

    @Test
    void test() {
        assertThat(largestPathValue("g", Ps.intArray("[]"))).isEqualTo(1);
        assertThat(largestPathValue("aaa", Ps.intArray("[[1,2],[2,1]]"))).isEqualTo(-1);
        assertThat(largestPathValue("rrrde", Ps.intArray("[[4,2],[3,4],[0,3],[1,0],[2,1]]"))).isEqualTo(-1);
        assertThat(largestPathValue("hhqhuqhqff", Ps.intArray("[[0,1],[0,2],[2,3],[3,4],[3,5],[5,6],[2,7],[6,7],[7,8],[3,8],[5,8],[8,9],[3,9],[6,9]]"))).isEqualTo(3);
        assertThat(largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}})).isEqualTo(3);
        assertThat(largestPathValue("a", new int[][]{{0, 0}})).isEqualTo(-1);
    }

    @Test
    void memoryLimitExceeded() {
        assertThat(largestPathValue("hwuyyyyuyhwwhuhwwwwhuyhuuhwwyuwyuhwhuwuyhuhhuyuuwuhw", Ps.intArray("[[0,1],[1,2],[2,3],[3,4],[4,5],[5,6],[3,6],[6,7],[7,8],[4,8],[8,9],[7,9],[7,10],[10,11],[8,12],[8,13],[11,13],[12,14],[13,14],[10,14],[8,15],[15,16],[12,16],[11,16],[16,17],[9,17],[13,17],[15,18],[17,18],[9,19],[13,19],[18,20],[19,20],[16,20],[15,21],[20,21],[17,21],[18,21],[18,22],[21,22],[21,23],[22,23],[21,24],[24,25],[20,25],[12,25],[14,26],[25,27],[25,28],[26,28],[28,29],[27,29],[23,29],[27,30],[29,30],[10,30],[28,31],[29,31],[27,31],[30,31],[23,32],[31,32],[20,33],[27,33],[33,34],[30,34],[32,34],[28,34],[31,35],[4,35],[25,35],[34,35],[31,36],[30,36],[34,36],[35,36],[26,36],[33,37],[37,38],[36,38],[34,38],[33,39],[36,39],[38,39],[38,40],[39,40],[37,40],[33,40],[36,40],[40,41],[39,41],[35,41],[25,41],[23,42],[27,42],[39,42],[18,43],[35,43],[42,44],[33,45],[34,46],[43,46],[45,46],[44,47],[46,47],[37,48],[40,48],[36,49],[47,49],[37,49],[46,49],[48,49],[48,50],[49,50],[48,51]]")))
                .isEqualTo(12);
    }

    @Test
    void tle() {
        assertThat(largestPathValue("qddqqqddqqdqddddddqdqqddddqdqdqqdddqddqdqqdqqqqqddqddqqddqqqdqqqqdqdddddqdq", Ps.intArray("[[0,1],[1,2],[2,3],[3,4],[3,5],[4,5],[3,6],[5,6],[6,7],[5,7],[3,7],[6,8],[5,8],[4,8],[8,9],[9,10],[10,11],[9,11],[9,12],[11,12],[6,12],[11,13],[9,13],[13,14],[12,14],[10,14],[11,14],[13,15],[14,15],[12,16],[9,16],[7,16],[15,17],[13,17],[17,18],[11,18],[17,19],[18,19],[13,19],[17,20],[18,20],[19,21],[17,21],[12,22],[21,22],[16,22],[22,23],[21,23],[16,24],[22,24],[15,25],[24,25],[20,25],[12,25],[23,26],[26,27],[13,27],[27,28],[21,28],[26,28],[28,29],[15,30],[27,30],[24,30],[21,30],[27,31],[30,31],[25,32],[29,32],[17,33],[31,33],[32,33],[25,34],[33,35],[31,35],[34,35],[30,36],[35,37],[36,37],[26,38],[36,38],[34,38],[37,38],[38,39],[22,39],[39,40],[40,41],[38,41],[20,41],[41,42],[37,42],[40,43],[42,43],[43,44],[41,44],[32,44],[38,44],[39,44],[43,45],[44,45],[44,46],[45,46],[45,47],[42,47],[43,48],[45,49],[45,50],[48,51],[30,51],[46,52],[48,52],[38,52],[51,52],[47,53],[45,53],[53,54],[48,54],[30,54],[50,55],[30,55],[36,55],[55,56],[39,56],[54,56],[50,57],[56,58],[32,58],[57,59],[49,59],[38,60],[60,61],[35,61],[54,61],[53,61],[54,62],[58,62],[62,63],[40,63],[58,63],[49,64],[63,64],[47,64],[39,64],[45,64],[62,65],[64,65],[54,65],[52,66],[61,66],[60,66],[55,67],[65,67],[45,68],[56,68],[36,68],[67,69],[66,69],[27,70],[60,70],[67,70],[48,71],[70,71],[53,71],[62,72],[72,73],[73,74]]")))
                .isEqualTo(26);
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
            if (from == to)
                return -1;
            from.addNext(to);
        }

        MaxRecoder[] dp = new MaxRecoder[length];

        for (int i = 0; i < length; i++) {
            Node node = nodes.get(i);
            Set<Node> visited = new HashSet<>();
            visited.add(node);
            int[] cur = new int[26];
            cur[node.color - 'a']++;
            try {
                dfs(node, cur, visited, dp);
            } catch (HasCycleException e) {
                return -1;
            }
        }

        int max = 0;
        for (MaxRecoder recoder : dp) {
            if (recoder == null)
                continue;
            max = Math.max(max, recoder.getMax());
        }
        return max;
    }

    private MaxRecoder dfs(Node node, int[] cur, Set<Node> visited, MaxRecoder[] dp) {
        if (dp[node.index] != null)
            return dp[node.index];

        MaxRecoder recoder = new MaxRecoder(node);
        dp[node.index] = recoder;
        for (Node next : node.next) {
            if (!visited.add(next)) {
                throw new HasCycleException();
            }
            cur[next.color - 'a']++;
            MaxRecoder nextRecord = dfs(next, cur, visited, dp);
            cur[next.color - 'a']--;
            visited.remove(next);
            recoder.update(node, nextRecord);
        }
        return recoder;
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


    class HasCycleException extends RuntimeException {

    }

    class MaxRecoder {
        int[] count = new int[26];

        public MaxRecoder(Node node) {
            count[node.color - 'a']++;
        }

        public void update(Node node, MaxRecoder nextRecord) {
            count[node.color - 'a']--;
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(nextRecord.count[i], count[i]);
            }
            count[node.color - 'a']++;
        }

        public int getMax() {
            int max = 0;
            for (int i = 0; i < 26; i++) {
                max = Math.max(max, count[i]);
            }
            return max;
        }
    }

}
