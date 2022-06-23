package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.36ms, 72.4MB)
 * 테스트 2 〉	통과 (0.54ms, 76.8MB)
 * 테스트 3 〉	통과 (0.93ms, 85.8MB)
 * 테스트 4 〉	통과 (15.04ms, 86.2MB)
 * 테스트 5 〉	통과 (0.57ms, 82.9MB)
 * 테스트 6 〉	통과 (0.34ms, 65.8MB)
 * 테스트 7 〉	통과 (0.30ms, 72.4MB)
 * 테스트 8 〉	통과 (15.96ms, 81.6MB)
 * 테스트 9 〉	통과 (11.39ms, 88.2MB)
 * 테스트 10 〉	통과 (41.02ms, 100MB)
 * 테스트 11 〉	통과 (66.60ms, 101MB)
 * 테스트 12 〉	통과 (15.86ms, 86.8MB)
 * 테스트 13 〉	통과 (14.74ms, 78.2MB)
 * 테스트 14 〉	통과 (168.95ms, 132MB)
 * 테스트 15 〉	통과 (28.23ms, 98MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (99.93ms, 70.1MB)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	통과 (164.89ms, 73.3MB)
 * 테스트 4 〉	실패 (시간 초과)
 * 테스트 5 〉	실패 (시간 초과)
 * 테스트 6 〉	통과 (168.13ms, 78.2MB)
 * 테스트 7 〉	실패 (시간 초과)
 * 테스트 8 〉	실패 (시간 초과)
 * 테스트 9 〉	통과 (429.95ms, 174MB)
 * 테스트 10 〉	실패 (시간 초과)
 * 테스트 11 〉	실패 (시간 초과)
 * 테스트 12 〉	실패 (시간 초과)
 * 테스트 13 〉	실패 (시간 초과)
 * 테스트 14 〉	실패 (시간 초과)
 * 테스트 15 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 33.3
 * 효율성: 17.8
 * 합계: 51.1 / 100.0
 */
public class GemShopping3 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})).containsExactly(3, 7);
        assertThat(solution(new String[]{"AA", "AB", "AC", "AA", "AC"})).containsExactly(1, 3);
        assertThat(solution(new String[]{"XYZ", "XYZ", "XYZ"})).containsExactly(1, 1);
        assertThat(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})).containsExactly(1, 5);
    }

    public static int[] solution(String[] gems) {
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        long count = Arrays.stream(gems).distinct().count();

        for (int i = 0; i < gems.length; i++) {
            int left = i;
            int right = i;
            Set<String> set = new HashSet<>();
            while (right - left < min && set.size() < count && right < gems.length) {
                set.add(gems[right++]);
            }
            if (set.size() == count) {
                min = right - left - 1;
                answer = new int[]{left + 1, right};
            }
        }
        return answer;
    }
}
