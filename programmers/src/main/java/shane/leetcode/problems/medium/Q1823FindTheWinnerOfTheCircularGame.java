package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1823FindTheWinnerOfTheCircularGame {
    @Test
    public void test() {
        assertThat(findTheWinner(5, 2)).isEqualTo(3);
        assertThat(findTheWinner(6, 5)).isEqualTo(1);
    }

    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int i = k - 1;
        while (list.size() > 1) {
            list.remove(i);
            i = (i + k - 1) % list.size();
        }
        return list.get(0);
    }

}
