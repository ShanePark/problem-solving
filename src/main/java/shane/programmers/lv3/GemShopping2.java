package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.58ms, 73MB)
 * 테스트 2 〉	통과 (0.64ms, 71.9MB)
 * 테스트 3 〉	통과 (1.79ms, 76.8MB)
 * 테스트 4 〉	통과 (17.04ms, 85.3MB)
 * 테스트 5 〉	통과 (0.71ms, 74.2MB)
 * 테스트 6 〉	통과 (1.44ms, 75.4MB)
 * 테스트 7 〉	통과 (0.33ms, 71.4MB)
 * 테스트 8 〉	통과 (25.60ms, 82.5MB)
 * 테스트 9 〉	통과 (19.15ms, 80.6MB)
 * 테스트 10 〉	통과 (31.35ms, 92.3MB)
 * 테스트 11 〉	통과 (55.66ms, 93.6MB)
 * 테스트 12 〉	통과 (21.53ms, 84.6MB)
 * 테스트 13 〉	통과 (23.75ms, 89.5MB)
 * 테스트 14 〉	통과 (285.60ms, 118MB)
 * 테스트 15 〉	통과 (59.13ms, 96MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (111.75ms, 70.8MB)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	통과 (223.35ms, 84.8MB)
 * 테스트 4 〉	실패 (시간 초과)
 * 테스트 5 〉	실패 (시간 초과)
 * 테스트 6 〉	통과 (199.48ms, 87.6MB)
 * 테스트 7 〉	실패 (시간 초과)
 * 테스트 8 〉	실패 (시간 초과)
 * 테스트 9 〉	통과 (620.85ms, 222MB)
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
public class GemShopping2 {

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
            while (set.size() < count && right < gems.length) {
                set.add(gems[right++]);
            }
            right--;
            if (set.size() == count && right - left < min) {
                min = right - left;
                answer = new int[]{left + 1, right + 1};
            }
        }
        return answer;
    }
}
