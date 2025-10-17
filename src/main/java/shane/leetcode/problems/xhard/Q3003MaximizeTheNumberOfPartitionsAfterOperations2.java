package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3003MaximizeTheNumberOfPartitionsAfterOperations2 {

    @Test
    public void test() {
        assertThat(maxPartitionsAfterOperations("accca", 2)).isEqualTo(3);
        assertThat(maxPartitionsAfterOperations("aabaab", 3)).isEqualTo(1);
    }

    @Test
    public void tle() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append((char) ('a' + (i % 3)));
        }
        assertThat(maxPartitionsAfterOperations(sb.toString(), 2)).isEqualTo(5000);
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        if (k == 26)
            return 1;

        List<int[]> prefs = getPrefs(0, s, k, s.charAt(0));
        int answer = prefs.size();
        int originalPartitions = answer;

        for (int i = 0; i < prefs.size() && answer < originalPartitions + 2; i++) {
            int[] arr = prefs.get(i);
            int l = arr[0], mid = arr[1], r = arr[2], mask = arr[3];

            if (r - l > k && mid < r) {
                if (answer == originalPartitions && mid - l >= k) {
                    List<int[]> tmp = getPrefs(mid, s, k, s.charAt(mid));
                    answer = Math.max(answer, 1 + i + tmp.size());
                }
                if (answer == originalPartitions || r - mid > k) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if ((mask & (1 << (ch - 'a'))) == 0 || (mid + 1 < s.length() && ch == s.charAt(mid + 1))) {
                            List<int[]> tmp = getPrefs(mid + 1, s, k, ch);
                            answer = Math.max(answer, i + 1 + tmp.size());
                        }
                    }
                }
            }
        }

        return answer;
    }

    List<int[]> getPrefs(int index, String s, int k, char first) {
        List<int[]> res = new ArrayList<>();
        int mask = 0;
        int cnt = 0;
        int mid = -1;
        int l = index;

        for (int i = index; i < s.length(); i++) {
            int bt = (i == index) ? (first - 'a') : (s.charAt(i) - 'a');
            if ((mask & (1 << bt)) == 0) {
                if (cnt == k) {
                    res.add(new int[]{l, mid, i, mask});
                    l = i;
                    mid = -1;
                    cnt = 0;
                    mask = 0;
                }
                cnt++;
                mask |= (1 << bt);
                if (cnt == k)
                    mid = i;
            }
        }
        res.add(new int[]{l, (mid == -1 ? s.length() : mid), s.length(), mask});
        return res;
    }
}

