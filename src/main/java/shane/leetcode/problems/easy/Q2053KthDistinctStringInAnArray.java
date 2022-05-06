package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2053KthDistinctStringInAnArray {
    @Test
    public void test() {
        assertThat(kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2)).isEqualTo("a");
        assertThat(kthDistinct(new String[]{"aaa", "aa", "a"}, 1)).isEqualTo("aaa");
        assertThat(kthDistinct(new String[]{"a", "b", "a"}, 3)).isEqualTo("");
        assertThat(kthDistinct(new String[]{"a", "b", "a"}, 1)).isEqualTo("b");
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
        }
        for (String s : arr) {
            if (map.get(s) == 1) {
                k--;
                if (k == 0)
                    return s;
            }
        }
        return "";
    }

}
