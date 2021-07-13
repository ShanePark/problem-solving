package lv2b;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D_WordRelay {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"} )));
		System.out.println(Arrays.toString(solution(5,new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
		System.out.println(Arrays.toString(solution(2,new String[] {"hello", "one", "even", "never", "now", "world", "draw"})));
	}
	
    public static int[] solution(int n, String[] words) {
    	
    	int index = game(words);
    	
    	int[] answer = new int[2];
    	
    	if(index != words.length) {
    		answer[0] = index % n + 1;
    		answer[1] = index / n + 1;
    	}
    	
        return answer;
    }
    
    public static int game(String[] words) {
    	Set<String> history = new HashSet<>();
    	history.add(words[0]);
    	
    	final int length = words.length;
    	for(int i=1; i<length; i++){
    		char last = words[i-1].charAt(words[i-1].length()-1);
    		char first = words[i].charAt(0);
    		if(first != last || history.add(words[i]) != true) {
    			break;
    		}
    	}
    	
    	return history.size();
    }

}




