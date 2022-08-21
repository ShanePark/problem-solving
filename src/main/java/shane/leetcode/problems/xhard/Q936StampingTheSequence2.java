package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 43 ms, faster than 24.11% of Java online submissions for Stamping The Sequence.
 * Memory Usage: 55.1 MB, less than 16.07% of Java online submissions for Stamping The Sequence.
 */
public class Q936StampingTheSequence2 {

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

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < STAMP_LENGTH; i++) {
            set.add(index + i);
        }
        List<Integer> list = new ArrayList<>();
        list.add(index);
        while (set.size() < TARGET_LENGTH) {
            boolean change = false;
            for (int i = 0; i <= TARGET_LENGTH - STAMP_LENGTH; i++) {
                if (check(set, i, target, stamp)) {
                    list.add(i);
                    for (int j = 0; j < STAMP_LENGTH; j++) {
                        set.add(i + j);
                    }
                    change = true;
                }
            }
            if (!change) {
                return new int[]{};
            }
        }
        int SIZE = list.size();
        int[] answer = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            answer[i] = list.get(SIZE - 1 - i);
        }
        return answer;
    }

    private boolean check(Set<Integer> set, int index, String target, String stamp) {
        int cnt = 0;
        for (int i = 0; i < stamp.length(); i++) {
            boolean contains = set.contains(index + i);
            if (contains) {
                cnt++;
            }
            if (!contains && target.charAt(index + i) != stamp.charAt(i)) {
                return false;
            }
        }
        return cnt != stamp.length();
    }
}
