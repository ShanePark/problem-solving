package shane.leetcode.contest.weekly.w285;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TLE
 */
public class Q2211CountCollisionsOnARoad {

    @Test
    void test() {
        Assertions.assertThat(countCollisions("RLRSLL")).isEqualTo(5);
        Assertions.assertThat(countCollisions("LLRR")).isEqualTo(0);
        Assertions.assertThat(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR")).isEqualTo(20);

    }

    public int countCollisions(String directions) {
        char[] arr = directions.toCharArray();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                char c1 = arr[i];
                char c2 = arr[j];
                if (isAccident(c1, c2)) {
                    cnt++;
                    if (c1 != 'S' && c2 != 'S') {
                        cnt++;
                    }
                    arr[i] = 'S';
                    arr[j] = 'S';
                    break;
                }
            }
        }
        return cnt;
    }

    private boolean isAccident(char c1, char c2) {
        switch (c1) {
            case 'L':
                return false;
            case 'S':
                if (c2 == 'L')
                    return true;
                return false;
            default:
                if (c2 == 'R')
                    return false;
                return true;
        }
    }

}
