package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class 징검다리건너기4 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3)).isEqualTo(3);
    }

    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 200_000_000;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canPass(stones, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canPass(int[] stones, int k, int people) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < people) {
                if (++count == k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }

}
