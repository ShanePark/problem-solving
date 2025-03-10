package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 * Runtime
 * 1603ms
 * Beats5.13%
 */
public class Q3306CountOfSubstringsContainingEveryVowelAndKConsonantsII {

    @Test
    public void test() {
        assertThat(countOfSubstrings("aeioqq", 1)).isEqualTo(0);
        assertThat(countOfSubstrings("aeiou", 0)).isEqualTo(1);
        assertThat(countOfSubstrings("ieaouqqieaouqq", 1)).isEqualTo(3);
    }

    final int[] VOWELS = new int[]{0, 4, 8, 14, 20};

    public long countOfSubstrings(String word, int k) {
        final int LENGTH = word.length();
        int[][] cnt = new int[LENGTH][26];
        cnt[0][word.charAt(0) - 'a'] = 1;
        for (int i = 1; i < LENGTH; i++) {
            char c = word.charAt(i);
            cnt[i] = Arrays.copyOf(cnt[i - 1], 26);
            cnt[i][c - 'a']++;
        }
        int[] lastOccurrence = new int[26];
        Arrays.fill(lastOccurrence, -1);

        long answer = 0;
        for (int r = 0; r < LENGTH; r++) {
            char c = word.charAt(r);
            if (isVowel(c)) {
                lastOccurrence[c - 'a'] = r;
            }
            if (r < 4 + k) {
                continue;
            }
            if (!isVowelOk(cnt[r])) {
                continue;
            }
            int vowelLimit = Integer.MAX_VALUE;
            for (int vowel : VOWELS) {
                vowelLimit = Math.min(vowelLimit, lastOccurrence[vowel]);
            }
            int[] boundaries = findBoundaries(cnt, r, k);
            if (boundaries == null) continue;
            int L_min = boundaries[0], L_max = boundaries[1];
            if (vowelLimit >= L_min) {
                int validUpper = Math.min(vowelLimit, L_max);
                answer += (validUpper - L_min + 1);
            }
        }
        return answer;
    }

    private int[] findBoundaries(int[][] cnt, int r, int k) {
        int lo = 0, hi = r + 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int fMid = consonantCount(cnt, mid, r);
            if (fMid <= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        int L_min = lo;
        if (L_min > r || consonantCount(cnt, L_min, r) != k) {
            return null;
        }
        hi = r + 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int fMid = consonantCount(cnt, mid, r);
            if (fMid < k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        int L_max = lo - 1;
        return new int[]{L_min, L_max};
    }


    private int consonantCount(int[][] cnt, int L, int r) {
        int vowelCount = 0;
        for (int idx : VOWELS) {
            vowelCount += cnt[r][idx] - (L > 0 ? cnt[L - 1][idx] : 0);
        }
        int total = r - L + 1;
        return total - vowelCount;
    }

    private boolean isVowelOk(int[] cntArr) {
        for (int vowel : VOWELS) {
            if (cntArr[vowel] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
