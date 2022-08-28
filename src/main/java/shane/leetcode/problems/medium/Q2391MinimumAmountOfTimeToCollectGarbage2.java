package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime: 6 ms, faster than 100.00% of Java online submissions for Minimum Amount of Time to Collect Garbage.
 * Memory Usage: 92.1 MB, less than 33.33% of Java online submissions for Minimum Amount of Time to Collect Garbage.
 */
@SuppressWarnings("ALL")
public class Q2391MinimumAmountOfTimeToCollectGarbage2 {

    @Test
    public void test() {
        assertThat(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3})).isEqualTo(21);
        assertThat(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10})).isEqualTo(37);
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int[] lastIndex = new int[]{-1, -1, -1};

        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        boolean foundAll = false;
        final String MPG = "MPG";

        int answer = 0;
        for (int i = garbage.length - 1; i >= 0; i--) {
            String str = garbage[i];
            answer += str.length();
            if (!foundAll) {
                for (int j = 0; j < 3; j++) {
                    str.indexOf(MPG.charAt(j));
                    if (lastIndex[j] == -1 && str.indexOf(MPG.charAt(j)) != -1) {
                        lastIndex[j] = i;
                        foundAll = lastIndex[0] >= 0 && lastIndex[1] >= 0 && lastIndex[2] >= 0;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (lastIndex[i] > 0) {
                answer += travel[lastIndex[i] - 1];
            }
        }

        return answer;
    }

}
