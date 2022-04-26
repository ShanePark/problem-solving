package shane.programmers.lv2b;

/**
 * @author shane
 *채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.10ms, 52.2MB)
테스트 2 〉	통과 (46.83ms, 52.6MB)
테스트 3 〉	통과 (44.69ms, 52.5MB)
테스트 4 〉	통과 (37.22ms, 53.5MB)
테스트 5 〉	통과 (37.52ms, 53.2MB)
테스트 6 〉	통과 (35.74ms, 53.3MB)
테스트 7 〉	통과 (47.11ms, 53.6MB)
테스트 8 〉	통과 (40.78ms, 54.1MB)
테스트 9 〉	통과 (0.09ms, 52.1MB)
테스트 10 〉	통과 (0.18ms, 53.4MB)
테스트 11 〉	통과 (0.09ms, 51.9MB)
테스트 12 〉	통과 (0.11ms, 52.5MB)
테스트 13 〉	통과 (0.10ms, 52.2MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
채점 결과
정확성: 60.2
효율성: 0.0
합계: 60.2 / 100.0
 */
public class C_RemovePair {
	
	public static void main(String[] args) {
		
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
		
	}
	
    public static int solution(String s){
       
    	StringBuffer sb = new StringBuffer(s);
    	int index = 0;
    	while(index < sb.length()-1 ) {
    		if(sb.charAt(index) == sb.charAt(index+1)) {
    			sb.delete(index, index+2);
    			if(0 < index) {
    				index--;
    			}
    		}else {
    			index++;
    		}
    	}
    	
    	return sb.length() == 0 ? 1 : 0;
    	
    }
 

}
