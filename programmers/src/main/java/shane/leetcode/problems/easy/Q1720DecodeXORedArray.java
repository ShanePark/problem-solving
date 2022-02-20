package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1720DecodeXORedArray {

    @Test
    void test() {
        Assertions.assertThat(decode(new int[]{1, 2, 3}, 1)).containsExactly(1, 0, 2, 1);
        Assertions.assertThat(decode(new int[]{6, 2, 7, 3}, 4)).containsExactly(4, 2, 0, 7, 4);
    }

    public int[] decode(int[] encoded, int first) {
        int[] output = new int[encoded.length + 1];
        output[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            output[i + 1] = encoded[i] ^ output[i];
        }
        return output;
    }

}
