package shane.leetcode.contest.weekly.w281;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TLE
 */
public class Q2182ConstructStringWithRepeatLimit {

    @Test
    void test() {
        Assertions.assertThat(repeatLimitedString("cczazcc", 3)).isEqualTo("zzcccac");
        Assertions.assertThat(repeatLimitedString("aababab", 2)).isEqualTo("bbabaa");
        Assertions.assertThat(repeatLimitedString("gapqzytcgvbqnyucmvhzusqrebydzqnlyqjlglssdhjgiecnritocbfexnvnmrgcoayorbmexhazxtwshari", 9)).isEqualTo("zzzzyyyyyxxxwvvvuutttssssrrrrrqqqqqpooonnnnnmmmllljjiiihhhhgggggfeeeeddcccccbbbbaaaa");
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        while (sb.length() < s.length()) {
            int right = arr.length - 1;
            while (!isRightOk(sb, repeatLimit, (char) ('a' + right)) || arr[right] == 0) {
                right--;
                if (right < 0)
                    return sb.toString();
            }
            arr[right]--;
            sb.append((char) ('a' + right));
        }

        return sb.toString();
    }

    private boolean isRightOk(StringBuffer sb, int repeatLimit, char c) {
        if (sb.length() < repeatLimit) {
            return true;
        }
        for (int i = 0; i < repeatLimit; i++) {
            if (sb.charAt(sb.length() - i - 1) != c) {
                return true;
            }
        }
        return false;
    }

}
