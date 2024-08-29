package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime32msBeats33.23%
 */
public class Q947MostStonesRemovedWithSameRowOrColumn2 {

    @Test
    public void test() {
        assertThat(removeStones(Ps.intArray("[[4,4],[5,5],[3,1],[1,4],[1,1],[2,3],[0,3],[2,4],[3,5]]"))).isEqualTo(8);
        assertThat(removeStones(Ps.intArray("[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]"))).isEqualTo(5);
        assertThat(removeStones(Ps.intArray("[[0,0],[0,2],[1,1],[2,0],[2,2]]"))).isEqualTo(3);
        assertThat(removeStones(Ps.intArray("[[0,0]]"))).isEqualTo(0);
    }

    public int removeStones(int[][] stones) {
        final int LENGTH = stones.length;
        int[] union = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            union[i] = i;
        }
        for (int i = 0; i < LENGTH; i++) {
            for (int j = i + 1; j < LENGTH; j++) {
                if (isUnion(stones[i], stones[j])) {
                    union(i, j, union);
                }
            }
        }
        int cnt = LENGTH;
        for (int i = 0; i < LENGTH; i++) {
            if (unionFind(union, i) == i)
                cnt--;
        }
        return cnt;
    }

    private void union(int i, int j, int[] union) {
        int iUnion = unionFind(union, i);
        int jUnion = unionFind(union, j);
        int min = Math.min(iUnion, jUnion);
        union[i] = min;
        union[j] = min;
        union[iUnion] = min;
        union[jUnion] = min;
    }

    private int unionFind(int[] union, int i) {
        if (union[i] == i)
            return i;
        return union[i] = unionFind(union, union[i]);
    }

    private boolean isUnion(int[] stone1, int[] stone2) {
        if (stone1[0] == stone2[0])
            return true;
        return stone1[1] == stone2[1];
    }

}
