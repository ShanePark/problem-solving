package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Q916WordSubsets {

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
        List<String> answer = new ArrayList<>();
        List<int[]> word2Counts = new ArrayList<>();
        for (String s : words2) {
            word2Counts.add(toCountArr(s));
        }
        for (String s : words1) {
            if (possible(toCountArr(s), word2Counts)) {
                answer.add(s);
            }
        }
        return answer;
    }

    private boolean possible(int[] cntArr, List<int[]> words2) {
        for (int[] w : words2) {
            for (int i = 0; i < 26; i++) {
                if (cntArr[i] < w[i]) {
                    return false;
                }
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
