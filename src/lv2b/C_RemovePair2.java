package lv2b;

/**
 * @author shane
 */
public class C_RemovePair2 {
	
	public static void main(String[] args) {
		
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
		
	}
	
    public static int solution(String s){
       
    	StringBuffer sb = new StringBuffer(s);
    	while(true) {
    		int length = sb.length();
    		
    		for(char c='a'; c <= 'z'; c++) {
    			int index = sb.indexOf(String.format("%c%c", c,c));
    			if(index >= 0) {
    				sb.delete(index, index+2);
    			}
    		}
    		
    		if(sb.length() == length) {
    			break;
    		}
    	}
    	
    	return sb.length() == 0? 1: 0;
    	
    }
 

}
