package shane.programmers.lv3;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.04ms, 72.3MB)
테스트 2 〉	통과 (0.03ms, 59.3MB)
테스트 3 〉	통과 (0.03ms, 59.7MB)
테스트 4 〉	통과 (0.04ms, 69.5MB)
테스트 5 〉	통과 (0.06ms, 71.5MB)
테스트 6 〉	통과 (0.03ms, 70.3MB)
테스트 7 〉	통과 (0.04ms, 69.8MB)
테스트 8 〉	통과 (0.03ms, 59.4MB)
테스트 9 〉	통과 (0.03ms, 71.3MB)
테스트 10 〉	통과 (0.03ms, 73MB)
효율성  테스트
테스트 1 〉	실패 (0.58ms, 52.2MB)
테스트 2 〉	실패 (0.23ms, 52.6MB)
테스트 3 〉	실패 (0.27ms, 52.2MB)
테스트 4 〉	실패 (0.41ms, 52.4MB)
테스트 5 〉	실패 (0.45ms, 52.2MB)
테스트 6 〉	실패 (0.46ms, 52.5MB)
테스트 7 〉	실패 (0.28ms, 52.3MB)
테스트 8 〉	실패 (0.42ms, 52MB)
테스트 9 〉	실패 (0.44ms, 52.3MB)
테스트 10 〉	실패 (0.41ms, 52.7MB)
채점 결과
정확성: 50.0
효율성: 0.0
합계: 50.0 / 100.0
 */
public class GoToSchool {

	public static void main(String[] args) {
		System.out.println(solution(4,3,new int[][] {{2,2}}));

	}
	
    public static int solution(int m, int n, int[][] puddles) {
    	// false if you can pass
    	boolean[][] puddleMap = new boolean[n][m];
    	int[][] memo = new int[n][m];
    	
    	for(int i=0; i<puddles.length; i++) {
    		puddleMap[puddles[i][1]-1][puddles[i][0]-1] = true;
    	}
    	
    	// 첫 row 에 1 넣기
    	for(int i=0; i<m; i++) {
    		if(puddleMap[0][i] == true)
    			break;
    		memo[0][i] = 1;
    	}
    	// 첫 column에 1 넣기
    	for(int i=0; i<n; i++) {
    		if(puddleMap[i][0] == true){
    			break;
    		}
    		memo[i][0] = 1;
    	}
    	
    
    	
    	for(int i=1; i<n; i++) {
    		for(int j=1; j<m; j++ ) {
    			if(puddleMap[i][j] == false) {
    				memo[i][j] = memo[i][j-1] + memo[i-1][j];
    			}
    		}
    	}
    	
    	return memo[n-1][m-1] % 1000000007;
    }

}






