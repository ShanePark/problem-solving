package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q165CompareVersionNumbers {

    @Test
    void test() {
        Assertions.assertThat(compareVersion("1.01", "1.001")).isEqualTo(0);
        Assertions.assertThat(compareVersion("1.0", "1.0.0")).isEqualTo(0);
        Assertions.assertThat(compareVersion("0.1", "1.1")).isEqualTo(-1);
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxLength = Math.max(v1.length, v2.length);
        for (int i = 0; i < maxLength; i++) {
            int revision1 = i > v1.length - 1 ? 0 : Integer.parseInt(v1[i]);
            int revision2 = i > v2.length - 1 ? 0 : Integer.parseInt(v2[i]);
            if (revision1 != revision2) {
                return revision1 > revision2 ? 1 : -1;
            }
        }
        return 0;
    }

}
