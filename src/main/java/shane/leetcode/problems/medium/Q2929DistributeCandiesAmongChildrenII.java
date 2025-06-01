package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2929DistributeCandiesAmongChildrenII {

    @Test
    public void test() {
        assertThat(distributeCandies(5, 2)).isEqualTo(3);
        assertThat(distributeCandies(3, 3)).isEqualTo(10);
    }

    @Test
    public void edge() {
        assertThat(distributeCandies(1000000, 1000000)).isEqualTo(-1);
    }

    public long distributeCandies(int n, int limit) {
        return distributeCandies(n, limit, 3);
    }

    private long distributeCandies(int n, int limit, int people) {
        if (n < 0 || people * limit < n)
            return 0;
        if (n == 0)
            return 1;
        long answer = 0;
        for (int i = 0; i <= limit; i++) {
            answer += distributeCandies(n - i, limit, people - 1);
        }
        return answer;
    }


}
