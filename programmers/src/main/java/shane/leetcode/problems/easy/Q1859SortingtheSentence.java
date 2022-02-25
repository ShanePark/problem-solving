package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Q1859SortingtheSentence {

    @Test
    void test() {
        Assertions.assertThat(sortSentence("is2 sentence4 This1 a3")).isEqualTo("This is a sentence");
        Assertions.assertThat(sortSentence("Myself2 Me1 I4 and3")).isEqualTo("Me Myself and I");
    }

    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        Arrays.sort(arr, Comparator.comparingInt(o -> o.charAt(o.length() - 1)));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.setCharAt(sb.length() - 1, ' ');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
