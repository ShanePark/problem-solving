package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 8 ms Beats 98.72% of users with Java
 */
public class Q1971FindIfPathExistsInGraph2 {

    @Test
    public void test() {

        assertThat(validPath(10, Ps.intArray("[[0,7],[0,8],[6,1],[2,0],[0,4],[5,8],[4,7],[1,3],[3,5],[6,5]]"), 7, 5)).isTrue();
        assertThat(validPath(3, Ps.intArray("[[0,1],[1,2],[2,0]]"), 0, 2)).isTrue();
        assertThat(validPath(6, Ps.intArray("[[0,1],[0,2],[3,5],[5,4],[4,3]]"), 0, 5)).isFalse();
    }

    @Test
    public void test2() {
        assertThat(validPath(50, Ps.intArray("[[41,40],[9,32],[48,14],[6,44],[18,41],[41,1],[7,41],[38,41],[19,4],[16,41],[41,43],[41,22],[41,21],[9,0],[41,48],[32,36],[24,44],[39,41],[48,17],[49,15],[47,41],[19,31],[11,41],[41,23],[41,49],[45,44],[2,49],[13,41],[35,41],[30,0],[5,44],[8,0],[41,20],[41,28],[12,11],[12,41],[49,10],[19,0],[0,37],[34,41],[42,48],[27,41],[0,41],[19,44],[41,26],[41,29],[33,41],[49,46],[41,25],[3,41]]")
                , 40, 3)).isTrue();
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] union = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
        }
        for (int[] edge : edges) {
            union(union, edge[0], edge[1]);
        }
        return unionFind(union, source) == unionFind(union, destination);
    }

    private void union(int[] union, int i, int j) {
        int ufI = unionFind(union, i);
        int ufJ = unionFind(union, j);
        union[ufJ] = ufI;
    }

    private int unionFind(int[] union, int index) {
        int val = union[index];
        if (val == index)
            return index;
        int answer = unionFind(union, val);
        return union[index] = answer;
    }

}
