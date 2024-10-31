package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 유사칸토비트열 {

    @Test
    public void test() {
        assertThat(solution(2, 4, 17)).isEqualTo(8);
    }

    /**
     * 1
     * 11011
     * 11011 11011 00000 11011 11011
     * [] [11011 11011 00000 11011 11011] [00000 00000 00000 00000 00000] [] []
     * 110[11 11011 00000 11]011 11011
     */

    public int solution(int n, long l, long r) {
        int answer = 0;
        for (long i = l; i <= r; i++) {
            answer += find(n, i - 1);
        }
        return answer;
    }

    private int find(int n, long i) {
        if (n == 0)
            return 1;
        if (i % 5 == 2)
            return 0;
        return find(n - 1, i / 5);
    }

}
