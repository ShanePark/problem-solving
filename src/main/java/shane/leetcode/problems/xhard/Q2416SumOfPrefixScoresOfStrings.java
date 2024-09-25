package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2416SumOfPrefixScoresOfStrings {

    @Test
    public void test() {
        assertThat(sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})).isEqualTo(new int[]{5, 4, 3, 2});
        assertThat(sumPrefixScores(new String[]{"abcd"})).isEqualTo(new int[]{4});
    }

    /**
     * 1 sec 974 ms
     */
    @Test
    public void tle() {
        int MAX_LENGTH = 1000;
        String[] arr = new String[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < MAX_LENGTH; j++) {
                char c = (char) (new Random().nextInt(26) + 'a');
                sb.append(c);
            }
            arr[i] = sb.toString();
        }

        assertThat(sumPrefixScores(arr)).hasSize(1000);
    }

    public int[] sumPrefixScores(String[] words) {
        Map<String, Integer> scores = new HashMap<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(c);
                scores.merge(sb.toString(), 1, Integer::sum);
            }
        }
        int[] answer = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            int score = 0;
            for (char c : word.toCharArray()) {
                sb.append(c);
                score += scores.get(sb.toString());
            }
            answer[i] = score;
        }
        return answer;
    }

}
