package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.List;

/**
정확성  테스트
테스트 1 〉	통과 (0.28ms, 52.5MB)
테스트 2 〉	통과 (0.35ms, 52.1MB)
테스트 3 〉	통과 (0.15ms, 51.7MB)
테스트 4 〉	통과 (9.02ms, 52.4MB)
테스트 5 〉	통과 (104.21ms, 57.9MB)
테스트 6 〉	통과 (17.84ms, 52.4MB)
테스트 7 〉	통과 (2.89ms, 52.8MB)
테스트 8 〉	통과 (5.09ms, 52.4MB)
테스트 9 〉	통과 (0.62ms, 52.9MB)
테스트 10 〉	통과 (4.69ms, 52.5MB)
테스트 11 〉	실패 (8.12ms, 53.1MB)
채점 결과
정확성: 90.9
합계: 90.9 / 100.0
 *
 */
public class U_FriendsFourBlock {

	public static void main(String[] args) {
		System.out.println(solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
		System.out.println(solution(6,6,new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));

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
        	List<Integer> intList = new ArrayList<>();
        	deleteList.add(intList);
        }
    	
    	int sum = 0;

    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			Character leftTop=' ';
    			Character top=' ';
    			Character rightTop=' ';
    			Character left=' ';
    			Character self=boardList.get(i).get(j);
    			Character right=' ';
    			Character leftBottom=' ';
    			Character bottom=' ';
    			Character rightBottom=' ';
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
    			
    			if( (leftTop==top && top==self && self==left && left!=' ') 
    				|| (top==rightTop && rightTop==right && right==self&& self!=' ')
    				|| (left==leftBottom && leftBottom == bottom && bottom==self && self!=' ')
    				|| (rightBottom==bottom && bottom==self && self==right && right!=' ')) {
    				deleteList.get(i).add(j);
    			}
    			
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		List<Integer> list = deleteList.get(i);
    		int deleteCount = 0;
    		for(int j=0; j<list.size(); j++) {
    			boardList.get(i).remove((int)list.get(j)-deleteCount);
    			deleteCount++;
    		}
    		for(int j=0; j<deleteCount; j++) {
    			boardList.get(i).add(' ');
    		}
    		sum += deleteCount;
    	}
    	
    	
    	return sum;
    	
    }

}




