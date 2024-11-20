package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 231ms Beats6.36%
 */
public class Q2516TakeKofEachCharacterFromLeftandRight {

    @Test
    public void test() {
        assertThat(takeCharacters("aabaaaacaabc", 2)).isEqualTo(8);
        assertThat(takeCharacters("a", 1)).isEqualTo(-1);
        assertThat(takeCharacters("a", 0)).isEqualTo(0);
        assertThat(takeCharacters("aabbccca", 2)).isEqualTo(6);
    }

    public int takeCharacters(String s, int k) {
        if (k == 0)
            return 0;
        final int LENGTH = s.length();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        Map<String, Integer> countIndexMap = new HashMap<>();

        for (int i = 0; i < LENGTH; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a':
                    countIndexMap.put("a" + ++countA, i);
                    break;
                case 'b':
                    countIndexMap.put("b" + ++countB, i);
                    break;
                case 'c':
                    countIndexMap.put("c" + ++countC, i);
                    break;
            }
        }
        if (!countIndexMap.containsKey("a" + k) || !countIndexMap.containsKey("b" + k) || !countIndexMap.containsKey("c" + k))
            return -1;

        countA = k;
        countB = k;
        countC = k;
        int answer = Math.max(countIndexMap.get("a" + k) + 1, countIndexMap.get("b" + k) + 1);
        answer = Math.max(answer, countIndexMap.get("c" + k) + 1);

        for (int i = 0; i < LENGTH; i++) {
            int rightIndex = LENGTH - 1 - i;
            char c = s.charAt(rightIndex);
            switch (c) {
                case 'a':
                    --countA;
                    break;
                case 'b':
                    --countB;
                    break;
                case 'c':
                    --countC;
                    break;
            }
            int curMinLeft = countIndexMap.getOrDefault("a" + countA, -1);
            curMinLeft = Math.max(curMinLeft, countIndexMap.getOrDefault("b" + countB, -1));
            curMinLeft = Math.max(curMinLeft, countIndexMap.getOrDefault("c" + countC, -1));
            answer = Math.min(answer, curMinLeft + 1 + i + 1);
        }

        return answer;
    }

}
