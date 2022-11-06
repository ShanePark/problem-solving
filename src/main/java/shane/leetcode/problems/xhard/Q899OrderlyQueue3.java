package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 100%
 * Memory 42.3 MB Beats 90.10%
 */
public class Q899OrderlyQueue3 {

    @Test
    public void testFailed() {
        assertThat(orderlyQueue("xxqjzq", 2)).isEqualTo("jqqxxz");
    }

    @Test
    public void test() {
        assertThat(orderlyQueue("xmvzi", 2)).isEqualTo("imvxz");
        assertThat(orderlyQueue("hmg", 2)).isEqualTo("ghm");
        assertThat(orderlyQueue("kuh", 1)).isEqualTo("hku");
        assertThat(orderlyQueue("ba", 2)).isEqualTo("ab");
        assertThat(orderlyQueue("v", 1)).isEqualTo("v");
        assertThat(orderlyQueue("baaca", 3)).isEqualTo("aaabc");
        assertThat(orderlyQueue("cba", 1)).isEqualTo("acb");
    }

    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        StringBuilder sb = new StringBuilder(s);
        String max = s;
        for (int i = 0; i < s.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            if (Comparator.<String>naturalOrder().compare(max, sb.toString()) > 0) {
                max = sb.toString();
            }
        }
        return max;
    }

}
