package shane.programmers.challenge2022.kakao2022;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.02ms, 62.3MB)
 * 테스트 2 〉	통과 (0.04ms, 70.1MB)
 * 테스트 3 〉	통과 (0.05ms, 72.3MB)
 * 테스트 4 〉	통과 (0.13ms, 59.2MB)
 * 테스트 5 〉	통과 (0.19ms, 72.8MB)
 * 테스트 6 〉	통과 (0.40ms, 70.4MB)
 * 테스트 7 〉	통과 (0.62ms, 71MB)
 * 테스트 8 〉	통과 (1.13ms, 70.1MB)
 * 테스트 9 〉	통과 (1.28ms, 69.6MB)
 * 테스트 10 〉	통과 (1.91ms, 62.7MB)
 * 효율성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (시간 초과)
 * 테스트 5 〉	실패 (시간 초과)
 * 테스트 6 〉	실패 (시간 초과)
 * 테스트 7 〉	실패 (시간 초과)
 * 채점 완료
 */
public class K6 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
        System.out.println(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}}));
    }

    public static int solution(int[][] board, int[][] skill) {
        for(int[] process : skill){
            int type = process[0];
            int y1 = process[1];
            int x1 = process[2];
            int y2 = process[3];
            int x2 = process[4];
            int degree = process[5] * (type==1 ? -1 : 1);
            for(int i=y1; i<=y2; i++){
                for(int j=x1; j<=x2; j++){
                    board[i][j] += degree;
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] > 0)
                    cnt ++;
            }
        }

        return cnt;
    }

}
