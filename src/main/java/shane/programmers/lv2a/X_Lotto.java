package shane.programmers.lv2a;

import java.util.Arrays;

public class X_Lotto {
	
	public static void main(String[] args) {
		int[] lottos = {7, 8, 9, 10, 31, 25};
		int[] win_nums = {1, 2, 3, 4, 5, 6};
		int[] result = solution( lottos , win_nums );
		
		System.out.println(Arrays.toString(result));
		
	}
	
	
    static public int[] solution(int[] lottos, int[] win_nums) {
    	int zeroCount = 0;
    	int sameCount = 0;
    	Arrays.sort(win_nums);
    	for(int i=0; i<6; i++) {
    		int number = lottos[i];
    		if(number == 0 ) {
    			zeroCount++;
    		}else {
    			if(Arrays.binarySearch(win_nums, number) >= 0) {
    				sameCount++;
    			}
    		}
    		
    	}
    	
    	int minRank = sameCount==0? 6: 7 - sameCount;
    	int maxRank = 7 - sameCount - zeroCount;
    	maxRank = maxRank > 6 ? 6 : maxRank;
    	int[] answer = new int[] {maxRank, minRank};
    	return answer;
    	
    }

}
