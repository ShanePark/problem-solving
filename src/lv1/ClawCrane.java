package lv1;

import java.util.ArrayList;
/*   board															moves			result
	[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
 *  */
public class ClawCrane {
	public static void main(String[] args) {
		int[][] board = {	{0,0,0,0,0},
							{0,0,1,0,3},
							{0,2,5,0,1},
							{4,2,4,4,2},
							{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(new Claw().solutionC(board,moves));
	}
}

class Claw {
    public int solutionC(int[][] board, int[] moves) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int answer = 0;
    	for(int i=0; i<moves.length; i++){
    		
    		for(int j=0; j<board.length; j++){
    			if(board[j][moves[i]-1] != 0){
    				list.add(board[j][moves[i]-1]);
    				board[j][moves[i]-1]=0;
    				if(list.size()>=2 && list.get(list.size()-1)==list.get(list.size()-2)){
    					list.remove(list.size()-1);
    					list.remove(list.size()-1);
    					answer += 2;
    				}
    				break;
    			}
    		}
    	}
    	
    	
        return answer;
    }
}