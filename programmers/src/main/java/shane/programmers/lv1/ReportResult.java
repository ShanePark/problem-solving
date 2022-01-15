package shane.programmers.lv1;

import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 신고 결과 받기 https://programmers.co.kr/learn/courses/30/lessons/92334
 */
public class ReportResult {
    public static void main(String[] args) {
        Assertions.assertArrayEquals(new int[]{2, 1, 1, 0}, solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2));
        Assertions.assertArrayEquals(new int[]{0, 0}, solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> reporterMap = new HashMap<>();
        Map<String, Integer> reportCountMap = new HashMap<>();
        Map<String, Integer> idIndex = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            String s = id_list[i];
            reportCountMap.put(s, 0);
            reporterMap.put(s, new ArrayList<>());
            idIndex.put(s, i);
        }
        for (String s : Arrays.stream(report).collect(Collectors.toSet())) {
            String[] split = s.split(" ");
            String reported = split[1];
            String reporter = split[0];
            reportCountMap.put(reported, reportCountMap.get(reported) + 1);
            reporterMap.get(reported).add(reporter);
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            if (reportCountMap.get(id_list[i]) >= k) {
                List<String> reporters = reporterMap.get(id_list[i]);
                for (String reporter : reporters) {
                    answer[idIndex.get(reporter)]++;
                }
            }
        }

        return answer;

    }

}
