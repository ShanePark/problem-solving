package shane.programmers.lv3;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
@SuppressWarnings("ALL")
public class 자물쇠와열쇠2 {

    @Test
    public void test() {
        assertThat(solution(STool.convertToIntArray("[[1, 1, 1], [1, 1, 1], [1, 1, 1]]"), STool.convertToIntArray("[[1, 1, 1], [1, 1, 1], [1, 1, 1]]"))).isTrue();
        assertThat(solution(STool.convertToIntArray("[[0, 0, 0], [0, 0, 1], [0, 1, 0]]"), STool.convertToIntArray("[[1, 1, 1], [1, 1, 0], [1, 0, 1]]"))).isTrue();
        assertThat(solution(STool.convertToIntArray("[[0, 0, 0], [1, 0, 0], [0, 1, 1]]"), STool.convertToIntArray("[[1, 1, 1], [1, 1, 0], [1, 0, 1]]"))).isTrue();
    }

    public boolean solution(int[][] key, int[][] lock) {
        int keyLength = key.length;
        int lockLength = lock.length;

        int[][] bigKey = new int[keyLength + lockLength * 2][keyLength + lockLength * 2];
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                bigKey[i + lockLength][j + lockLength] = key[i][j];
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
