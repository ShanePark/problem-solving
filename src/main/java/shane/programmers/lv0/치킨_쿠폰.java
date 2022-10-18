package shane.programmers.lv0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 치킨_쿠폰 {

    @Test
    public void test() {
        assertThat(solution(100)).isEqualTo(11);
        assertThat(solution(1081)).isEqualTo(120);
    }

    public int solution(int chicken) {
        int sum = 0;
        while (chicken >= 10) {
            int mod = chicken % 10;
            chicken /= 10;
            sum += chicken;
            chicken += mod;
        }
        return sum;
    }
}
