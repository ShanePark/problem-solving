package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.List;

public class B_MaximizeExpression {
	
	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
		System.out.println(solution("50*6-3*2"));
	}
	
    public static long solution(String expression) {
    	String[] priority = {"*+-","*-+","+*-","+-*","-*+","-+*"};
    	
    	List<String> components = new ArrayList<>();
    	int length = expression.length();
    	StringBuffer sb = new StringBuffer();
    	for(int i=0; i<length; i++) {
    		char c = expression.charAt(i);
    		if('0' <= c && c <= '9') {
    			sb.append(c);
    		}else {
    			components.add(sb.toString());
    			components.add(String.valueOf(c));
    			sb = new StringBuffer();
    		}
    	}
    	components.add(sb.toString());
    	
    	long answer = 0;
    	for(String str : priority) {
    		long number = calc(components, str);
    		if(Math.abs(number) > answer) {
    			answer = Math.abs(number);
    		}
    	}
    	
        return answer;
    }
    
    static long calc(List<String> components, String priority) {
    	List<String> copy = new ArrayList<>();
    	copy.addAll(components);
    	
    	for(int i=0; i<3; i++) {
    		String operator = String.valueOf(priority.charAt(i));
    		while(copy.contains(operator)) {
    			int index = copy.indexOf(operator);
    			String number = operate(copy.get(index-1), operator , copy.get(index+1));
    			copy.add(index-1, number);
    			copy.remove(index);
    			copy.remove(index);
    			copy.remove(index);
    		}
    	}
    	return Long.parseLong(copy.get(0));
    	
    }
    
    static String operate(String left, String operator, String right) {
    	long result = 0L;
    	long l1 = Long.parseLong(left);
    	long l2 = Long.parseLong(right);
    	switch(operator) {
    	case "+":
    		result = l1 + l2;
    		break;
    	case "-":
    		result = l1 - l2;
    		break;
    	case "*":
    		result = l1 * l2;
    		break;
    	}
    	return String.valueOf(result);
    }

}









