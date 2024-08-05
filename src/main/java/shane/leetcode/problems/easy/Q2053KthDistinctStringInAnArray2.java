package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime6msBeats91.98%
 */
public class Q2053KthDistinctStringInAnArray2 {
    @Test
    public void test() {
        assertThat(kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2)).isEqualTo("a");
        assertThat(kthDistinct(new String[]{"aaa", "aa", "a"}, 1)).isEqualTo("aaa");
        assertThat(kthDistinct(new String[]{"a", "b", "a"}, 3)).isEqualTo("");
    }

    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> cnt = new LinkedHashMap<>();
        for (String s : arr) {
            cnt.merge(s, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> e : cnt.entrySet()) {
            if (e.getValue() == 1) {
                k--;
                if (k == 0) {
                    return e.getKey();
                }
            }
        }
        return "";
    }

}
