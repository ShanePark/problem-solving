package shane.programmers.lv2b;

import java.util.EmptyStackException;
import java.util.Stack;

public class R_RevolveBrackets {

	public static void main(String[] args) {
		R_RevolveBrackets solution = new R_RevolveBrackets();
//		System.out.println(solution.solution("[](){}"));
//		System.out.println(solution.solution("}]()[{"));
//		System.out.println(solution.solution("[)(]"));
//		System.out.println(solution.solution("}}}"));
		System.out.println(solution.isCorrect("{[}]"));;

	}
	
    public int solution(String s) {
        int answer = 0;
        final int length = s.length();
        for(int i=0; i<length; i++) {
        	StringBuffer sb = new StringBuffer(s.substring(i, length));
        	sb.append(s.substring(0,i));
        	answer = isCorrect(sb.toString()) ? answer+1 : answer; 
        }
        return answer;
    }
    
    public boolean isCorrect(String s) {
    	final int length = s.length();
    	if(length % 2 != 0)
    		return false;
    	
    	Stack<Integer> smallBracket = new Stack<>();
    	Stack<Integer> middleBracket = new Stack<>();
    	Stack<Integer> BigBracket = new Stack<>();
    	
    	try {
			for(int i=0; i<length; i++ ) {
				char temp = s.charAt(i);
				int popIndex = -1;
				switch(temp) {
				case '(':
					smallBracket.add(i);
					break;
				case ')' :
					popIndex = smallBracket.pop();
					break;
				case '{':
					middleBracket.add(i);
					break;
				case '}' :
					popIndex = middleBracket.pop();
					break;
				case '[':
					BigBracket.add(i);
					break;
				case ']' :
					popIndex = BigBracket.pop();
					break;
				}
				if(popIndex >0 && (popIndex - i-1)%2 != 0) {
					return false;
				}
			}
    	}catch(EmptyStackException e){
    		return false;
    	}
    	
    	if(smallBracket.size() + middleBracket.size() + BigBracket.size() == 0) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }

}
