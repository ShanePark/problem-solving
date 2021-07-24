package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.List;

public class U_FriendsFourBlock3 {

	public static void main(String[] args) {
		System.out.println(solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
		System.out.println(solution(6,6,new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
		System.out.println(solution(4,4,new String[]{"AAAA", "BBBB", "CCCC", "AAAA"}));

	}
	
	  public static int solution(int m, int n, String[] board) {
		  
		  char[][] charBoard = new char[m][n];
		  
		  for(int i=0; i<m; i++) {
			  for(int j=0; j<n; j++) {
				  charBoard[i][j] = board[i].charAt(j);
			  }
		  }
		  
		  int game = 0;
		  int sum = 0;
		  do {
			  game = game(m,n,charBoard);
			  sum += game;
		  }while(game >0);
		
		  return sum;
	  }
	  
	  public static int game(int m, int n, char[][] charBoard) {
		  int count = 0;
		  boolean[][] check = new boolean[m][n];
		  for(int i=0; i<m-1; i++) {
			  for(int j=0; j<n-1; j++) {
				  if(charBoard[i][j] == '@') {
					  continue;
				  }
				  if(charBoard[i][j+1] == charBoard[i][j] && charBoard[i+1][j] == charBoard[i][j] && charBoard[i+1][j+1]==charBoard[i][j]) {
					  check[i][j] = true;
					  check[i][j+1] = true;
					  check[i+1][j] = true;
					  check[i+1][j+1] = true;
				  }
			  }
		  }
		  
		  for(int i=0; i<n; i++) {
			  List<Character> temp = new ArrayList<>();
			  for(int j=m-1; j>=0; j--) {
				  if(check[j][i] == true) {
					  count++;
					  continue;
				  }
				  temp.add(charBoard[j][i]);
			  }
			  for(int j=m-1,k=0; j>=0; j--,k++) {
				  if(k<temp.size()) {
					  charBoard[j][i] = temp.get(k);
				  }else {
					  charBoard[j][i]='@';
				  }
			  }
		  }
		  
		  return count;
		  
	  }
	    

}




