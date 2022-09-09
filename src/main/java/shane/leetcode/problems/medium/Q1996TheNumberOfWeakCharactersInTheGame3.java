package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 145 ms, faster than 68.25% of Java online submissions for The Number of Weak Characters in the Game.
 * Memory Usage: 130.8 MB, less than 50.64% of Java online submissions for The Number of Weak Characters in the Game.
 */
@SuppressWarnings("ALL")
public class Q1996TheNumberOfWeakCharactersInTheGame3 {

    @Test
    public void test() {
        assertThat(numberOfWeakCharacters(STool.convertToIntArray("[[7,9],[10,7],[6,9],[10,4],[7,5],[7,10]]"))).isEqualTo(2);
        assertThat(numberOfWeakCharacters(STool.convertToIntArray("[[5,5],[6,3],[3,6]]"))).isEqualTo(0);
        assertThat(numberOfWeakCharacters(STool.convertToIntArray("[[2,2],[3,3]]"))).isEqualTo(1);
        assertThat(numberOfWeakCharacters(STool.convertToIntArray("[[1,5],[10,4],[4,3]]"))).isEqualTo(1);
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,
                (o1, o2) -> {
                    if (o1[0] == o2[0])
                        return Integer.compare(o1[1], o2[1]);
                    return Integer.compare(o2[0], o1[0]);
                }

        );
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < properties.length; i++) {
            if (max > properties[i][1]) {
                cnt++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return cnt;
    }

}
