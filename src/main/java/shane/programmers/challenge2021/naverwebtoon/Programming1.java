package shane.programmers.challenge2021.naverwebtoon;

import java.util.Arrays;

public class Programming1 {
	
	public static void main(String[] args) {
		int[] prices = {32000, 18000, 42500};
		int[] discounts = {50, 20, 65} ;
		System.out.println(solution(prices, discounts));
	}
	
	
    public static int solution(int[] prices, int[] discounts) {
    	Arrays.sort(prices);
    	Arrays.sort(discounts);
    	int pricesLength = prices.length;
    	int discountLength = discounts.length;
    	int sum = 0;
    	for(int i=0,j=0; i< pricesLength; i++,j++) {
    		int price = prices[pricesLength-1-i];
    		if(j < discountLength) {
    			price = price * (100 - discounts[discountLength-1-j]) / 100;
    		}
    		sum += price;
    	}
        return sum;
    }

}











