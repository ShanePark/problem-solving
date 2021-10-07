package shane.programmers.monthly.sep2021;

import com.tistory.shanepark.STool;

/**
 * 문제 설명
 * <p>
 * n행 m열의 격자가 있습니다. 격자의 각 행은 0, 1, ..., n-1번의 번호, 그리고 각 열은 0, 1, ..., m-1번의 번호가 순서대로 매겨져 있습니다. 당신은 이 격자에 공을 하나 두고, 그 공에 다음과 같은 쿼리들을 날리고자 합니다.
 * 열 번호가 감소하는 방향으로 dx칸 이동하는 쿼리 (query(0, dx))
 * 열 번호가 증가하는 방향으로 dx칸 이동하는 쿼리 (query(1, dx))
 * 행 번호가 감소하는 방향으로 dx칸 이동하는 쿼리 (query(2, dx))
 * 행 번호가 증가하는 방향으로 dx칸 이동하는 쿼리 (query(3, dx))
 * 단, 공은 격자 바깥으로 이동할 수 없으며, 목적지가 격자 바깥인 경우 공은 이동하다가 더 이상 이동할 수 없을 때 멈추게 됩니다. 예를 들어, 5행 × 4열 크기의 격자 내의 공이 3행 2열에 있을 때 query(3, 10) 쿼리를 받은 경우 공은 4행 2열에서 멈추게 됩니다. (격자의 크기가 5행 × 4열이므로, 0~4번 행과 0~3번 열로 격자가 구성되기 때문입니다.)
 * 격자의 행의 개수 n, 열의 개수 m, 정수 x와 y, 그리고 쿼리들의 목록을 나타내는 2차원 정수 배열 queries가 매개변수로 주어집니다. n × m개의 가능한 시작점에 대해서 해당 시작점에 공을 두고 queries 내의 쿼리들을 순서대로 시뮬레이션했을 때, x행 y열에 도착하는 시작점의 개수를 return 하도록 solution 함수를 완성해주세요.
 * 제한사항
 * 1 ≤ n ≤ 109
 * 1 ≤ m ≤ 109
 * 0 ≤ x < n
 * 0 ≤ y < m
 * 1 ≤ queries의 행의 개수 ≤ 200,000
 * queries의 각 행은 [command,dx] 두 정수로 이루어져 있습니다.
 * 0 ≤ command ≤ 3
 * 1 ≤ dx ≤ 109
 * 이는 query(command, dx)를 의미합니다.
 */
public class P7 {

    public static void main(String[] args) {
        System.out.println(solution(2, 2, 0, 0, STool.convertToIntArray("[[2,1],[0,1],[1,1],[0,1],[2,1]]")) == 4);
        System.out.println(solution(2, 5, 0, 1, STool.convertToIntArray("[[3,1],[2,2],[1,1],[2,3],[0,1],[2,1]]")) == 2);
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
