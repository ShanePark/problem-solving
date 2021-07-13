package lv2b;

public class E_brackets {
	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
		System.out.println(solution(")("));
		System.out.println(solution("()))((()"));
	}
	
    public static String solution(String p) {
    	
    	if(isCorrectString(new StringBuffer(p))) {
    		return p;
    	}
    	
    	final int length = p.length();
    	int left  = 0;
    	int right = 0;
    	for(int i=0; i<length; i++) {
    		if(p.charAt(i) == '(') {
    			left++;
    		}else {
    			right++;
    		}
    		if(left == right && 0<i) {
    			break;
    		}
    	}
    	
    	StringBuffer u = new StringBuffer(p.substring(0,left+right));
    	StringBuffer v = new StringBuffer(p.substring(left+right));
    	if(isCorrectString(u)) {
    		v = new StringBuffer(solution(v.toString()));
    		return u.append(v).toString();
    	}else {
    		StringBuffer newSb = new StringBuffer();
    		newSb.append("(");
    		v = new StringBuffer(solution(v.toString()));
    		newSb.append(v);
    		newSb.append(")");
    		u.deleteCharAt(0);
    		u.deleteCharAt(u.length()-1);
    		newSb.append(reverseBrackets(u));
    		return newSb.toString();
    	}
    	
    }
    
    public static boolean isCorrectString(StringBuffer sb) {
    	int left = 0;
    	
    	final int length = sb.length();
    	for(int i=0; i<length; i++) {
    		if(sb.charAt(i) == '(') {
    			left++;
    		}else {
    			left--;
    		}
    		if(left <0)
    			return false;
    	}
    	
    	return true;
    }
    
    public static StringBuffer reverseBrackets(StringBuffer sb) {
    	
    	final int length = sb.length();
    	char[] arr = new char[length];
    	
    	for(int i=0; i<length; i++) {
    		char reverse = sb.charAt(i) == '(' ? ')' : '(';
    		arr[i] = reverse;
    	}
    	
    	return new StringBuffer(new String(arr));
    }

}










