package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 43 ms, faster than 33.33% of Java online submissions for Minimum Amount of Time to Collect Garbage.
 * Memory Usage: 100.8 MB, less than 33.33% of Java online submissions for Minimum Amount of Time to Collect Garbage.
 */
public class Q2391MinimumAmountOfTimeToCollectGarbage {

    @Test
    public void test() {
        assertThat(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3})).isEqualTo(21);
        assertThat(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10})).isEqualTo(37);
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int[] lastIndex = new int[3];
        Arrays.fill(lastIndex, -1);
        int answer = 0;
        for (int i = 0; i < garbage.length; i++) {
            String str = garbage[i];
            int length = str.length();
            answer += length;
            for (int j = 0; j < length; j++) {
                switch (str.charAt(j)) {
                    case 'M':
                        lastIndex[0] = i;
                        break;
                    case 'P':
                        lastIndex[1] = i;
                        break;
                    case 'G':
                        lastIndex[2] = i;
                        break;
                }
            }
        }

        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        for (int i = 0; i < 3; i++) {
            if (lastIndex[i] > 0) {
                answer += travel[lastIndex[i] - 1];
            }
        }

        return answer;
    }

}
