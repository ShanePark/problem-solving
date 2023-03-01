package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.04ms, 72.8MB)
 * 테스트 2 〉	통과 (0.03ms, 72.6MB)
 * 테스트 3 〉	통과 (0.51ms, 75.4MB)
 * 테스트 4 〉	통과 (0.03ms, 76.3MB)
 * 테스트 5 〉	통과 (0.26ms, 72.8MB)
 * 테스트 6 〉	실패 (0.49ms, 76MB)
 * 테스트 7 〉	통과 (1.11ms, 73.9MB)
 * 테스트 8 〉	통과 (1.30ms, 77MB)
 * 테스트 9 〉	통과 (0.38ms, 77.6MB)
 * 테스트 10 〉	통과 (0.78ms, 72.1MB)
 * 테스트 11 〉	통과 (2.30ms, 80.6MB)
 * 테스트 12 〉	통과 (0.03ms, 74.9MB)
 * 테스트 13 〉	통과 (0.14ms, 74.7MB)
 * 테스트 14 〉	통과 (0.09ms, 75.8MB)
 * 테스트 15 〉	통과 (0.04ms, 82.1MB)
 * 테스트 16 〉	통과 (0.70ms, 73.1MB)
 * 테스트 17 〉	통과 (0.11ms, 72.5MB)
 * 테스트 18 〉	통과 (1.99ms, 83.4MB)
 * 테스트 19 〉	통과 (0.09ms, 73MB)
 * 테스트 20 〉	통과 (2.12ms, 73.7MB)
 * 테스트 21 〉	통과 (0.32ms, 74.4MB)
 * 테스트 22 〉	통과 (0.23ms, 73.1MB)
 * 테스트 23 〉	통과 (0.17ms, 77MB)
 * 테스트 24 〉	통과 (0.14ms, 73.4MB)
 * 테스트 25 〉	통과 (3.59ms, 75.4MB)
 * 테스트 26 〉	통과 (0.72ms, 75MB)
 * 테스트 27 〉	통과 (2.20ms, 70.9MB)
 * 테스트 28 〉	통과 (0.21ms, 77.4MB)
 * 테스트 29 〉	통과 (0.27ms, 79.9MB)
 * 테스트 30 〉	통과 (0.55ms, 78MB)
 * 테스트 31 〉	통과 (1.61ms, 71.2MB)
 * 테스트 32 〉	통과 (0.83ms, 85.8MB)
 * 테스트 33 〉	통과 (0.24ms, 72.2MB)
 * 테스트 34 〉	통과 (0.03ms, 74.4MB)
 * 테스트 35 〉	통과 (0.17ms, 74.3MB)
 * 테스트 36 〉	통과 (0.12ms, 76.5MB)
 * 테스트 37 〉	통과 (0.11ms, 76.4MB)
 * 테스트 38 〉	통과 (0.05ms, 77.4MB)
 * 채점 결과
 * 정확성: 97.0
 * 합계: 97.0 / 100.0
 */
public class 자물쇠와열쇠 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[0, 0, 0], [0, 0, 1], [0, 1, 0]]"), Ps.intArray("[[1, 1, 1], [1, 1, 0], [1, 0, 1]]"))).isTrue();
        assertThat(solution(Ps.intArray("[[0, 0, 0], [1, 0, 0], [0, 1, 1]]"), Ps.intArray("[[1, 1, 1], [1, 1, 0], [1, 0, 1]]"))).isTrue();
    }

    public boolean solution(int[][] key, int[][] lock) {
        int keyLength = key.length;
        int lockLength = lock.length;

        int[][] bigKey = new int[keyLength + (lockLength - 1) * 2][keyLength + (lockLength - 1) * 2];
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                bigKey[i + lockLength - 1][j + lockLength - 1] = key[i][j];
            }
        }

        if (checkKey(bigKey, lock))
            return true;

        bigKey = turnRight(bigKey);
        // turn right 1
        if (checkKey(bigKey, lock))
            return true;

        // turn right 2
        bigKey = turnRight(bigKey);
        if (checkKey(bigKey, lock))
            return true;

        // turn right 3
        bigKey = turnRight(bigKey);
        if (checkKey(bigKey, lock))
            return true;

        return false;
    }

    private int[][] turnRight(int[][] bigKey) {
        int length = bigKey.length;
        int[][] right = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                right[i][j] = bigKey[length - 1 - j][i];
            }
        }
        return right;
    }

    private boolean checkKey(int[][] bigKey, int[][] lock) {
        for (int i = 0; i < bigKey.length - lock.length; i++) {
            for (int j = 0; j < bigKey.length - lock.length; j++) {
                if (possible(i, j, bigKey, lock)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean possible(int i, int j, int[][] bigKey, int[][] lock) {
        int lockLength = lock.length;
        for (int y = 0; y < lockLength; y++) {
            for (int x = 0; x < lockLength; x++) {
                if (lock[y][x] + bigKey[i + y][j + x] != 1)
                    return false;
            }
        }
        return true;
    }
}
