package shane.programmers.lv3;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.04ms, 78MB)
 * 테스트 2 〉	통과 (0.03ms, 74.5MB)
 * 테스트 3 〉	통과 (0.88ms, 78.8MB)
 * 테스트 4 〉	통과 (0.99ms, 76.5MB)
 * 테스트 5 〉	통과 (1.21ms, 76.9MB)
 * 테스트 6 〉	통과 (0.80ms, 72.5MB)
 * 테스트 7 〉	통과 (0.73ms, 71.5MB)
 * 테스트 8 〉	통과 (0.80ms, 72MB)
 * 테스트 9 〉	통과 (1.38ms, 70.4MB)
 * 테스트 10 〉	통과 (0.94ms, 77.8MB)
 * 테스트 11 〉	통과 (1.55ms, 74.1MB)
 * 테스트 12 〉	통과 (2.57ms, 77MB)
 * 테스트 13 〉	통과 (0.71ms, 75.7MB)
 * 테스트 14 〉	통과 (1.74ms, 85.1MB)
 * 테스트 15 〉	통과 (1.86ms, 78.8MB)
 * 테스트 16 〉	통과 (2.31ms, 78.1MB)
 * 테스트 17 〉	통과 (0.03ms, 74MB)
 * 테스트 18 〉	통과 (0.02ms, 75.1MB)
 * 테스트 19 〉	통과 (0.73ms, 74.6MB)
 * 테스트 20 〉	통과 (1.31ms, 80.4MB)
 * 테스트 21 〉	통과 (1.57ms, 74.1MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (47.34ms, 52.4MB)
 * 테스트 2 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 69.3
 * 효율성: 15.3
 * 합계: 84.7 / 100.0
 */
public class LongestPalindrome3 {

    public static void main(String[] args) {
        assertEquals(7, solution("abcdcba"));
        assertEquals(3, solution("abacde"));
        assertEquals(1, solution("abcde"));
    }

    public static int solution(String s) {
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                max = Math.max(max, isPalindrome(s, i, i + j + 1));
            }
        }
        return max;
    }

    private static int isPalindrome(String str, int start, int end) {
        int length = end - start;
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i + start) != str.charAt(end - 1 - i)) {
                return 0;
            }
        }
        return length;
    }

}
