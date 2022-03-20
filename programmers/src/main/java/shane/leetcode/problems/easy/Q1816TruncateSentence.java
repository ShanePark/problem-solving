package shane.leetcode.problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1816TruncateSentence {

    @Test
    public void test() {
        assertThat(truncateSentence("Hello how are you Contestant", 4)).isEqualTo("Hello how are you");
        assertThat(truncateSentence("chopper is not a tanuki", 5)).isEqualTo("chopper is not a tanuki");
    }

    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder(arr[0]);
        for (int i = 1; i < k; i++) {
            sb.append(" ").append(arr[i]);
        }
        return sb.toString();
    }

}
