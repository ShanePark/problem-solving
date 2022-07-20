package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q929UniqueEmailAddresses2 {

    @Test
    public void test() {
        assertThat(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"})).isEqualTo(2);
        assertThat(numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"})).isEqualTo(3);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] arr = email.split("@");
            String name = arr[0];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                if (c == '+') {
                    break;
                } else if (c != '.') {
                    sb.append(c);
                }
            }
            set.add(sb + "@" + arr[1]);
        }
        return set.size();
    }
}
