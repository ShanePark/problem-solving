package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12 ms Beats 82.1%
 * Memory 115.3 MB Beats 31.66%
 */
public class Q2492MinimumScoreOfAPathBetweenTwoCities {

    @Test
    public void test() {
        assertThat(minScore(4, Ps.intArray("[[1,4,5],[2,3,1]]"))).isEqualTo(5);
        assertThat(minScore(4, Ps.intArray("[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]"))).isEqualTo(5);
        assertThat(minScore(4, Ps.intArray("[[1,2,2],[1,3,4],[3,4,7]]"))).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(minScore(20, Ps.intArray("[[18,20,9207],[14,12,1024],[11,9,3056],[8,19,416],[3,18,5898],[17,3,6779],[13,15,3539],[15,11,1451],[19,2,3805],[9,8,2238],[1,16,618],[16,14,55],[17,7,6903],[12,13,1559],[2,17,3693]]")))
                .isEqualTo(55);
    }

    public int minScore(int n, int[][] roads) {
        UnionFinder uf = new UnionFinder(n + 1);
        for (int[] road : roads) {
            uf.union(Math.min(road[0], road[1]), Math.max(road[0], road[1]));
        }

        int min = Integer.MAX_VALUE;
        for (int[] road : roads) {
            if (uf.unionFind(road[0]) == 1) {
                min = Math.min(min, road[2]);
            }
        }
        return min;
    }

    class UnionFinder {

        final private int[] union;

        UnionFinder(int n) {
            union = new int[n];
            IntStream.range(0, n).forEach(i -> union[i] = i);
        }

        public void union(int i, int j) {
            int rootI = unionFind(i);
            int rootJ = unionFind(j);
            if (rootI == rootJ)
                return;
            int root = Math.min(rootI, rootJ);
            union[rootI] = root;
            union[rootJ] = root;
        }

        public int unionFind(int i) {
            int find = union[i];
            if (find == i)
                return i;
            int answer = unionFind(find);
            union[i] = answer;
            return answer;
        }

        public void printUnion() {
            System.out.println(Arrays.toString(union));
        }
    }

}
