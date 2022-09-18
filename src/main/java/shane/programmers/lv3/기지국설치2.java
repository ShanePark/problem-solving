package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class 기지국설치2 {

    @Test
    public void test() {
        assertThat(solution(16, new int[]{9}, 2)).isEqualTo(3);
        assertThat(solution(11, new int[]{4, 11}, 1)).isEqualTo(3);
    }

    /**
     * 3 sec 701 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[10000];
        for (int i = 1; i <= 10000; i++) {
            arr[i - 1] = i;
        }
        assertThat(solution(200000000, arr, 100000));
    }

    public int solution(int n, int[] stations, int w) {
        Stack<Integer> stack = new Stack<>();
        for (int i = stations.length - 1; i >= 0; i--) {
            stack.add(stations[i]);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && stack.peek() + w < i) {
                stack.pop();
            }
            if (stack.isEmpty() || i + w < stack.peek()) {
                stack.add(i + w);
                cnt++;
            }
        }
        return cnt;
    }
}
