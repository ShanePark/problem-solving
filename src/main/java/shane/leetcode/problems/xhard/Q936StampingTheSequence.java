package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 19 ms, faster than 26.79% of Java online submissions for Stamping The Sequence.
 * Memory Usage: 44.7 MB, less than 52.68% of Java online submissions for Stamping The Sequence.
 */
public class Q936StampingTheSequence {

    @Test
    public void test() {
        String stamp = "abc";
        String target = "ababc";
        String str = "?????";
        int[] answer = movesToStamp(stamp, target);
        for (int i : answer) {
            str = stamp(str, stamp, i);
        }
        assertThat(str).isEqualTo(target);
    }

    private String stamp(String str, String stamp, int index) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < stamp.length(); i++) {
            sb.setCharAt(index + i, stamp.charAt(i));
        }
        return sb.toString();
    }

    @Test
    public void test2() {
        assertThat(movesToStamp("abca", "aabcaca")).containsExactly(3, 0, 1);
    }

    public int[] movesToStamp(String stamp, String target) {
        final int TARGET_LENGTH = target.length();
        final int STAMP_LENGTH = stamp.length();
        int index = target.indexOf(stamp);
        if (index < 0)
            return new int[]{};
        StringBuilder sb = new StringBuilder(target);
        for (int i = 0; i < STAMP_LENGTH; i++) {
            sb.setCharAt(index + i, '?');
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(index);
        int changeCnt = STAMP_LENGTH;
        while (changeCnt < TARGET_LENGTH) {
            boolean change = false;
            for (int i = 0; i <= TARGET_LENGTH - STAMP_LENGTH; i++) {
                if (check(sb, i, stamp)) {
                    answer.add(i);
                    for (int j = 0; j < STAMP_LENGTH; j++) {
                        if (sb.charAt(i + j) != '?') {
                            sb.setCharAt(i + j, '?');
                            changeCnt++;
                        }
                    }
                    change = true;
                }
            }
            if (!change) {
                return new int[]{};
            }
        }
        Collections.reverse(answer);
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    private boolean check(StringBuilder sb, int index, String stamp) {
        int cnt = 0;
        for (int i = 0; i < stamp.length(); i++) {
            char c = sb.charAt(index + i);
            if (c == '?') {
                cnt++;
            }
            if (c != '?' && c != stamp.charAt(i)) {
                return false;
            }
        }
        return cnt != stamp.length();
    }
}
