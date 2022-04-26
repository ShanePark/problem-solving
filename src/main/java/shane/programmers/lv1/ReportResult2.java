package shane.programmers.lv1;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


/**
 * https://programmers.co.kr/questions/25446
 * 다른 유저 코드 고쳐주기
 */
public class ReportResult2 {
    public static void main(String[] args) {
        Assertions.assertArrayEquals(new int[]{2, 1, 1, 0}, solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2));
        Assertions.assertArrayEquals(new int[]{0, 0}, solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        HashMap<String, ArrayList<String>> reportList = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();
        HashMap<String, Integer> mailCount = new HashMap<>();
        for (String s : report) {
            Report(reportList, reportCount, s);
        }
        sendEmail(reportList, reportCount, mailCount, k);
        for (int i = 0; i < id_list.length; i++) {
            result[i] = mailCount.getOrDefault(id_list[i], 0);
        }
        return result;
    }

    public static void Report(HashMap<String, ArrayList<String>> reportList, HashMap<String, Integer> reportCount, String report) {  // 유저id 와 유저가 신고한 id 리스트로 해시를 생성하고 신고당한유저의 id 별 횟수 해시 생성
        String[] id = report.split(" ");
        ArrayList<String> idList = new ArrayList<String>();
        if (reportList.get(id[0]) != null) {
            if (reportList.get(id[0]).indexOf(id[1]) != -1) {
                return;
            }
            idList = reportList.get(id[0]);
        }
        if (id[0].equals(id[1])) {
            return;
        }
        idList.add(id[1]);
        reportList.put(id[0], idList);
        if (reportCount.containsKey(id[1])) {
            reportCount.put(id[1], reportCount.get(id[1]) + 1);
            return;
        }
        reportCount.put(id[1], 1);

    }

    public static void sendEmail(HashMap<String, ArrayList<String>> reportList, HashMap<String, Integer> reportCount, HashMap<String, Integer> mailCount, int k) {   // 이메일을 보낼 유저를 찾는 함수
        Set<String> keys = reportCount.keySet();
        for (String s : keys) {
            if (reportCount.get(s) >= k) {
                findWhoReport(reportList, mailCount, s);
            }
        }
    }

    public static void findWhoReport(HashMap<String, ArrayList<String>> reportList, HashMap<String, Integer> mailCount, String id) {   //정지 기준을 넘은 유저를 신고한 유저의 메일 횟수를 카운팅
        Set<String> keys = reportList.keySet();
        for (String s : keys) {
            if (reportList.get(s).indexOf(id) != -1) {
                if (mailCount.containsKey(s)) {
                    mailCount.put(s, mailCount.get(s) + 1);
                    continue;
                }
                mailCount.put(s, 1);
            }
        }
    }

}
