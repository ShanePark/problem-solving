package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 61
 * ms
 * Beats
 * 12.80%
 */
public class Q966VowelSpellchecker {

    @Test
    public void test() {
        assertThat(spellchecker(new String[]{"KiTe", "kite", "hare", "Hare"}, new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"}))
                .containsExactly("kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe");
        assertThat(spellchecker(new String[]{"yellow"}, new String[]{"YellOw"}))
                .containsExactly("yellow");
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> original = new HashSet<>();
        Map<String, String> ignoreCases = new HashMap<>();
        Map<String, String> ignoreVowel = new HashMap<>();
        for (String word : wordlist) {
            original.add(word);
            String upper = word.toUpperCase();
            if (!ignoreCases.containsKey(upper)) {
                ignoreCases.put(upper, word);
            }
            String noVowel = removeVowel(upper);
            if (!ignoreVowel.containsKey(noVowel)) {
                ignoreVowel.put(noVowel, word);
            }
        }
        String[] answer = new String[queries.length];

        for (int i = 0; i < answer.length; i++) {
            String q = queries[i];
            if (original.contains(q)) {
                answer[i] = q;
                continue;
            }
            String upperCase = q.toUpperCase();
            if (ignoreCases.containsKey(upperCase)) {
                answer[i] = ignoreCases.get(upperCase);
                continue;
            }
            String noVowel = removeVowel(upperCase);
            if (ignoreVowel.containsKey(noVowel)) {
                answer[i] = ignoreVowel.get(noVowel);
                continue;
            }
            answer[i] = "";
        }
        return answer;
    }

    private static String removeVowel(String word) {
        return word.replaceAll("[AEIOUaeiou]", "*");
    }

}
