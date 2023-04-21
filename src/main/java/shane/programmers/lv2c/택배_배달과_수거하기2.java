package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 택배_배달과_수거하기2 {

    @Test
    public void test() {
        assertThat(solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0})).isEqualTo(30);
        assertThat(solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0})).isEqualTo(16);
        assertThat(solution(1, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0})).isEqualTo(52);
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        Arrays.fill(arr, 50);
        assertThat(solution(1, 100000, arr, arr)).isEqualTo(500005000000L);
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverPossible = 0;
        int pickPossible = 0;
        for (int i = n - 1; i >= 0; i--) {
            int delivery = deliveries[i] - deliverPossible;
            int pickup = pickups[i] - pickPossible;
            int max = Math.max(delivery, pickup);
            if (max > 0) {
                int trip = ((max - 1) / cap) + 1;
                answer += 2 * (i + 1) * trip;
                deliverPossible = (trip * cap) - delivery;
                pickPossible = (trip * cap) - pickup;
            } else {
                deliverPossible = -delivery;
                pickPossible = -pickup;
            }
        }
        return answer;
    }

}
