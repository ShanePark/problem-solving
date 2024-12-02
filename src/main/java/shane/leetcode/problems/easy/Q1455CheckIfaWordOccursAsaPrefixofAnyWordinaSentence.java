package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0ms Beats100.00% 
 */
public class Q1455CheckIfaWordOccursAsaPrefixofAnyWordinaSentence {

    @Test
    public void test() {
        assertThat(isPrefixOfWord("i love eating burger", "burg")).isEqualTo(4);
        assertThat(isPrefixOfWord("this problem is an easy problem", "pro")).isEqualTo(2);
        assertThat(isPrefixOfWord("i am tired", "you")).isEqualTo(-1);
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if (str.startsWith(searchWord))
                return i + 1;
        }
        return -1;
    }

}
