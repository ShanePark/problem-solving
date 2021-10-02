package shane.programmers.lv3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * Test 1 〉	통과 (0.09ms, 71.6MB)
 * Test 2 〉	통과 (0.30ms, 78.7MB)
 * Test 3 〉	통과 (0.61ms, 78.7MB)
 * Test 4 〉	통과 (13.95ms, 88.8MB)
 * Test 5 〉	통과 (0.11ms, 75.2MB)
 * Test 6 〉	통과 (0.05ms, 77MB)
 * Test 7 〉	통과 (0.06ms, 75.9MB)
 * Test 8 〉	통과 (13.77ms, 80.4MB)
 * Test 9 〉	통과 (15.56ms, 85MB)
 * Test 10 〉	통과 (29.55ms, 93.8MB)
 * Test 11 〉	통과 (50.06ms, 103MB)
 * Test 12 〉	통과 (14.04ms, 87MB)
 * Test 13 〉	통과 (14.26ms, 79.8MB)
 * Test 14 〉	통과 (163.32ms, 112MB)
 * Test 15 〉	통과 (25.75ms, 96.7MB)
 * 효율성  테스트
 * Test 1 〉	통과 (79.08ms, 71.1MB)
 * Test 2 〉	실패 (시간 초과)
 * Test 3 〉	통과 (153.55ms, 73.7MB)
 * Test 4 〉	실패 (시간 초과)
 * Test 5 〉	실패 (시간 초과)
 * Test 6 〉	통과 (118.59ms, 77.6MB)
 * Test 7 〉	실패 (시간 초과)
 * Test 8 〉	실패 (시간 초과)
 * Test 9 〉	통과 (390.39ms, 174MB)
 * Test 10 〉	실패 (시간 초과)
 * Test 11 〉	실패 (시간 초과)
 * Test 12 〉	실패 (시간 초과)
 * Test 13 〉	실패 (시간 초과)
 * Test 14 〉	실패 (시간 초과)
 * Test 15 〉	실패 (시간 초과)
 * Submission result
 * 정확성: 33.3
 * 효율성: 17.8
 * Total score: 51.1 / 100.0
 */
public class GemShopping {

    public static void main(String[] args) {
        System.out.printf(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.printf(Arrays.toString(solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
        System.out.printf(Arrays.toString(solution(new String[]{"XYZ", "XYZ", "XYZ"})));
        System.out.printf(Arrays.toString(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
    }

    public static int[] solution(String[] gems) {
        int minDistance = gems.length;
        int[] result = null;

        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        final int gemsetSize = gemSet.size();

        for (int i = 0; i < gems.length; i++) {
            Set<String> set = new HashSet<>();

            for (int j = i; j < gems.length && j - i < minDistance; j++) {
                set.add(gems[j]);
                if (set.size() == gemsetSize) {
                    int distance = j - i;
                    minDistance = distance;
                    result = new int[]{i + 1, j + 1};
                }
            }
        }
        return result;
    }
}
