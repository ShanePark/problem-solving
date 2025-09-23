package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime
 * 4ms
 * Beats6.29%
 */
public class Q165CompareVersionNumbers3 {

    @Test
    void test() {
        Assertions.assertThat(compareVersion("1.0", "1.0.0")).isEqualTo(0);
        Assertions.assertThat(compareVersion("0.1", "1.1")).isEqualTo(-1);
        Assertions.assertThat(compareVersion("1.01", "1.001")).isEqualTo(0);
    }

    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2))
            return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int v1First = v1[0].isBlank() ? 0 : Integer.parseInt(v1[0]);
        int v2First = v2[0].isBlank() ? 0 : Integer.parseInt(v2[0]);
        if (v1First == v2First) {
            return compareVersion(calcNext(version1), calcNext(version2));
        }
        return v1First > v2First ? 1 : -1;
    }

    private String calcNext(String version1) {
        int zeroIndex = version1.indexOf(".");
        if (zeroIndex < 0)
            return "";
        return version1.substring(zeroIndex + 1);
    }

}
