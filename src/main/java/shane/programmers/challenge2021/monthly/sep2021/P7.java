package shane.programmers.challenge2021.monthly.sep2021;

import io.github.shanepark.Ps;

public class P7 {

    public static void main(String[] args) {
        System.out.println(solution(2, 2, 0, 0, Ps.intArray("[[2,1],[0,1],[1,1],[0,1],[2,1]]")) == 4);
        System.out.println(solution(2, 5, 0, 1, Ps.intArray("[[3,1],[2,2],[1,1],[2,3],[0,1],[2,1]]")) == 2);
    }

    public static long solution(int n, int m, int x, int y, int[][] queries) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int px = i;
                int py = j;
                int[] location = null;
                for (int[] query : queries) {
                    location = calcQuery(n, m, px, py, query);
                    px = location[0];
                    py = location[1];
                }
                if (px == x && py == y) count++;
            }
        }
        return count;
    }

    private static int[] calcQuery(int n, int m, int x, int y, int[] query) {
        int[] move = new int[2];
        switch (query[0]) {
            case 0:
                move[0] = 0;
                move[1] = -query[1];
                break;
            case 1:
                move[0] = 0;
                move[1] = query[1];
                break;
            case 2:
                move[0] = -query[1];
                move[1] = 0;
                break;
            case 3:
                move[0] = query[1];
                move[1] = 0;
                break;
        }
        int newX = x + move[0];
        if (newX < 0) newX = 0;
        if (newX > n - 1) newX = n - 1;
        int newY = y + move[1];
        if (newY < 0) newY = 0;
        if (newY > m - 1) newY = m - 1;
        return new int[]{newX, newY};
    }

}
