package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * not mine
 */
public class Q858MirrorReflection {

    @Test
    public void test() {
        assertThat(mirrorReflection(2, 1)).isEqualTo(2);
        assertThat(mirrorReflection(3, 1)).isEqualTo(1);
    }

    public int mirrorReflection(int p, int q) {
        int reflections = 1;
        int mirrors = 1;
        while (mirrors * p != reflections * q) {
            mirrors = ++reflections * q / p;
        }

        if (mirrors % 2 == 0) {
            return 0;
        } else if (reflections % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }
}
