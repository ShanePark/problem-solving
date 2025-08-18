package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q679_24Game {

    @Test
    public void test() {
        assertThat(judgePoint24(new int[]{4, 1, 8, 7})).isTrue();
        assertThat(judgePoint24(new int[]{1, 2, 1, 2})).isFalse();
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24d) < 0.001d;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (double c : possibilities(list.get(i), list.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(c);
                    for (int k = 0; k < list.size(); k++) {
                        if (k == j || k == i)
                            continue;
                        nextRound.add(list.get(k));
                    }
                    if (dfs(nextRound)) return true;
                }
            }
        }
        return false;

    }

    private List<Double> possibilities(double a, double b) {
        return List.of(a + b, a - b, b - a, a * b, a / b, b / a);
    }

}
