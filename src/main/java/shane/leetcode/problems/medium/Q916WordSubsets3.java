package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime: 21 ms, faster than 89.84% of Java online submissions for Word Subsets.
 * Memory Usage: 50.7 MB, less than 88.21% of Java online submissions for Word Subsets.
 */
@SuppressWarnings("ALL")
public class Q916WordSubsets3 {

    @Test
    public void test() {
        assertThat(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"})).containsExactly("facebook", "google", "leetcode");
        assertThat(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"l", "e"})).containsExactly("apple", "google", "leetcode");
        assertThat(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"oo"})).containsExactly("facebook", "google");
        assertThat(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lo", "eo"})).containsExactly("google", "leetcode");
    }

    /**
     * 800 ms
     */
    @Test
    public void test2() {
        int length = 10000;
        String[] arr1 = new String[length];
        String[] arr2 = new String[length];
        String str = "aaaaaaaaaa";
        for (int i = 0; i < length; i++) {
            arr1[i] = str;
            arr2[i] = str;
        }

        wordSubsets(arr1, arr2);
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        final int[] condition = new int[26];
        Arrays.stream(words2)
                .map(s -> toCountArr(s))
                .forEach(c -> {
                    for (int i = 0; i < 26; i++) {
                        condition[i] = Math.max(condition[i], c[i]);
                    }
                });

        return Arrays.stream(words1)
                .filter(s -> possible(toCountArr(s), condition))
                .collect(Collectors.toList());
    }

    private boolean possible(int[] cntArr, int[] condition) {
        for (int i = 0; i < 26; i++) {
            if (cntArr[i] < condition[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] toCountArr(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }
}
