package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 숫자_카드_나누기 {

    @Test
    public void test() {
        assertThat(solution(new int[]{100000000, 100000000, 100000000, 4, 5, 6, 7, 8, 9, 10, 11, 142, 315, 1139}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 181, 30, 102}));
        assertThat(solution(new int[]{10, 20}, new int[]{5, 17})).isEqualTo(10);
        assertThat(solution(new int[]{10, 17}, new int[]{5, 20})).isEqualTo(0);
        assertThat(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102})).isEqualTo(7);
    }

    @Test
    public void gcd() {
        assertThat(gcd(new int[]{10, 20})).isEqualTo(10);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);

        for (int i : arrayA) {
            if (i % gcdB == 0) {
                gcdB = 0;
                break;
            }
        }

        for (int i : arrayB) {
            if (i % gcdA == 0) {
                gcdA = 0;
                break;
            }
        }

        return Math.max(gcdA, gcdB);
    }

    private int gcd(int... arr) {
        int gcd = arr[0];
        for (int n : arr) {
            gcd = gcdBi(gcd, n);
        }
        return gcd;
    }

    private int gcdBi(int a, int b) {
        if (b == 0)
            return a;
        return gcdBi(b, a % b);
    }

}
