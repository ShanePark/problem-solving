package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class 개인정보_수집_유효기간 {

    @Test
    public void test() {
        assertThat(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}))
                .containsExactly(1, 3);
        assertThat(solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}))
                .containsExactly(1, 4, 5);
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> expires = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            expires.put(s[0], Integer.parseInt(s[1]));
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            if (isExpired(privacy, expires, today)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private boolean isExpired(String privacy, Map<String, Integer> expires, String todayString) {
        String[] data = privacy.split(" ");
        String date = data[0];
        String term = data[1];
        Integer expMonths = expires.get(term);
        int today = stringToDay(todayString);
        int expDay = stringToDay(date) + expMonths * 28;
        return expDay <= today;
    }

    private int stringToDay(String todayString) {
        int year = Integer.parseInt(todayString.substring(0, 4));
        int month = Integer.parseInt(todayString.substring(5, 7));
        int day = Integer.parseInt(todayString.substring(8));
        return (12 * year + month) * 28 + day;
    }

}
