package shane.leetcode.contest.weekly.w285;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TLE
 */
public class Q2211CountCollisionsOnARoad2 {

    @Test
    void test() {
        Assertions.assertThat(countCollisions("RLRSLL")).isEqualTo(5);
        Assertions.assertThat(countCollisions("LLRR")).isEqualTo(0);
        Assertions.assertThat(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR")).isEqualTo(20);

    }

    public int countCollisions(String directions) {
        char[] chars = directions.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'S')
                continue;
            else if (chars[i] == 'R') {
                for (int j = i + 1; j < chars.length; j++) {
                    char opponent = chars[j];
                    if (opponent == 'L') {
                        chars[i] = 'S';
                        chars[j] = 'S';
                        cnt += 2;
                        break;
                    } else if (opponent == 'S') {
                        chars[i] = 'S';
                        chars[j] = 'S';
                        cnt++;
                        break;
                    }
                }
            } else if (chars[i] == 'L') {
                for (int j = i - 1; j >= 0; j--) {
                    char opponent = chars[j];
                    if (opponent == 'R') {
                        chars[i] = 'S';
                        chars[j] = 'S';
                        cnt += 2;
                        break;
                    } else if (opponent == 'S') {
                        chars[i] = 'S';
                        chars[j] = 'S';
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }

}
