package lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class I_LempeiZivWelch {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("KAKAO")));
		System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
		System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
	}
	
    public static int[] solution(String msg) {
    	
    	int length = msg.length();
    	
    	List<Integer> answer = new ArrayList<>();
    	List<String> dictionary = new ArrayList<>();
    	
    	dictionary.add("%");
    	for(int i='A'; i<='Z'; i++) {
    		dictionary.add(String.valueOf((char)i));
    	}
    	
    	StringBuffer sb = new StringBuffer();
    	int i = 0;
    	while(i < length) {
    		sb.append(String.valueOf(msg.charAt(i)));
    		int index = dictionary.indexOf(sb.toString());
    		if(index < 0) {
    			dictionary.add(sb.toString());
    			String before = sb.substring(0,sb.length()-1);
    			answer.add(dictionary.indexOf(before));
    			sb.delete(0, sb.length());
    		}else {
				i++;
    		}
    	}
    	
    	answer.add(dictionary.indexOf(sb.toString()));
    	final int size = answer.size();
    	int[] result = new int[size];
    	for(i=0; i<size; i++) {
    		result[i] = answer.get(i);
    	}
    	
        return result;
    }
    
}













