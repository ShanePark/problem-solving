package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime Details 35ms Beats 9.92%of users with Java
 * Memory Details 45.41MB Beats 6.35%of users with Java
 */
public class Q2125NumberOfLaserBeamsInABank2 {

    @Test
    void test() {
        Assertions.assertThat(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"})).isEqualTo(8);
        Assertions.assertThat(numberOfBeams(new String[]{"000", "111", "000"})).isEqualTo(0);
    }

    public int numberOfBeams(String[] bank) {
        List<Integer> rows = new ArrayList<>();
        final int HEIGHT = bank.length;
        final int WIDTH = bank[0].length();
        for (int i = 0; i < HEIGHT; i++) {
            rows.add(0);
            for (int j = 0; j < WIDTH; j++) {
                if (bank[i].charAt(j) == '1') {
                    int curCount = rows.get(i);
                    rows.set(i, curCount + 1);
                }
            }
        }
        int curRow = 0;
        int cnt = 0;
        for (int i = 0; i < rows.size(); i++) {
            Integer rowSize = rows.get(i);
            if (rowSize == 0)
                continue;
            cnt += curRow * rowSize;
            curRow = rowSize;
        }
        return cnt;
    }

}
