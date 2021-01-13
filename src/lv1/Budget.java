package lv1;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,3,2,5,4}, 9));

	}

	
    static public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for(int num:d) {
        	if(budget >=num) {
        		budget -= num;
        		answer++;
        	}else {
        		return answer;
        	}
        }
        return answer;
    }
    
}
