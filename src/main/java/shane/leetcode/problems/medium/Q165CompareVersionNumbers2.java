package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 1 ms Beats 78.87% of users with Java
 */
public class Q165CompareVersionNumbers2 {

    @Test
    void test() {
        Assertions.assertThat(compareVersion("1.0", "1.0.0")).isEqualTo(0);
        Assertions.assertThat(compareVersion("0.1", "1.1")).isEqualTo(-1);
        Assertions.assertThat(compareVersion("1.01", "1.001")).isEqualTo(0);
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int min = Integer.min(v1.length, v2.length);
        for (int i = 0; i < min; i++) {
            int ver1 = Integer.parseInt(v1[i]);
            int ver2 = Integer.parseInt(v2[i]);
            if (ver1 == ver2) {
                continue;
            }
            return Integer.compare(ver1, ver2);
        }
        String[] longer = v1.length == v2.length ? null : v1.length > v2.length ? v1 : v2;
        if (longer == null)
            return 0;
        for (int i = min; i < longer.length; i++) {
            String s = longer[i];
            int parsed = Integer.parseInt(s);
            if (parsed == 0)
                continue;
            return v1.length > v2.length ? 1 : -1;
        }
        return 0;
    }

}
