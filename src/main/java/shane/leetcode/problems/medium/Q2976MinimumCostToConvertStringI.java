package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime26msBeats56.42%
 */
public class Q2976MinimumCostToConvertStringI {

    @Test
    public void test() {
        assertThat(minimumCost("abcd", "acbe",
                new char[]{'a', 'b', 'c', 'c', 'e', 'd'},
                new char[]{'b', 'c', 'b', 'e', 'b', 'e'}, new int[]{2, 5, 5, 1, 2, 20}
        )).isEqualTo(28);

        assertThat(minimumCost("aaaa", "bbbb",
                new char[]{'a', 'c'},
                new char[]{'c', 'b'}, new int[]{1, 2}
        )).isEqualTo(12);

        assertThat(minimumCost("abcd", "abce",
                new char[]{'a'},
                new char[]{'e'}, new int[]{10000}
        )).isEqualTo(-1);
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        MyChar[] chars = new MyChar[26];
        for (int i = 0; i < 26; i++) {
            chars[i] = new MyChar(i);
        }
        for (int i = 0; i < original.length; i++) {
            char from = original[i];
            char to = changed[i];
            if (chars[from - 'a'].next[to - 'a'] == null) {
                chars[from - 'a'].next[to - 'a'] = Integer.MAX_VALUE;
            }
            chars[from - 'a'].next[to - 'a'] = Math.min(chars[from - 'a'].next[to - 'a'], cost[i]);
        }

        // optimize
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (chars[j].next[i] != null && chars[i].next[k] != null) {
                        if (chars[j].next[k] == null) {
                            chars[j].next[k] = Integer.MAX_VALUE;
                        }
                        chars[j].next[k] = Math.min(chars[j].next[k], chars[j].next[i] + chars[i].next[k]);
                    }
                }
            }
        }

        return calculate(source, target, chars);
    }

    static class MyChar {
        final char c;
        final Integer[] next = new Integer[26];

        MyChar(int i) {
            this.c = (char) ('a' + i);
            next[c - 'a'] = 0;
        }
    }

    private static long calculate(String source, String target, MyChar[] chars) {
        long answer = 0;
        for (int i = 0; i < source.length(); i++) {
            char from = source.charAt(i);
            char to = target.charAt(i);
            Integer price = chars[from - 'a'].next[to - 'a'];
            if (price == null)
                return -1;
            answer += price;
        }
        return answer;
    }

}
