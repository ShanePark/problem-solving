package shane.programmers.lv2b;

public class Z_JumpAndTeleport {

	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(5000));

	}
	
    public static int solution(int n) {
    	
    	String binary = Integer.toBinaryString(n);
    	int answer = 0;
    	final int length = binary.length();
    	for(int i=0; i<length; i++) {
    		if(binary.charAt(i) == '1') {
    			answer++;
    		}
    	}
        
        return answer;
    }

}
