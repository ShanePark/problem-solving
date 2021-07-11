package lv2a;

import java.util.Arrays;

public class O_minAndMaxValue {

	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4"));
	}
	
    public static String solution(String s) {
    	String[] arr = s.split(" ");
    	System.out.println(Arrays.toString(arr));
    	int min = Integer.parseInt(arr[0]);
    	int max = min;
    	
    	for(String str : arr) {
    		int number = Integer.parseInt(str);
    		min = min > number ? number : min;
    		max = max < number ? number : max;
    	}
    	
        String answer = min + " " + max;
        return answer;
    }

}
