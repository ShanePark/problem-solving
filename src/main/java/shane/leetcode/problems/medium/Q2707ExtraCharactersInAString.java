package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 32ms Beats 86.00%of users with Java
 * Memory Details 44.42MB Beats 26.00%of users with Java
 */
public class Q2707ExtraCharactersInAString {

    @Test
    public void test() {
        assertThat(minExtraChar("ecolloycollotkvzqpdaumuqgs", new String[]{"flbri", "uaaz", "numy", "laper", "ioqyt", "tkvz", "ndjb", "gmg", "gdpbo", "x", "collo", "vuh", "qhozp", "iwk", "paqgn", "m", "mhx", "jgren", "qqshd", "qr", "qpdau", "oeeuq", "c", "qkot", "uxqvx", "lhgid", "vchsk", "drqx", "keaua", "yaru", "mla", "shz", "lby", "vdxlv", "xyai", "lxtgl", "inz", "brhi", "iukt", "f", "lbjou", "vb", "sz", "ilkra", "izwk", "muqgs", "gom", "je"}))
                .isEqualTo(2);
        assertThat(minExtraChar("sayhelloworld", new String[]{"hello", "world"})).isEqualTo(3);
        assertThat(minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"})).isEqualTo(1);
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dic = Arrays.stream(dictionary).collect(Collectors.toSet());
        Integer[] dp = new Integer[s.length()];
        return dfs(s, 0, dic, dp);
    }

    private int dfs(String s, int index, Set<String> dic, Integer[] dp) {
        if (s.length() == index)
            return 0;
        if (dp[index] != null)
            return dp[index];

        String substring = s.substring(index);
        int min = substring.length();

        // use dictionary
        for (String word : dic) {
            if (substring.startsWith(word)) {
                min = Math.min(min, dfs(s, index + word.length(), dic, dp));
            }
        }

        // jump one
        min = Math.min(min, 1 + dfs(s, index + 1, dic, dp));
        return dp[index] = min;
    }

}
