package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 181
 * ms
 * Beats
 * 68.48%
 */
public class Q3170LexicographicallyMinimumStringAfterRemovingStars {

    @Test
    public void test() {
        assertThat(clearStars("abc**")).isEqualTo("c");
        assertThat(clearStars("aaba*")).isEqualTo("aab");
        assertThat(clearStars("abc")).isEqualTo("abc");
    }

    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                pq.offer(new int[]{arr[i], i});
                continue;
            }
            int[] poll = pq.poll();
            arr[poll[1]] = '*';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c == '*')
                continue;
            sb.append(c);
        }
        return sb.toString();
    }

}
