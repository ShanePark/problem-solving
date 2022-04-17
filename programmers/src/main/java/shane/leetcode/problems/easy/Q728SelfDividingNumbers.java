package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q728SelfDividingNumbers {

    @Test
    public void test() {
        assertThat(selfDividingNumbers(1, 22)).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
        assertThat(selfDividingNumbers(47, 85)).containsExactly(48, 55, 66, 77);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (selfDividing(i))
                list.add(i);
        }
        return list;
    }

    private boolean selfDividing(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            if (n == 0 || num % n != 0)
                return false;
        }
        return true;
    }
}
