package shane.programmers.lv3;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.05ms, 74.1MB)
 * 테스트 2 〉	통과 (0.06ms, 76.4MB)
 * 테스트 3 〉	통과 (1.87ms, 79.1MB)
 * 테스트 4 〉	통과 (1.98ms, 79.6MB)
 * 테스트 5 〉	통과 (1.33ms, 77.7MB)
 * 테스트 6 〉	통과 (1.20ms, 66.9MB)
 * 테스트 7 〉	통과 (1.29ms, 76.9MB)
 * 테스트 8 〉	통과 (1.21ms, 75.8MB)
 * 테스트 9 〉	통과 (1.88ms, 68.7MB)
 * 테스트 10 〉	통과 (1.56ms, 82MB)
 * 테스트 11 〉	통과 (2.05ms, 75.2MB)
 * 테스트 12 〉	통과 (3.78ms, 75.3MB)
 * 테스트 13 〉	통과 (0.97ms, 77.6MB)
 * 테스트 14 〉	통과 (3.25ms, 88.3MB)
 * 테스트 15 〉	통과 (3.42ms, 80.3MB)
 * 테스트 16 〉	통과 (3.59ms, 79.8MB)
 * 테스트 17 〉	통과 (0.02ms, 74.6MB)
 * 테스트 18 〉	통과 (0.03ms, 71.4MB)
 * 테스트 19 〉	통과 (1.58ms, 76.3MB)
 * 테스트 20 〉	통과 (1.66ms, 74.2MB)
 * 테스트 21 〉	통과 (2.20ms, 76.1MB)
 * 효율성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 */
public class LongestPalindrome2 {

    public static void main(String[] args) {
        assertEquals(7, solution("abcdcba"));
        assertEquals(3, solution("abacde"));
        assertEquals(1, solution("abcde"));
    }

    public static int solution(String s) {
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                String str = s.substring(i, i + j + 1);
                if (str.length() == 1) continue;
                if (isPalindrome(str)) {
                    max = Math.max(max, str.length());
                }
            }
        }
        return max;
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
