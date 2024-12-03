package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 24ms Beats58.36% 
 */
public class Q2109AddingSpacestoaString {

    @Test
    public void test() {
        assertThat(addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15})).isEqualTo("Leetcode Helps Me Learn");
        assertThat(addSpaces("icodeinpython", new int[]{1, 5, 7, 9})).isEqualTo("i code in py thon");
        assertThat(addSpaces("spacing", new int[]{0, 1, 2, 3, 4, 5, 6})).isEqualTo(" s p a c i n g");
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int arrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arrIndex < spaces.length && i == spaces[arrIndex]) {
                arrIndex++;
                sb.append(" ");
            }
            char c = arr[i];
            sb.append(c);
        }
        return sb.toString();
    }

}
