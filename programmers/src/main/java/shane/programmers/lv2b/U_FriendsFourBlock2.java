package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.List;

public class U_FriendsFourBlock2 {

	public static void main(String[] args) {
		System.out.println(solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
		System.out.println(solution(6,6,new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
		System.out.println(solution(4,4,new String[]{"AAAA", "BBBB", "CCCC", "AAAA"}));

	}
	
	  public static int solution(int m, int n, String[] board) {
	        List<List<Character>> boardList = new ArrayList<>();
	        for(int i=0; i<n; i++) {
	        	List<Character> charList = new ArrayList<>();
	        	boardList.add(charList);
	        }
	        
	        // make lists with the board
	        for(int i=0; i<m; i++) {
	        	String str = board[m-i-1];
	        	for(int j=0; j<n; j++) {
	        		boardList.get(j).add(str.charAt(j));
	        	}
	        }
	        
	        int gameResult = 0;
	        int sum = 0;
	        while((gameResult=game(boardList)) > 0) {
	        	sum += gameResult;
	        }
	        
	        return sum;
	    }
	    
	    public static int game(List<List<Character>> boardList) {
	    	List<List<Integer>> deleteList = new ArrayList<>();
	    	int n = boardList.size();
	    	int m = boardList.get(0).size();
	    	for(int i=0; i<n; i++) {
	        	deleteList.add(new ArrayList<>());
	        }
	    	
	    	int sum = 0;
	    	for(int i=0; i<n; i++) {
	    		for(int j=0; j<m; j++) {
	    			Character leftTop = null;
	    			Character top= null;
	    			Character rightTop= null;
	    			Character left= null;
	    			Character self=boardList.get(i).get(j);
	    			Character right= null;
	    			Character leftBottom= null;
	    			Character bottom= null;
	    			Character rightBottom= null;
	    			// check top
	    			if(i<n-1) {
	    				top = boardList.get(i+1).get(j);
	    				if(j>0) {
	    					leftTop = boardList.get(i+1).get(j-1);
	    				}
	    				if(j<m-1) {
	    					rightTop = boardList.get(i+1).get(j+1);
	    				}
	    			}
	    			// checkLeft
	    			if(j>0) {
	    				left = boardList.get(i).get(j-1);
	    				if(i>0) {
	    					leftBottom = boardList.get(i-1).get(j);
	    				}
	    			}
	    			// checkRight
	    			if(j<m-1) {
	    				right = boardList.get(i).get(j+1);
	    				if(i>0) {
	    					rightBottom = boardList.get(i-1).get(j+1);
	    				}
	    			}
	    			// checkBottom
	    			if(i>0) {
	    				bottom = boardList.get(i-1).get(j);
	    			}
	    			
	    			if( (self!='@' && leftTop==top && top==self && self==left) 
	    				|| (self!='@' && top==rightTop && rightTop==right && right==self)
	    				|| (self!='@' && left==leftBottom && leftBottom == bottom && bottom==self)
	    				|| (self!='@' && rightBottom==bottom && bottom==self && self==right)	) {
	    				deleteList.get(i).add(j);
	    				sum++;
	    			}
	    			
	    		}
	    	}
	    	
	    	for(int i=0; i<n; i++) {
	    		List<Integer> list = deleteList.get(i);
	    		int deleteCount = 0;
	    		int size = list.size();
	    		for(int j=0; j<size; j++) {
	    			boardList.get(i).remove(list.get(j)-deleteCount);
	    			deleteCount++;
	    		}
	    		for(int j=0; j<deleteCount; j++) {
	    			boardList.get(i).add('@');
	    		}
	    	}
	    	
	    	return sum;
	    	
	    }

}




