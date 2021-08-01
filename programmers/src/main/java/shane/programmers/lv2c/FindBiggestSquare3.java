package shane.programmers.lv2c;

import java.util.Arrays;

public class FindBiggestSquare3 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
		System.out.println(solution(new int[][]{{0,0,1,1},{1,1,1,1}}));
	}
	
    public static int solution(int [][]board) {
        final int width = board[0].length;
        final int height = board.length;
        
        for(int j=1; j<height; j++) {
        	for(int i=1; i<width; i++) {
        		if(board[j][i] == 1) {
        			board[j][i] = Math.min(board[j-1][i-1], Math.min(board[j][i-1], board[j-1][i])) + 1;
        		}
        	}
        }
        
//        System.out.println(Arrays.deepToString(board));
        
        int max = 0;
        for(int j=0; j<height; j++) {
        	for(int i=0; i<width; i++) {
        		max = Math.max(max, board[j][i]);
        	}
        }
        
        return max*max;
    }
    

}




