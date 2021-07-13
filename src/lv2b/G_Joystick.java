package lv2b;

/**
 * @author shane
 *테스트 11 〉	실패 (0.13ms, 52.5MB)
 */
public class G_Joystick {
	
	public static void main(String[] args) {
		System.out.println(solution("JAZ"));
		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
	}
	
    public static int solution(String name) {
    	
    	final int length = name.length();
    	
    	StringBuffer sb = new StringBuffer();
    	for(int i=0; i<length; i++) {
    		sb.append('A');
    	}
    	StringBuffer sb2 = new StringBuffer(sb);
    	
    	int leftToRight = processChar(name.charAt(0));
    	sb.setCharAt(0, name.charAt(0));
    	// from left to right
    	for(int i=1; i<length; i++) {
    		if(name.equals(sb.toString())) {
    			break;
    		}
    		leftToRight += processChar(name.charAt(i)) + 1;
    		sb.setCharAt(i, name.charAt(i));
    	}
    	
    	// from right to left
    	int rightToLeft = processChar(name.charAt(0));
    	sb2.setCharAt(0, name.charAt(0));
    	for(int i=length-1; 0 < i; i--) {
    		if(name.equals(sb2.toString())) {
    			break;
    		}
    		rightToLeft += processChar(name.charAt(i)) + 1;
    		sb2.setCharAt(i, name.charAt(i));
    	}
    	
        return leftToRight < rightToLeft ? leftToRight : rightToLeft;
    }
    
    public static int processChar(char c) {
    	int number = c - 'A';
    	return number > 13 ? 26 - number : number;
    }
}
