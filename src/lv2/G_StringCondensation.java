package lv2;

public class G_StringCondensation {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}
	
    static public int solution(String s) {
        int min = s.length();
        for(int i=1; i<=s.length()/2; i++) {
        	int condenseSize = condense(s,i);
        	min = min < condenseSize ? min : condenseSize;
        }
        return min;
        	
    }
    
    static public int condense(String str, int n) {
    	final int length =str.length();
    	final int left = length % n;
    	String temp = "";
    	int count = 0;
    	String compare = "";
    	StringBuffer sb = new StringBuffer();
    	for(int i=0; i<length/n; i++) {
    		compare = str.substring(n*i, n*(i+1));
    		if(temp.equals(compare)) {
    			count++;
    		}else {
    			sb.append(1<count ? count+temp : temp);
    			temp = compare;
    			count = 1;
    		}
    	}
    	sb.append(1<count ? count+temp : temp);
    	return sb.length()+left;
    	
    }

}
