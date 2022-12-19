package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 기사단원의_무기 {

    @Test
    public void test() {
        assertThat(solution(10, 3, 2)).isEqualTo(21);
        assertThat(solution(5, 3, 2)).isEqualTo(10);
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int cnt = countDivisors(i);
            if (cnt > limit) {
                answer += power;
            } else {
                answer += cnt;
            }
        }
        return answer;
    }

    int countDivisors(int n) {
        int cnt = 0;
        for (int i = 1; i * i < n; i++) {
            if (n % i == 0)
                cnt++;
        }
        cnt *= 2;
        if (n == (int) Math.sqrt(n) * (int) Math.sqrt(n))
            cnt++;
        return cnt;
    }

}
