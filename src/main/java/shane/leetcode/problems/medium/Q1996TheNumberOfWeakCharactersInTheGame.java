package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1996TheNumberOfWeakCharactersInTheGame {

    @Test
    public void test() {
        assertThat(numberOfWeakCharacters(Ps.intArray("[[5,5],[6,3],[3,6]]"))).isEqualTo(0);
        assertThat(numberOfWeakCharacters(Ps.intArray("[[2,2],[3,3]]"))).isEqualTo(1);
        assertThat(numberOfWeakCharacters(Ps.intArray("[[1,5],[10,4],[4,3]]"))).isEqualTo(1);
    }

    public int numberOfWeakCharacters(int[][] properties) {
        int cnt = 0;
        for (int[] property : properties) {
            int attack = property[0];
            int defense = property[1];
            boolean weak = false;
            for (int[] other : properties) {
                if (attack < other[0] && defense < other[1]) {
                    weak = true;
                    break;
                }
            }
            if (weak)
                cnt++;
        }
        return cnt;
    }
}
