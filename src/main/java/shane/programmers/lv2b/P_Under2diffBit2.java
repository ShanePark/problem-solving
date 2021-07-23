package shane.programmers.lv2b;

import java.util.Arrays;

public class P_Under2diffBit2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new long[] {2,7})));

	}
	
    public static long[] solution(long[] numbers) {
    	final int length = numbers.length;
        long[] answer = new long[length];
        for(int i=0; i<length; i++) {
        	answer[i] = fx(numbers[i]);
        }
        
        return answer;
    }
    
    public static long fx(long number) {
    	if(number % 2 == 0) {
    		return number + 1;
    	}
    	int shift = 0;
    	long temp = number;
    	while(temp %2 != 0) {
    		temp = temp >> 1;
    		shift++;
    	}
    	
    	return (long) (number + Math.pow(2, shift-1));
    	
    }

}
