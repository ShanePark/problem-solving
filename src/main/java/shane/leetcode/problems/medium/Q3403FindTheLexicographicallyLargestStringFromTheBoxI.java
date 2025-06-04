package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 12
 * ms
 * Beats
 * 40.74%
 */
public class Q3403FindTheLexicographicallyLargestStringFromTheBoxI {

    @Test
    public void test() {
        assertThat(answerString("gh", 1)).isEqualTo("gh");
        assertThat(answerString("dbca", 2)).isEqualTo("dbc");
        assertThat(answerString("gggg", 4)).isEqualTo("g");
    }


    public String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;
        String answer = "";
        int len = word.length() - numFriends + 1;
        for (int i = 0; i < word.length(); i++) {
            String substring = word.substring(i, Math.min(word.length(), i + len));
            if (substring.compareTo(answer) > 0) {
                answer = substring;
            }
        }
        return answer;
    }

}
