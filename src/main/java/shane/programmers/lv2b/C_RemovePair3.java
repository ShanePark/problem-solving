package shane.programmers.lv2b;

import java.util.Stack;

/**
 * @author shane
 * stack was the way to solve!
 *
 */
public class C_RemovePair3 {
	
	public static void main(String[] args) {
		
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
		
	}
	
    public static int solution(String s){
    	
    	Stack<Character> stack = new Stack<>();
    	
    	int length = s.length();
    	for(int i=0; i<length; i++) {
    		if(stack.size()>0 && stack.peek() == s.charAt(i)) {
    			stack.pop();
    		}else {
    			stack.add(s.charAt(i));
    		}
    	}
    	
    	return stack.size() == 0 ? 1 : 0; 
    	
    }
 

}
