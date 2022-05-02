package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1742MaximumNumberOfBallsInABox {

    @Test
    public void test() {
        assertThat(countBalls(1, 10)).isEqualTo(2);
        assertThat(countBalls(5, 15)).isEqualTo(2);
    }

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int n = i;
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            map.merge(sum, 1, Integer::sum);
        }
        return map.values().stream().mapToInt(i -> i).max().getAsInt();
    }
}
