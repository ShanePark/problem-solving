package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1125SmallestSufficientTeam3 {

    @Test
    void test() {
        assertThat(smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"}, Ps.strList("[[\"java\"],[\"nodejs\"],[\"nodejs\",\"reactjs\"]]"))).containsExactlyInAnyOrder(0, 2);
        assertThat(smallestSufficientTeam(new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"}, Ps.strList("[[\"algorithms\",\"math\",\"java\"],[\"algorithms\",\"math\",\"reactjs\"],[\"java\",\"csharp\",\"aws\"],[\"reactjs\",\"csharp\"],[\"csharp\",\"math\"],[\"aws\",\"java\"]]")))
                .containsExactlyInAnyOrder(1, 2);
    }

    @Test
    void wrong() {
        assertThat(smallestSufficientTeam(new String[]{"ldq", "lpah", "i", "ypowcknvrcuouhe", "jftllvrfghmvt", "svscjulmksgo", "xt", "mnfgnpsqhcobst"}, Ps.strList("[[\"lpah\",\"xt\"],[\"ldq\",\"i\"],[\"ypowcknvrcuouhe\"],[\"lpah\",\"jftllvrfghmvt\",\"mnfgnpsqhcobst\"],[\"xt\"],[\"i\",\"xt\"],[\"svscjulmksgo\"],[\"i\"],[\"i\",\"ypowcknvrcuouhe\"],[\"i\"],[],[\"svscjulmksgo\",\"mnfgnpsqhcobst\"],[],[\"xt\",\"mnfgnpsqhcobst\"],[],[\"ypowcknvrcuouhe\",\"mnfgnpsqhcobst\"],[\"i\"],[],[\"jftllvrfghmvt\",\"svscjulmksgo\"],[\"i\",\"mnfgnpsqhcobst\"],[\"jftllvrfghmvt\"],[\"jftllvrfghmvt\"],[],[\"i\"],[\"ypowcknvrcuouhe\"],[\"ypowcknvrcuouhe\"],[],[],[],[\"ldq\",\"i\"]]")))
                .hasSize(4);
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillIndexMap = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            skillIndexMap.put(req_skills[i], i);
        }

        int cases = (int) Math.pow(2, req_skills.length);
        List<Integer>[] dp = new List[cases];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < people.size(); i++) {
            int cur = 0;
            List<String> skills = people.get(i);
            for (String s : skills) {
                cur |= 1 << skillIndexMap.get(s);
            }
            for (int prev = 0; prev < dp.length; prev++) {
                if (dp[prev] == null)
                    continue;
                int comb = prev | cur;
                if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
                    dp[comb] = new ArrayList<>(dp[prev]);
                    dp[comb].add(i);
                }
            }
        }

        return dp[dp.length - 1].stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
