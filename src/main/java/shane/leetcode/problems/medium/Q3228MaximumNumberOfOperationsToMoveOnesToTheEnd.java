package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 6ms
 * Beats100.00%
 */
public class Q3228MaximumNumberOfOperationsToMoveOnesToTheEnd {

    @Test
    public void test() {
        assertThat(maxOperations("1001101")).isEqualTo(4);
        assertThat(maxOperations("00111")).isEqualTo(0);
    }

    @Test
    public void test2() {
        assertThat(maxOperations("1010101")).isEqualTo(6);
    }

    public int maxOperations(String s) {
        int answer = 0;
        int oneCnt = 0;
        boolean passedZero = false;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                oneCnt++;
                passedZero = false;
                continue;
            }
            if (!passedZero) {
                passedZero = true;
                answer += oneCnt;
            }
        }
        return answer;
    }

}
