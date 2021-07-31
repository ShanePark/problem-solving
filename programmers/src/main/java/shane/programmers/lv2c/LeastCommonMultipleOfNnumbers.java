package shane.programmers.lv2c;

public class LeastCommonMultipleOfNnumbers {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,6,8,14}));

	}
	
    public static int solution(int[] arr) {
        int max = 0;
        for(int n : arr) {
        	max = Math.max(n, max);
        }
        
        while(true) {
        	boolean flag = true;
        	for(int n : arr) {
        		if(max % n != 0) {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) {
        		return max;
        	}
        	
        	max++;
        	
        }
        
    }
	
}
