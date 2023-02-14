package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 9 ms Beats 48.88%
 * Memory 46.5 MB Beats 59.29%
 */
public class Q36ValidSudoku {

    @Test
    public void test() {
        assertThat(isValidSudoku(Ps.charArray("" +
                "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]"))).isTrue();
    }

    @Test
    public void test2() {
        assertThat(isValidSudoku(Ps.charArray("" +
                "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]"))).isFalse();
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> checker = new HashSet<>();
        // 1. rows, cols
        for (int i = 0; i < 9; i++) {
            checker.clear();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (!checker.add(c) && c != '.')
                    return false;
            }
            checker.clear();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (!checker.add(c) && c != '.')
                    return false;
            }

        }

        // 3. boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                checker.clear();
                for (int y = 0; y < 3; y++) {
                    for (int x = 0; x < 3; x++) {
                        char c = board[i + y][j + x];
                        if (!checker.add(c) && c != '.') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
