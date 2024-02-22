package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 7 ms Beats 29.84% of users with Java
 */
public class Q997FindTheTownJudge3 {

    @Test
    public void test() {
        assertThat(findJudge(2, Ps.intArray("[[1,2]]"))).isEqualTo(2);
        assertThat(findJudge(3, Ps.intArray("[[1,3],[2,3]]"))).isEqualTo(3);
        assertThat(findJudge(3, Ps.intArray("[[1,3],[2,3],[3,1]]"))).isEqualTo(-1);
    }

    public int findJudge(int n, int[][] trust) {
        Set<Integer> candidates = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }
        int[] trustedCount = new int[n + 1];
        for (int[] t : trust) {
            trustedCount[t[1]]++;
            candidates.remove(t[0]);
        }
        for (Integer c : candidates) {
            if (trustedCount[c] == n - 1)
                return c;
        }
        return -1;
    }

}
