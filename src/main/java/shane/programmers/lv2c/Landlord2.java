package shane.programmers.lv2c;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	실패 (2.94ms, 53.6MB)
테스트 2 〉	실패 (2.95ms, 52.2MB)
테스트 3 〉	실패 (2.93ms, 53MB)
테스트 4 〉	실패 (3.00ms, 52.9MB)
테스트 5 〉	실패 (2.33ms, 53MB)
테스트 6 〉	실패 (2.92ms, 52.1MB)
테스트 7 〉	실패 (2.58ms, 52.6MB)
테스트 8 〉	실패 (2.77ms, 53.1MB)
테스트 9 〉	실패 (2.77ms, 56.1MB)
테스트 10 〉	실패 (2.75ms, 52.9MB)
테스트 11 〉	실패 (2.95ms, 53MB)
테스트 12 〉	실패 (2.56ms, 52.4MB)
테스트 13 〉	실패 (2.73ms, 54.1MB)
테스트 14 〉	실패 (2.65ms, 52.8MB)
테스트 15 〉	실패 (2.98ms, 52.5MB)
테스트 16 〉	실패 (2.59ms, 53.4MB)
테스트 17 〉	실패 (2.88ms, 53.1MB)
테스트 18 〉	실패 (2.99ms, 53.1MB)
효율성  테스트
테스트 1 〉	실패 (22.21ms, 86.2MB)
테스트 2 〉	실패 (22.05ms, 85.4MB)
테스트 3 〉	실패 (30.94ms, 86.3MB)
테스트 4 〉	실패 (32.84ms, 86.3MB)
채점 결과
정확성: 0.0
효율성: 0.0
합계: 0.0 / 100.0
 */
public class Landlord2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));//16
		System.out.println(solution(new int[][] {{1,1,1,1}, {2,2,2,3}, {3,3,3,6}, {4,4,4,7}}));//14

	}
	
    static int solution(int[][] land) {
  	int length = land.length;
    	
    	int sum = 0;
    	int current = -1;
    	for(int i=0; i<length; i++) {
    		int temp = 0;
    		int tempMax = 0;
    		if(i < length-2) {
    			for(int j=0; j<4; j++) {
    				if(current == j) continue;
    				for(int k=0; k<4; k++) {
    					if(j == k) continue;
    					for(int l=0; l<4; l++) {
    						if(k == l) continue;
    						if(land[i][j]+land[i+1][k]+land[i+2][l] > tempMax) {
    							tempMax = land[i][j]+land[i+1][k]+land[i+2][l];
    							temp = j;
    						}
    					}
    				}
    			}
    		}else if(i == length - 1) {
    			int[] arr = land[i];
    			for(int l=0; l<4; l++) {
    				if(tempMax < arr[l]) {
    					temp = l;
    					tempMax = arr[l];
    				}
    			}
    		}else {
    			for(int j=0; j<4; j++) {
    				if(current == j) continue;
    				for(int k=0; k<4; k++) {
    					if(j == k) continue;
    					if(land[i][j]+land[i+1][k] > tempMax) {
    						tempMax = land[i][j]+land[i+1][k];
    						temp = j;
    					}
    				}
    			}
    		}
    		current = temp;
    		sum += land[i][current];
    	}
    	
        return sum;
    }
    

}
