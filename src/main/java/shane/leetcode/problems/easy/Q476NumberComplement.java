package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats26.96%
 */
public class Q476NumberComplement {

    @Test
    public void test() {
        assertThat(findComplement(5)).isEqualTo(2);
        assertThat(findComplement(1)).isEqualTo(0);
        assertThat(findComplement(0)).isEqualTo(1);
        assertThat(findComplement(Integer.MAX_VALUE)).isEqualTo(0);
    }

    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder complement = new StringBuilder();
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                complement.append(0);
                continue;
            }
            complement.append(1);
        }
        return Integer.parseInt(complement.toString(), 2);
    }

}
