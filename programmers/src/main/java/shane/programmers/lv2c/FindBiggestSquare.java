package shane.programmers.lv2c;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.12ms, 52.3MB)
테스트 2 〉	통과 (0.11ms, 52.1MB)
테스트 3 〉	통과 (0.69ms, 52.4MB)
테스트 4 〉	실패 (1.40ms, 52.7MB)
테스트 5 〉	통과 (1.29ms, 52.1MB)
테스트 6 〉	실패 (0.16ms, 52.3MB)
테스트 7 〉	통과 (0.16ms, 52.4MB)
테스트 8 〉	통과 (0.03ms, 53MB)
테스트 9 〉	실패 (0.40ms, 51.7MB)
테스트 10 〉	통과 (0.51ms, 52MB)
테스트 11 〉	통과 (0.31ms, 52.7MB)
테스트 12 〉	실패 (0.29ms, 51.8MB)
테스트 13 〉	실패 (0.22ms, 51.7MB)
테스트 14 〉	실패 (0.18ms, 52.5MB)
테스트 15 〉	실패 (0.49ms, 52.7MB)
테스트 16 〉	실패 (0.40ms, 52.4MB)
테스트 17 〉	실패 (0.83ms, 52.3MB)
테스트 18 〉	통과 (15.26ms, 53MB)
테스트 19 〉	실패 (4.15ms, 52.6MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
채점 결과
정확성: 28.2
효율성: 0.0
합계: 28.2 / 100.0
 */
public class FindBiggestSquare {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
		System.out.println(solution(new int[][]{{0,0,1,1},{1,1,1,1}}));
	}
	
    public static int solution(int [][]board) {
        int max = 0;
        final int width = board[0].length;
        final int height = board.length;
        
        for(int j=0; j<height; j++) {
        	for(int i=0; i<width; i++) {
//        		System.out.println("j: " + j + ", i: " + i + ", size : " + square(j, i, board, width, height));
        		max = Math.max(max, square(j, i, board, width, height));
        	}
        }

        return max;
    }
    
    public static int square(int y, int x, int[][] board, int width, int height) {
    	int length = 0;
    	try {
    		loop:while(true) {
    			for(int i=0; i<length; i++) {
    				if(board[y+i][x] == 0 || board[y][x+i] == 0) {
//    					System.out.println("y:" + y + ", x:" + x + ", length: " + length + ", i :" + i);
    					break loop;
    				}
    			}
    			if(board[y+length][x+length] == 0) {
    				break;
    			}
    			length++;
    		}
    	}catch (ArrayIndexOutOfBoundsException e) {
//    		System.out.println("exception");
    	}
    	
    	return length*length;
    }

}




