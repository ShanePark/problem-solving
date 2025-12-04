package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2211CountCollisionsOnARoad {

    @Test
    public void test() {
        assertThat(countCollisions("RLRSLL")).isEqualTo(5);
        assertThat(countCollisions("LLRR")).isEqualTo(0);
    }

    public int countCollisions(String directions) {
        int l = 0;
        int r = directions.length() - 1;

        while (l < directions.length() && directions.charAt(l) == 'L') {
            l++;
        }

        while (r >= l && directions.charAt(r) == 'R') {
            r--;
        }

        int answer = 0;
        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') {
                answer++;
            }
        }
        return answer;
    }

}
