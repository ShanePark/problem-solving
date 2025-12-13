package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 13
 * ms
 * Beats
 * 55.91%
 */
public class Q3606CouponCodeValidator {

    @Test
    public void test() {
        assertThat(validateCoupons(
                new String[]{"SAVE20", "", "PHARMA5", "SAVE@20"},
                new String[]{"restaurant", "grocery", "pharmacy", "restaurant"},
                new boolean[]{true, true, true, true}
        )).containsExactly("PHARMA5", "SAVE20");
        assertThat(validateCoupons(
                new String[]{"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"},
                new String[]{"grocery", "electronics", "invalid"},
                new boolean[]{false, true, true}
        )).containsExactly("ELECTRONICS_50");
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> list = new LinkedList<>();
        Map<String, Integer> businessIndex = Map.of("electronics", 0, "grocery", 1, "pharmacy", 2, "restaurant", 3);
        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) {
                continue;
            }
            if (!businessIndex.containsKey(businessLine[i])) {
                continue;
            }
            if (!validCode(code[i]))
                continue;
            list.add(new Coupon(code[i], businessIndex.get(businessLine[i])));
        }
        return list.stream().sorted()
                .map(o -> o.code)
                .collect(Collectors.toList());
    }

    private boolean validCode(String s) {
        if (s.isEmpty())
            return false;
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c))
                continue;
            if (Character.isDigit(c)) {
                continue;
            }
            if (c == '_')
                continue;
            return false;
        }
        return true;
    }

    class Coupon implements Comparable<Coupon> {
        final String code;
        final int businessIndex;

        Coupon(String code, int businessIndex) {
            this.code = code;
            this.businessIndex = businessIndex;
        }

        @Override
        public int compareTo(Coupon o) {
            if (this.businessIndex == o.businessIndex)
                return this.code.compareTo(o.code);
            return this.businessIndex - o.businessIndex;
        }
    }

}
