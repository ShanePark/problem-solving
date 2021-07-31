package shane.programmers.lv2c;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	실패 (0.87ms, 53.2MB)
테스트 2 〉	실패 (0.82ms, 52.8MB)
테스트 3 〉	실패 (0.85ms, 53MB)
테스트 4 〉	실패 (0.90ms, 53.1MB)
테스트 5 〉	실패 (0.83ms, 54.4MB)
테스트 6 〉	실패 (0.91ms, 52.8MB)
테스트 7 〉	실패 (0.91ms, 52.7MB)
테스트 8 〉	실패 (0.87ms, 52.7MB)
테스트 9 〉	실패 (0.84ms, 53.9MB)
테스트 10 〉	실패 (0.84ms, 53.7MB)
테스트 11 〉	실패 (0.86ms, 52.9MB)
테스트 12 〉	실패 (0.83ms, 53.2MB)
테스트 13 〉	실패 (0.83ms, 53.2MB)
테스트 14 〉	실패 (0.84ms, 53MB)
테스트 15 〉	실패 (0.84ms, 53.3MB)
테스트 16 〉	실패 (0.89ms, 52.8MB)
테스트 17 〉	실패 (0.86ms, 53.1MB)
테스트 18 〉	실패 (0.87ms, 53.5MB)
효율성  테스트
테스트 1 〉	실패 (12.36ms, 86.1MB)
테스트 2 〉	실패 (12.97ms, 85.5MB)
테스트 3 〉	실패 (13.58ms, 87MB)
테스트 4 〉	실패 (15.28ms, 86.9MB)
채점 결과
정확성: 0.0
효율성: 0.0
합계: 0.0 / 100.0
 */
public class Landlord {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));

	}
	
    static int solution(int[][] land) {
    	
    	int length = land.length;
    	
    	int sum = 0;
    	int current = -1;
    	for(int i=0; i<length; i++) {
    		int temp = 0;
    		int tempMax = 0;
    		if(i == length - 1) {
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
