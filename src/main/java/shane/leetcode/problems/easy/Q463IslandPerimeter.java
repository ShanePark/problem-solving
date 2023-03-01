package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;

public class Q463IslandPerimeter {
    public static void main(String[] args) {
        System.out.println(islandPerimeter(Ps.intArray("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]")));
        System.out.println(islandPerimeter(Ps.intArray("[[1]]")));
        System.out.println(islandPerimeter(Ps.intArray("[[0,1]]")));
    }

    public static int islandPerimeter(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cnt += 4;
                    if (0 < i && grid[i - 1][j] == 1)
                        cnt--;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        cnt--;
                    if (0 < j && grid[i][j - 1] == 1)
                        cnt--;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
                        cnt--;
                }
            }
        }
        return cnt;
    }
}
