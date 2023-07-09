package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2272SubstringWithLargestVariance {

    @Test
    void test() {
        assertThat(largestVariance("aababbb")).isEqualTo(3);
        assertThat(largestVariance("aaaa")).isEqualTo(0);
    }

    public int largestVariance(String s) {
        int[] arr = new int[26];
        final int LENGTH = s.length();
        for (int i = 0; i < LENGTH; i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        int max = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || arr[i] == 0 || arr[j] == 0) {
                    continue;
                }

                int largeCnt = 0;
                int smallCnt = 0;
                int restMin = arr[j];

                for (int ii = 0; ii < LENGTH; ii++) {
                    int c = s.charAt(ii) - 'a';
                    if (c == i) {
                        largeCnt++;
                    }
                    if (c == j) {
                        smallCnt++;
                        restMin--;
                    }

                    if (smallCnt > 0)
                        max = Math.max(max, largeCnt - smallCnt);

                    if ((largeCnt < smallCnt) && (restMin > 0)) {
                        largeCnt = 0;
                        smallCnt = 0;
                    }
                }
            }
        }

        return max;
    }

}
