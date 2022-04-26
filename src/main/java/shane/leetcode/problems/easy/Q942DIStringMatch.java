package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q942DIStringMatch {

    @Test
    public void test() {
        String[] strs = {"IDID", "III", "DDI"};
        for (String str : strs) {
            int[] arr = diStringMatch(str);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length - 1; i++) {
                sb.append(arr[i] < arr[i + 1] ? "I" : "D");
            }
            assertThat(sb.toString()).isEqualTo(str);
        }
    }

    public int[] diStringMatch(String s) {
        int[] arr = new int[s.length() + 1];
        arr[0] = 0;
        int max = 0;
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (s.charAt(i - 1) == 'I' ? ++max : --min);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] += -min;
        }
        return arr;
    }
}
