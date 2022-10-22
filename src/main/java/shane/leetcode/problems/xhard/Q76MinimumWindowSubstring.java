package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 28 ms, faster than 47.42% of Java online submissions for Minimum Window Substring.
 * Memory Usage: 50.5 MB, less than 28.52% of Java online submissions for Minimum Window Substring.
 */
public class Q76MinimumWindowSubstring {

    @Test
    public void test() {
        assertThat(minWindow("bba", "ab")).isEqualTo("ba");
        assertThat(minWindow("ab", "b")).isEqualTo("b");
        assertThat(minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
        assertThat(minWindow("a", "a")).isEqualTo("a");
        assertThat(minWindow("a", "aa")).isEqualTo("");
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            cntMap.merge(c, 1, Integer::sum);
        }

        Queue<Element> q = new LinkedList<>();
        boolean prepared = false;

        int left = 0;
        int right = s.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cntMap.containsKey(c)) {
                Element e = new Element(i, c);
                cntMap.merge(c, -1, Integer::sum);
                q.add(e);
                if (q.peek().c == c) {
                    while (cntMap.get(q.peek().c) < 0) {
                        Element poll = q.poll();
                        cntMap.merge(poll.c, 1, Integer::sum);
                    }
                }
                if (!prepared) {
                    prepared = isPrepared(cntMap);
                }
                if (prepared && right - left > i - q.peek().index) {
                    left = q.peek().index;
                    right = i;
                }
            }
        }
        if (!prepared)
            return "";
        return s.substring(left, right + 1);
    }

    private boolean isPrepared(Map<Character, Integer> cntMap) {
        for (Integer value : cntMap.values()) {
            if (value > 0)
                return false;
        }
        return true;
    }

    class Element {
        int index;
        char c;

        public Element(int index, char c) {
            this.index = index;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "index=" + index +
                    ", c=" + c +
                    '}';
        }
    }

}
