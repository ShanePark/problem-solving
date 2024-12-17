package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime66msBeats47.03%
 */
public class Q2182ConstructStringWithRepeatLimit {

    @Test
    public void test() {
        assertThat(repeatLimitedString("xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt", 1)).isEqualTo("zyxyxwxwvwvuvuvututstrtrtqpqpqponononmlmkmkjigifiededededcbaba");
        assertThat(repeatLimitedString("cczazcc", 3)).isEqualTo("zzcccac");
        assertThat(repeatLimitedString("aababab", 2)).isEqualTo("bbabaa");
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cntArr = new int[26];
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            cntArr[c - 'a']++;
            chars.add(c);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Character aChar : chars) {
            pq.offer(aChar);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character poll = pq.poll();
            int cnt = cntArr[poll - 'a'];
            if (cnt > repeatLimit) {
                appendChar(sb, poll, repeatLimit);
                if (pq.isEmpty())
                    return sb.toString();
                Character peek = pq.peek();
                sb.append(peek);
                int peekCnt = --cntArr[peek - 'a'];
                if (peekCnt == 0) {
                    pq.poll();
                }
                pq.offer(poll);
                cntArr[poll - 'a'] -= repeatLimit;
                continue;
            }
            appendChar(sb, poll, cnt);
            cntArr[poll - 'a'] -= cnt;
        }
        return sb.toString();
    }

    private static void appendChar(StringBuilder sb, Character c, int cnt) {
        for (int i = 0; i < cnt; i++) {
            sb.append(c);
        }
    }

}
