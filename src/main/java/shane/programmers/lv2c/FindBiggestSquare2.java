package shane.programmers.lv2c;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.03ms, 52.2MB)
테스트 2 〉	실패 (0.04ms, 52MB)
테스트 3 〉	실패 (0.04ms, 52.5MB)
테스트 4 〉	통과 (0.05ms, 55.7MB)
테스트 5 〉	통과 (0.05ms, 52.4MB)
테스트 6 〉	실패 (0.04ms, 52.9MB)
테스트 7 〉	실패 (0.05ms, 52.5MB)
테스트 8 〉	실패 (0.05ms, 52.6MB)
테스트 9 〉	통과 (0.03ms, 52.3MB)
테스트 10 〉	통과 (0.03ms, 52.3MB)
테스트 11 〉	실패 (0.03ms, 52.3MB)
테스트 12 〉	실패 (0.05ms, 52.6MB)
테스트 13 〉	실패 (0.03ms, 52.3MB)
테스트 14 〉	실패 (0.06ms, 52.1MB)
테스트 15 〉	실패 (0.06ms, 52.9MB)
테스트 16 〉	실패 (0.05ms, 52.6MB)
테스트 17 〉	실패 (0.04ms, 52.3MB)
테스트 18 〉	실패 (0.38ms, 53.4MB)
테스트 19 〉	실패 (0.36ms, 54.1MB)
효율성  테스트
테스트 1 〉	실패 (19.26ms, 89MB)
테스트 2 〉	실패 (21.62ms, 89.4MB)
테스트 3 〉	실패 (19.58ms, 89.7MB)
채점 결과
정확성: 15.7
효율성: 0.0
합계: 15.7 / 100.0
 */
public class FindBiggestSquare2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
		System.out.println(solution(new int[][]{{0,0,1,1},{1,1,1,1}}));
	}
	
    public static int solution(int [][]board) {
        final int width = board[0].length;
        final int height = board.length;
        
        for(int j=1; j<height; j++) {
        	for(int i=1; i<width; i++) {
        		board[j][i] = Math.min(board[j-1][i-1], Math.min(board[j][i-1], board[j-1][i])) + 1;
        	}
        }
        
        int max = 0;
        for(int j=0; j<height; j++) {
        	for(int i=0; i<width; i++) {
        		max = Math.max(max, board[j][i]);
        	}
        }
        
        return max*max;
    }
    

}




