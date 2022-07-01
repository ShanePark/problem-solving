package shane.programmers.challenge2021.naverwebtoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programming2 {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("abcxyasdfasdfxyabc")));
		System.out.println(Arrays.toString(solution("abcxyqwertyxyabc")));
		System.out.println(Arrays.toString(solution("abcabcabcabc")));
		System.out.println(Arrays.toString(solution("llttaattll")));
		System.out.println(Arrays.toString(solution("zzzzzz")));
		System.out.println(Arrays.toString(solution("abcdef")));
	}
	
    public static String[] solution(String s) {
    	List<String> list = new ArrayList<>();
    	
    	while(s!= null && s.length() > 0) {
    		s = container(s, list);
    	}
    	
    	final int size = list.size();
    	String[] answer = new String[size];
    	for(int i=0; i<size; i++ ) {
    		answer[i] = list.get(i);
    	}
    	
        return answer;
    }
    
    public static String container(String text, List<String> list) {
    	int length = text.length();
    	String key = "";
    	int index = 0;
    	boolean flag= false;
    	for(int i=1; i<=length/2; i++) {
    		key = text.substring(0,i);
    		if(key.equals(text.substring(length-i))) {
    			index = i;
    			flag = true;
    			break;
    		}
    	}
    	if(flag == false) {
    		list.add(list.size()/2,text);
    		return null;
    	}else {
    		list.add(list.size()/2, key);
    		list.add(list.size()/2, key);
    		return text.substring(index, length-index);
    	}
    }

}



















