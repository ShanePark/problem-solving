package shane.leetcode.contest.weekly.w285;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2211CountCollisionsOnARoad3 {

    @Test
    void test() {
        Assertions.assertThat(countCollisions("RLRSLL")).isEqualTo(5);
        Assertions.assertThat(countCollisions("LLRR")).isEqualTo(0);
        Assertions.assertThat(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR")).isEqualTo(20);

    }

    public int countCollisions(String directions) {
        boolean hasCarOnLeft = false;
        char before = 'S';
        int cnt = 0;
        int save = 0;
        for (int i = 0; i < directions.length(); i++) {
            char cur = directions.charAt(i);
            if (!hasCarOnLeft && cur != 'L')
                hasCarOnLeft = true;
            if (before == 'R') {
                if (cur == 'L') {
                    cnt += 2;
                    cnt += save;
                    save = 0;
                } else if (cur == 'S') {
                    cnt++;
                    cnt += save;
                    save = 0;
                } else if (cur == 'R') {
                    save++;
                }
            }else if(cur == 'L' && hasCarOnLeft) {
                cnt++;
            }
            before = cur;
        }
        return cnt;
    }

}
