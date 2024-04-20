package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 82.13% of users with Java
 */
public class Q1992FindAllGroupsOfFarmland {

    @Test
    public void test() {
        assertThat(findFarmland(Ps.intArray("[[1,0,0],[0,1,1],[0,1,1]]"))).isEqualTo(Ps.intArray("[[0,0,0,0],[1,1,2,2]]"));
        assertThat(findFarmland(Ps.intArray("[[1,1],[1,1]]"))).isEqualTo(Ps.intArray("[[0,0,1,1]]"));
        assertThat(findFarmland(Ps.intArray("[[0]]"))).isEqualTo(Ps.intArray("[]"));
    }

    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    farm(land, i, j, list);
                }
            }
        }
        int size = list.size();
        int[][] answer = new int[size][4];
        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    void farm(int[][] land, int y, int x, List<int[]> list) {
        int minX = x;
        int maxX = x;
        int minY = y;
        int maxY = y;

        while (y < land.length - 1 && land[y + 1][x] == 1) {
            y++;
        }
        maxY = y;

        while (x < land[0].length - 1 && land[y][x + 1] == 1) {
            x++;
        }
        maxX = x;

        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                land[i][j] = 0;
            }
        }

        list.add(new int[]{minY, minX, maxY, maxX});
    }

}
