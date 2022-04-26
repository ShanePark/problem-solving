package shane.leetcode.contest.biweekly72;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2177FindThreeConsecutiveIntegersThatSumtoaGivenNumber {

    @Test
    void test() {
        Assertions.assertThat(sumOfThree(33)).containsExactly(10, 11, 12);
        Assertions.assertThat(sumOfThree(4)).isEmpty();
    }

    public long[] sumOfThree(long num) {
        if (num % 3 > 0) {
            return new long[]{};
        }
        return new long[]{num / 3 - 1, num / 3, num / 3 + 1};
    }

}
