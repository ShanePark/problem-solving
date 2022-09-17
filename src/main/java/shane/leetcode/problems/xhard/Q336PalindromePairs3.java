package shane.leetcode.problems.xhard;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static shane.leetcode.problems.xhard.Q336PalindromePairs_TESTCASE1.testCase1;
import static shane.leetcode.problems.xhard.Q336PalindromePairs_TESTCASE2.testCase2;

@SuppressWarnings("ALL")
public class Q336PalindromePairs3 {

    @Test
    public void test() {
        assertThat(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"})).isEqualTo(STool.convertToIntList("[[1, 0], [0, 1], [3, 2], [2, 4]]"));
        assertThat(palindromePairs(new String[]{"bat", "tab", "cat"})).isEqualTo(STool.convertToIntList(" [[1, 0], [0, 1]]"));
        assertThat(palindromePairs(new String[]{"a", ""})).isEqualTo(STool.convertToIntList("[[0,1],[1,0]]"));
    }

    /**
     * 51 ms
     */
    @Test
    public void tle() {
        assertThat(palindromePairs(testCase1)).hasSize(4869);
    }

    /**
     * 700 ms
     */
    @Test
    public void tle2() {
        assertThat(palindromePairs(testCase2)).hasSize(56);
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> indexMap = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();
        final int LENGTH = words.length;

        for (int i = 0; i < LENGTH; i++) {
            indexMap.put(words[i], i);
        }

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String head = words[i].substring(0, j);
                String tail = words[i].substring(j);
                addPair(indexMap, answer, head, tail, i, false);
                if (tail.length() > 0) {
                    addPair(indexMap, answer, tail, head, i, true);
                }
            }
        }
        return answer;
    }

    private void addPair(Map<String, Integer> map, List<List<Integer>> answer, String str1, String str2, int index, boolean reverse) {
        if (!isPalindrome(str1))
            return;
        Integer reverseIndex = map.get(new StringBuilder(str2).reverse().toString());
        if (reverseIndex != null && reverseIndex != index) {
            if (reverse) {
                answer.add(List.of(index, reverseIndex));
            } else {
                answer.add(List.of(reverseIndex, index));
            }
        }
    }

    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }


}
