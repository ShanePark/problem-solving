package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q354RussianDollEnvelopes {

    @Test
    public void test() {
        assertThat(maxEnvelopes(Ps.intArray("[[1,30],[16,17],[17,18],[18,19],[19,20]]"))).isEqualTo(4);
        assertThat(maxEnvelopes(Ps.intArray("[[17,18],[20,4],[4,3],[14,6],[16,4],[8,11],[17,11],[18,7],[20,12]]"))).isEqualTo(4);
        assertThat(maxEnvelopes(Ps.intArray("[[1,1]"))).isEqualTo(1);
        assertThat(maxEnvelopes(Ps.intArray("[[46,89],[50,53],[52,68],[72,45],[77,81]]"))).isEqualTo(3);
        assertThat(maxEnvelopes(Ps.intArray(" [[30,50],[12,2],[3,4],[12,15]]"))).isEqualTo(3);
        assertThat(maxEnvelopes(Ps.intArray(" [[5,4],[6,4],[6,7],[2,3]]"))).isEqualTo(3);
        assertThat(maxEnvelopes(Ps.intArray(" [[1,1],[1,1],[1,1]]"))).isEqualTo(1);
        assertThat(maxEnvelopes(Ps.intArray("[[15,8],[2,20],[2,14],[4,17],[8,19],[8,9],[5,7],[11,19],[8,11],[13,11],[2,13],[11,19],[8,11],[13,11],[2,13],[11,19],[16,1],[18,13],[14,17],[18,19]]"))).isEqualTo(5);
    }

    public int maxEnvelopes(int[][] envelopes) {
        int max = 1;
        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0] + o[1]));
        int[] memo = new int[envelopes.length];
        for (int i = envelopes.length - 1; i >= 0; i--) {
            int[] cur = envelopes[i];
            int longest = 0;
            for (int j = i + 1; j < envelopes.length; j++) {
                int[] temp = envelopes[j];
                if (temp[0] > cur[0] && temp[1] > cur[1]) {
                    longest = Math.max(longest, memo[j]);
                }
            }
            memo[i] = longest + 1;
            max = Math.max(max, longest + 1);
        }

        return max;
    }
}
