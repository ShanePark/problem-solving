package shane.programmers.lv2c;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 우박수열_정적분 {

    @Test
    public void test() {
        assertThat(solution(5, Ps.intArray("[[0,0],[0,-1],[2,-3],[3,-3]]")))
                .containsExactly(33.0, 31.5, 0.0, -1.0);
    }

    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new ArrayList<>();
        while (k > 1) {
            list.add(k);
            k = (k % 2 == 0) ? (k / 2) : (k * 3 + 1);
        }
        list.add(1);

        int size = list.size();
        double[] dp = new double[size];
        for (int i = 1; i < size; i++) {
            dp[i] = dp[i - 1] + (list.get(i) + list.get(i - 1)) / 2.0;
        }

        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = size - 1 + ranges[i][1];
            if (end < start) {
                answer[i] = -1;
                continue;
            }
            answer[i] = dp[end] - dp[start];
        }
        return answer;
    }

}
