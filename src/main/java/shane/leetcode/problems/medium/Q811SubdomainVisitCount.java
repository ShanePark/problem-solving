package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q811SubdomainVisitCount {

    @Test
    public void test() {
        assertThat(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}))
                .containsExactlyInAnyOrder("901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org", "1 intel.mail.com", "951 com");
    }

    public List<String> subdomainVisits(String[] datas) {
        Map<String, Integer> map = new HashMap<>();
        for (String data : datas) {
            int indexOfBS = data.indexOf(" ");
            int cnt = Integer.parseInt(data.substring(0, indexOfBS));
            String domain = data.substring(indexOfBS + 1);

            map.merge(domain, cnt, Integer::sum);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    map.merge(domain.substring(i + 1), cnt, Integer::sum);
                }
            }
        }
        List<String> answer = new ArrayList<>();
        for (String key : map.keySet()) {
            answer.add(map.get(key) + " " + key);
        }
        return answer;
    }


}
