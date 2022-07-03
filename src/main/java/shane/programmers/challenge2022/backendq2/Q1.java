package shane.programmers.challenge2022.backendq2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 1, 3})).isEqualTo(1);
        assertThat(solution(new int[]{5, 3, 1})).isEqualTo(6);
        assertThat(solution(new int[]{1, 2, 3})).isEqualTo(0);
        assertThat(solution(new int[]{3, 2, 3, 6, 4, 5})).isEqualTo(3);
    }

    public int solution(int[] grade) {
        int before = grade[grade.length - 1];
        int cnt = 0;
        for (int i = grade.length - 2; i >= 0; i--) {
            int n = grade[i];
            if (before < n)
                cnt += n - before;
            before = Math.min(before, n);
        }
        return cnt;
    }

}
