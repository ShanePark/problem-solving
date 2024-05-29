package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 20.13% of users with Java
 */
public class Q1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

    @Test
    public void test() {
        assertThat(numSteps("1111")).isEqualTo(5);
        assertThat(numSteps("1101")).isEqualTo(6);
        assertThat(numSteps("10")).isEqualTo(1);
        assertThat(numSteps("1")).isEqualTo(0);
    }

    public int numSteps(String s) {
        if (s.equals("1"))
            return 0;
        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c - '0');
        }
        for (int cnt = 1; ; cnt++) {
            int size = list.size();
            int last = list.get(size - 1);
            if (last == 1) {
                addOne(list);
                continue;
            }
            list.remove(size - 1);
            if (list.size() == 1)
                return cnt;
        }
    }

    private void addOne(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int n = list.get(i);
            if (n == 0) {
                list.set(i, 1);
                return;
            }
            list.set(i, 0);
        }
        list.add(0, 1);
    }

}
