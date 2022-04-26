package shane.programmers.lv2c;

public class Landlord3 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));//16
		System.out.println(solution(new int[][] {{1,1,1,1}, {2,2,2,3}, {3,3,3,6}, {4,4,4,7}}));//14
		System.out.println(solution(new int[][] {{1,2,3,5},{5,6,7,100},{4,3,2,1}}));
	}
	
    static int solution(int[][] land) {
    	int answer = 0;
    	final int length = land.length;
    	
    	for(int i=1; i<length; i++) {
    		land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]);
    		land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]);
    		land[i][2] += max(land[i-1][1], land[i-1][3], land[i-1][0]);
    		land[i][3] += max(land[i-1][1], land[i-1][2], land[i-1][0]);
    	}
    	
    	for(int number : land[length-1]) {
    		answer = Math.max(answer, number);
    	}
    	return answer;
    }
    
    static public int max(int a, int b, int c) {
    	return Math.max(Math.max(a, b), c);
    }

}
