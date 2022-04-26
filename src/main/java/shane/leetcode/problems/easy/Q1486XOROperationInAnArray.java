package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1486XOROperationInAnArray {

    @Test
    void test() {
        Assertions.assertThat(xorOperation(5, 0)).isEqualTo(8);
        Assertions.assertThat(xorOperation(4, 3)).isEqualTo(8);
    }

    public int xorOperation(int n, int start) {
        int answer = start;
        for (int i = 1; i < n; i++) {
            start += 2;
            answer ^= start;
        }
        return answer;
    }
}
