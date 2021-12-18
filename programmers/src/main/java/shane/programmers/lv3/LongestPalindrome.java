package shane.programmers.lv3;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.11ms, 78MB)
 * 테스트 2 〉	통과 (0.11ms, 77.4MB)
 * 테스트 3 〉	통과 (0.18ms, 77.1MB)
 * 테스트 4 〉	실패 (0.17ms, 72.6MB)
 * 테스트 5 〉	통과 (0.18ms, 73.1MB)
 * 테스트 6 〉	실패 (0.17ms, 76.5MB)
 * 테스트 7 〉	실패 (0.15ms, 78MB)
 * 테스트 8 〉	통과 (0.15ms, 75.4MB)
 * 테스트 9 〉	통과 (0.70ms, 73MB)
 * 테스트 10 〉	통과 (0.34ms, 70.9MB)
 * 테스트 11 〉	통과 (0.63ms, 77.3MB)
 * 테스트 12 〉	실패 (0.73ms, 75.5MB)
 * 테스트 13 〉	통과 (0.16ms, 70.8MB)
 * 테스트 14 〉	통과 (0.22ms, 71.9MB)
 * 테스트 15 〉	통과 (0.23ms, 73.1MB)
 * 테스트 16 〉	통과 (0.29ms, 76.3MB)
 * 테스트 17 〉	통과 (0.09ms, 78MB)
 * 테스트 18 〉	통과 (0.10ms, 83.2MB)
 * 테스트 19 〉	통과 (0.19ms, 76.8MB)
 * 테스트 20 〉	통과 (0.40ms, 73.4MB)
 * 테스트 21 〉	통과 (0.35ms, 74.1MB)
 * 효율성  테스트
 * 테스트 1 〉	실패 (1.20ms, 52.1MB)
 * 테스트 2 〉	통과 (38.25ms, 54.3MB)
 * 채점 결과
 * 정확성: 56.1
 * 효율성: 15.3
 * 합계: 71.5 / 100.0
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        assertEquals(7, solution("abcdcba"));
        assertEquals(3, solution("abacde"));
    }

    public static int solution(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, calc(s, i));
        }
        return max;
    }

    private static int calc(String s, int k) {
        int length = 1;
        int i = 0;
        while (true) {
            i++;
            try {
                if (s.charAt(k + i) == s.charAt(k - i)) {
                    length += 2;
                } else {
                    return length;
                }
            } catch (StringIndexOutOfBoundsException e) {
                return length;
            }
        }
    }
}
