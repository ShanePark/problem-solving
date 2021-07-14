package lv2b;

public class K_JadenCase {

	public static void main(String[] args) {
		
		System.out.println(solution("3people unFollowed me"));

	}
	
    public static String solution(String s) {
    	StringBuffer sb = new StringBuffer();
    	int length = s.length();
    	
    	
    	// small letter - 32 = upper 
    	for(int i=0; i<length; i++) {
    		char c = s.charAt(i);
    		if('a' <= c && c <= 'z') {
    			if(i==0 || (i>0 && s.charAt(i-1) == ' ')) {
    				c -= 32;
    			}
    		}else if('A' <= c && c <= 'Z') {
    			if(i!=0 && !(i>0 && s.charAt(i-1) == ' ')) {
    				c += 32;
    			}
    		}
    		sb.append(c);
    	}
    	
    	return sb.toString();		
    }

}
