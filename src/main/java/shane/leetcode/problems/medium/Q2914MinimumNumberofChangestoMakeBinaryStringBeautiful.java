package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4ms Beats40.00%
 */
public class Q2914MinimumNumberofChangestoMakeBinaryStringBeautiful {

    @Test
    public void test() {
        assertThat(minChanges("111111111110010001")).isEqualTo(3);
        assertThat(minChanges("010010")).isEqualTo(2);
        assertThat(minChanges("11000111")).isEqualTo(1);
        assertThat(minChanges("1001")).isEqualTo(2);
        assertThat(minChanges("10")).isEqualTo(1);
        assertThat(minChanges("0000")).isEqualTo(0);
    }

    public int minChanges(String s) {
        int[] oneCount = new int[s.length()];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
            oneCount[i] = sum;
        }
        return minChanges(oneCount, 0, s.length() - 1);
    }

    private int minChanges(int[] oneCountMemo, int from, int end) {
        int length = end - from + 1;
        int oneCount = oneCountMemo[end] - (from == 0 ? 0 : oneCountMemo[from - 1]);
        if (length == 2)
            return Math.min(oneCount, length - oneCount);
        int answer = Integer.MAX_VALUE;

        // cut in half
        if ((length / 2) % 2 == 0) {
            int mid = from + (end - from) / 2;
            answer = Math.min(answer, minChanges(oneCountMemo, from, mid) + minChanges(oneCountMemo, mid + 1, end));
        }

        // cut in n times
        int n = length / 2;
        answer = Math.min(answer, cutInNTimes(oneCountMemo, from, end, n));
        return answer;
    }

    private int cutInNTimes(int[] oneCountMemo, int from, int end, int n) {
        int length = end - from + 1;
        int newLength = length / n;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += minChanges(oneCountMemo, from, from + newLength - 1);
            from += newLength;
        }
        return answer;
    }

}
