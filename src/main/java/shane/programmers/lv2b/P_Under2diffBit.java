package shane.programmers.lv2b;

import java.util.Arrays;

/**
정확성  테스트
테스트 1 〉	통과 (10.69ms, 53.2MB)
테스트 2 〉	통과 (188.06ms, 101MB)
테스트 3 〉	통과 (2.30ms, 51.7MB)
테스트 4 〉	통과 (6.80ms, 52.8MB)
테스트 5 〉	통과 (12.89ms, 54.4MB)
테스트 6 〉	통과 (11.71ms, 53.2MB)
테스트 7 〉	통과 (191.44ms, 130MB)
테스트 8 〉	통과 (277.10ms, 108MB)
테스트 9 〉	통과 (184.33ms, 143MB)
테스트 10 〉	실패 (시간 초과)
테스트 11 〉	실패 (시간 초과)
채점 결과
정확성: 81.8
합계: 81.8 / 100.0
 */
public class P_Under2diffBit {

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
    	long temp = number+1;
    	while(true) {
    		StringBuffer binaryNumber = new StringBuffer(Long.toBinaryString(number));
    		String tempBinary = Long.toBinaryString(temp);
    		int tempLength = tempBinary.length();
    		if(binaryNumber.length() < tempLength) {
    			binaryNumber.insert(0, "0");
    		}
    		int diffCount = 0;
    		for(int i=0; i<tempLength; i++ ) {
    			if(binaryNumber.charAt(i) != tempBinary.charAt(i)) {
    				diffCount++;
    			}
    			if(diffCount >2) {
    				break;
    			}
    		}
    		if(diffCount <= 2) {
    			return temp;
    		}else {
    			temp++;
    		}
    		
    		
    	}
    }

}
