package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 78 / 136 test cases passed.
 */
public class Q1531StringCompressionII {

    @Test
    public void test() {
//        assertThat(getLengthOfOptimalCompression("cbaabcabcacabacaccc", 5)).isEqualTo(10);
        assertThat(getLengthOfOptimalCompression("cacbbacadb", 7)).isEqualTo(2);
        assertThat(getLengthOfOptimalCompression("babbab", 5)).isEqualTo(1);
        assertThat(getLengthOfOptimalCompression("llllllllllttttttttt", 1)).isEqualTo(4);
        assertThat(getLengthOfOptimalCompression("abc", 0)).isEqualTo(3);
        assertThat(getLengthOfOptimalCompression("a", 1)).isEqualTo(0);
        assertThat(getLengthOfOptimalCompression("abc", 2)).isEqualTo(1);
        assertThat(getLengthOfOptimalCompression("aabbaa", 2)).isEqualTo(2);
        assertThat(getLengthOfOptimalCompression("aaabcccd", 2)).isEqualTo(4);
        assertThat(getLengthOfOptimalCompression("aaaaaaaaaaa", 0)).isEqualTo(3);
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        if (k >= s.length()) {
            return 0;
        }
        Map<Character, Integer> cMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            cMap.merge(c, 1, Integer::sum);
        }

        int max = cMap.values().stream().mapToInt(i -> i).max().getAsInt();
        int sum = cMap.values().stream().mapToInt(i -> i).sum();
        if (sum - max <= k) {
            return getStringLength(sum - k);
        }

        int snippet = 0;
        while (k > 0) {
            List<Alphabet> list = new ArrayList<>();
            char back = ' ';
            char before = ' ';
            int cnt = 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (before == c) {
                    cnt++;
                } else {
                    if (before != ' ') {
                        list.add(new Alphabet(i, before, cnt, i < s.length() - 1 && back == c));
                    }
                    back = before;
                    before = c;
                    cnt = 1;
                }
            }
            list.add(new Alphabet(s.length(), before, cnt, false));
            for (int i = 1; i < list.size() - 1; i++) {
                Alphabet previous = list.get(i - 1);
                Alphabet current = list.get(i);
                Alphabet next = list.get(i + 1);
                if (current.sameFrontAndBack) {
                    int originalLength = getStringLength(previous.cost) + getStringLength(next.cost);
                    int changedLength = getStringLength(previous.cost + next.cost);
                    current.plus += (originalLength - changedLength);
                }
            }

            Alphabet toDelete = null;
            for (Alphabet alphabet : list) {
                if (alphabet.cost <= k) {
                    if (toDelete != null) {
                        if (toDelete.plus - toDelete.cost < alphabet.plus - alphabet.cost) {
                            toDelete = alphabet;
                        } else if (toDelete.plus - toDelete.cost == alphabet.plus - alphabet.cost && toDelete.cost < alphabet.cost) {
                            toDelete = alphabet;
                        }
                    } else {
                        toDelete = alphabet;
                    }
                }
            }
            if (toDelete == null) {
                list.sort(Comparator.comparingInt(a -> a.cost % 10));
                for (Alphabet a : list) {
                    if (a.cost % 10 < k) {
                        k -= a.cost % 10;
                        snippet++;
                    } else if (a.cost == k + 1) {
                        k -= a.cost - 1;
                        snippet++;
                    } else {
                        break;
                    }
                }
                break;
            }
            k -= toDelete.cost;
            s = s.substring(0, toDelete.index) + s.substring(toDelete.index + toDelete.cost);
        }
        return transform(s).length() - snippet;
    }

    private StringBuilder transform(String s) {
        if (s.length() == 0)
            return new StringBuilder("");
        StringBuilder sb = new StringBuilder();
        char before = ' ';
        int cnt = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (before == c) {
                cnt++;
            } else {
                if (before != ' ') {
                    sb.append((cnt == 1 ? "" : String.valueOf(cnt)) + before);
                }
                before = c;
                cnt = 1;
            }
        }
        sb.append(((cnt == 1) ? "" : String.valueOf(cnt)) + s.charAt(s.length() - 1));
        return sb;
    }

    private int getStringLength(int length) {
        return length == 1 ? 1 : String.valueOf(length).length() + 1;
    }

    private class Alphabet {
        int index;
        char alphabet;
        boolean sameFrontAndBack;
        int cost;
        int plus;

        public Alphabet(int index, char alphabet, int length, boolean sameFrontAndBack) {
            this.index = index - length;
            this.alphabet = alphabet;
            this.cost = length;
            this.sameFrontAndBack = sameFrontAndBack;
            this.plus = getStringLength(cost);
        }

        @Override
        public String toString() {
            return "Alphabet{" +
                    "index=" + index +
                    ", alphabet=" + alphabet +
                    ", sameFrontAndBack=" + sameFrontAndBack +
                    ", cost=" + cost +
                    ", plus=" + plus +
                    '}';
        }
    }
}
