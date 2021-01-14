package lv2;

import java.util.Arrays;

public class StockPrice {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution((new int[]{1, 2, 3, 2, 3}))));

	}
	
    static public int[] solution(int[] prices) {
    	final int SIZE = prices.length;
        int[] answer = new int[SIZE];
        for(int i=0; i<SIZE; i++ ) {
        	for(int j=i+1; j<SIZE; j++) {
        		answer[i]++;
        		if(prices[i] > prices[j])
        			break;
        	}
        		
        }
        return answer;
    }

}
