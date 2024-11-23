package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime9msBeats57.72%
 */
public class Q1861RotatingtheBox {

    @Test
    public void test() {
        assertThat(rotateTheBox(Ps.charArray("[[\"#\",\"#\",\"*\",\".\",\"*\",\".\"],\n" +
                "              [\"#\",\"#\",\"#\",\"*\",\".\",\".\"],\n" +
                "              [\"#\",\"#\",\"#\",\".\",\"#\",\".\"]]")))
                .isEqualTo(Ps.charArray("[[\".\",\"#\",\"#\"],\n" +
                        "         [\".\",\"#\",\"#\"],\n" +
                        "         [\"#\",\"#\",\"*\"],\n" +
                        "         [\"#\",\"*\",\".\"],\n" +
                        "         [\"#\",\".\",\"*\"],\n" +
                        "         [\"#\",\".\",\".\"]]"));
        assertThat(rotateTheBox(Ps.charArray("[[\"#\",\".\",\"*\",\".\"],\n" +
                "              [\"#\",\"#\",\"*\",\".\"]]")))
                .isEqualTo(Ps.charArray("[[\"#\",\".\"],\n" +
                        "         [\"#\",\"#\"],\n" +
                        "         [\"*\",\"*\"],\n" +
                        "         [\".\",\".\"]]"));
    }

    public char[][] rotateTheBox(char[][] box) {
        char[][] rotated = new char[box[0].length][box.length];
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[0].length; j++) {
                rotated[i][j] = box[rotated[0].length - 1 - j][i];
            }
        }
        for (int j = 0; j < rotated[0].length; j++) {
            int stone = 0;
            for (int i = 0; i < rotated.length; i++) {
                char c = rotated[i][j];
                if (c == '.')
                    continue;
                if (c == '#') {
                    stone++;
                    rotated[i][j] = '.';
                    continue;
                }
                moveDown(rotated, i, j, stone);
                stone = 0;
            }
            moveDown(rotated, rotated.length, j, stone);
        }

        return rotated;
    }

    void moveDown(char[][] arr, int i, int j, int cnt) {
        for (; cnt > 0; cnt--) {
            arr[--i][j] = '#';
        }
    }

}
