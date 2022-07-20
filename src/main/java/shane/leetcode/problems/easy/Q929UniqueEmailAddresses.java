package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 60 ms, faster than 14.54% of Java online submissions for Unique Email Addresses.
 * Memory Usage: 55.1 MB, less than 7.97% of Java online submissions for Unique Email Addresses.
 */
public class Q929UniqueEmailAddresses {

    @Test
    public void test() {
        assertThat(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"})).isEqualTo(2);
        assertThat(numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"})).isEqualTo(3);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] arr = email.split("@");
            arr[0] = arr[0].replaceAll("\\.", "");
            int plusIndex = arr[0].indexOf("+");
            if (plusIndex > 0) {
                arr[0] = arr[0].substring(0, plusIndex);
            }
            set.add(arr[0] + "@" + arr[1]);
        }
        return set.size();
    }
}
