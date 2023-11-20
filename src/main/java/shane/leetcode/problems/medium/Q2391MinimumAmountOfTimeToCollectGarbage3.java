package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime Details 24ms Beats 63.07%of users with Java
 * Memory Details 66.18MB Beats 27.08%of users with Java
 */
public class Q2391MinimumAmountOfTimeToCollectGarbage3 {

    @Test
    public void test() {
        assertThat(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3})).isEqualTo(21);
        assertThat(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10})).isEqualTo(37);
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int travelG = 0;
        int travelM = 0;
        int travelP = 0;
        int currentTravel = 0;
        int cnt = 0;
        for (int i = 0; i < garbage.length; i++) {
            cnt += garbage[i].length();
            for (char c : garbage[i].toCharArray()) {
                switch (c) {
                    case 'G':
                        travelG = currentTravel;
                        break;
                    case 'P':
                        travelP = currentTravel;
                        break;
                    case 'M':
                        travelM = currentTravel;
                }
            }
            if (i < garbage.length - 1) {
                currentTravel += travel[i];
            }
        }
        return cnt + travelG + travelM + travelP;
    }

}
