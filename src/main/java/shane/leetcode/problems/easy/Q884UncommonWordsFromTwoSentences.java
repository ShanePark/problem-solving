package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime4msBeats25.25%
 */
public class Q884UncommonWordsFromTwoSentences {

    @Test
    public void test() {
        assertThat(uncommonFromSentences("this apple is sweet", "this apple is sour")).containsExactly("sweet", "sour");
        assertThat(uncommonFromSentences("apple apple", "banana")).containsExactly("banana");
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> cnt1 = new HashMap<>();
        for (String s : s1.split(" ")) {
            cnt1.merge(s, 1, Integer::sum);
        }
        Map<String, Integer> cnt2 = new HashMap<>();
        for (String s : s2.split(" ")) {
            cnt2.merge(s, 1, Integer::sum);
        }
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> e : cnt1.entrySet()) {
            if (e.getValue() == 1 && !cnt2.containsKey(e.getKey())) {
                answer.add(e.getKey());
            }
        }
        for (Map.Entry<String, Integer> e : cnt2.entrySet()) {
            if (e.getValue() == 1 && !cnt1.containsKey(e.getKey())) {
                answer.add(e.getKey());
            }
        }
        return answer.toArray(String[]::new);
    }

}
