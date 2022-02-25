package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Q1773CountItemsMatchingaRule {

    @Test
    void test() {
        List<List<String>> items = Arrays.asList(Arrays.asList("phone", "blue", "pixel"), Arrays.asList("computer", "silver", "lenovo"), Arrays.asList("phone", "gold", "iphone"));
        Assertions.assertThat(countMatches(items, "color", "silver")).isEqualTo(1);
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt = 0;
        for (List<String> item : items) {
            if (item.get(ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2).equals(ruleValue))
                cnt++;
        }
        return cnt;
    }

}
