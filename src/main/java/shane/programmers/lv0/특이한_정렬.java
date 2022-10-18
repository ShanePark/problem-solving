package shane.programmers.lv0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 특이한_정렬 {

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 2, 3, 4, 5, 6}, 4)).containsExactly(4, 5, 3, 6, 2, 1);
        assertThat(solution(new int[]{10000, 20, 36, 47, 40, 6, 10, 7000}, 30)).containsExactly(36, 40, 20, 47, 10, 6, 7000, 10000);
    }

    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist)
                .boxed()
                .sorted((a, b) -> {
                    if (Math.abs(n - a) == Math.abs(n - b))
                        return Integer.compare(b, a);
                    return Integer.compare(Math.abs(n - a), Math.abs(n - b));
                }).mapToInt(Integer::valueOf)
                .toArray();
    }

}
