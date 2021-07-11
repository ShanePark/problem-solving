package lv2a;

import java.util.Arrays;

public class V_binaryConvert {
	
	public static void main(String[] args) {
		int[] arr = solution("110010101001");
		System.out.println(Arrays.toString(arr));
	}
	
    public static int[] solution(String s) {
        int[] answer = new int[2];
        
        int convertCount = 0;
        WrapInt zeroCount = new WrapInt();
        
        while(true) {
        	if("1".equals(s)) break;
        	s = binaryConvert(s, zeroCount);
        	convertCount++;
        }
        
        answer[0] = convertCount;
        answer[1] = zeroCount.value;
        
        return answer;
    }
    
    public static String binaryConvert(String s, WrapInt zeroCount) {
    	int length = s.length();
    	StringBuffer sb = new StringBuffer(s);
    	int zeros = 0;
    	for(int i=0; i<length; i++) {
    		if(sb.charAt(i-zeros) == '0') {
    			sb.deleteCharAt(i-zeros);
    			zeros ++;
    		}
    	}
    	
    	length = sb.length();
    	zeroCount.value += zeros;
    	return Integer.toBinaryString(length);
    	
    }

}

class WrapInt{
	int value;
}






