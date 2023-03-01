package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 157 ms, faster than 58.12% of Java online submissions for The Number of Weak Characters in the Game.
 * Memory Usage: 136 MB, less than 24.28% of Java online submissions for The Number of Weak Characters in the Game.
 */
public class Q1996TheNumberOfWeakCharactersInTheGame2 {

    @Test
    public void test() {
        assertThat(numberOfWeakCharacters(Ps.intArray("[[7,9],[10,7],[6,9],[10,4],[7,5],[7,10]]"))).isEqualTo(2);
        assertThat(numberOfWeakCharacters(Ps.intArray("[[5,5],[6,3],[3,6]]"))).isEqualTo(0);
        assertThat(numberOfWeakCharacters(Ps.intArray("[[2,2],[3,3]]"))).isEqualTo(1);
        assertThat(numberOfWeakCharacters(Ps.intArray("[[1,5],[10,4],[4,3]]"))).isEqualTo(1);
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,
                (o1, o2) -> {
                    if (o1[0] == o2[0])
                        return Integer.compare(o1[1], o2[1]);
                    return Integer.compare(o2[0], o1[0]);
                }

        );
        int LENGTH = properties.length;
        int[] maxDef = new int[LENGTH];
        for (int i = 1; i < LENGTH; i++) {
            maxDef[i] = Math.max(maxDef[i - 1], properties[i - 1][1]);
        }
        int cnt = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (maxDef[i] > properties[i][1]) {
                cnt++;
            } else {
                while (i < LENGTH - 1 && properties[i][0] == properties[i + 1][0]) {
                    i++;
                }
            }
        }
        return cnt;
    }
}
