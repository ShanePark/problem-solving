package shane.leetcode.contest.weekly.w313;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * can't pass first
 */
public class Q4 {

    @Test
    public void test() {
//        assertThat(deleteString("ititititvt")).isEqualTo(4);
        assertThat(deleteString("jjjjo")).isEqualTo(4);
        assertThat(deleteString("aaaaa")).isEqualTo(5);
        assertThat(deleteString("aaabaab")).isEqualTo(4);
        assertThat(deleteString("abcabcdabc")).isEqualTo(2);
    }

    public int deleteString(String s) {
        int cnt = 1;
        for (int i = s.length() / 2; i > 0; i--) {
            String cut = s.substring(0, i);
            if (cut.length() > 1 && hasOnlyOneChar(cut)) {
                s = s.substring(1);
                cnt++;
                i = s.length() / 2 + 1;
            } else if (s.substring(i).startsWith(cut)) {
                s = s.substring(i);
                cnt++;
                i = s.length() / 2 + 1;
            }
        }
        return cnt;
    }

    private boolean hasOnlyOneChar(String cut) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < cut.length(); i++) {
            set.add(cut.charAt(i));
            if (set.size() > 1) {
                return false;
            }
        }
        return true;
    }

}
