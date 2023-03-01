package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 42 ms Beats 67.91%
 * Memory 48.7 MB Beats 76.44%
 */
public class Q947MostStonesRemovedWithSameRowOrColumn {

    @Test
    public void test() {
        assertThat(removeStones(Ps.intArray("[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]"))).isEqualTo(5);
        assertThat(removeStones(Ps.intArray("[[0,0],[0,2],[1,1],[2,0],[2,2]]"))).isEqualTo(3);
        assertThat(removeStones(Ps.intArray("[[0,0]]"))).isEqualTo(0);
    }

    public int removeStones(int[][] stones) {
        final int length = stones.length;
        int[] unions = new int[length];
        for (int i = 0; i < length; i++) {
            unions[i] = i;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j, unions);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < length; i++) {
            if (unions[i] != i) {
                answer++;
            }
        }
        return answer;
    }

    private void union(int i, int j, int[] unions) {
        i = unionFind(i, unions);
        j = unionFind(j, unions);
        if (i != j) {
            unions[j] = i;
        }
    }

    private int unionFind(int i, int[] unions) {
        if (unions[i] == i)
            return i;
        return unionFind(unions[i], unions);
    }

}
