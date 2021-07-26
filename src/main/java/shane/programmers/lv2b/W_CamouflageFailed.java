package shane.programmers.lv2b;

import java.util.HashMap;
import java.util.Map;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	실패 (0.07ms, 52.5MB)
테스트 2 〉	통과 (0.05ms, 52.7MB)
테스트 3 〉	실패 (0.08ms, 52.1MB)
테스트 4 〉	실패 (0.09ms, 52.8MB)
테스트 5 〉	실패 (0.07ms, 52.1MB)
테스트 6 〉	실패 (0.08ms, 51.9MB)
테스트 7 〉	실패 (0.07ms, 52MB)
테스트 8 〉	실패 (0.11ms, 53.4MB)
테스트 9 〉	실패 (0.05ms, 52.5MB)
테스트 10 〉	실패 (0.04ms, 52.3MB)
테스트 11 〉	실패 (0.06ms, 52.7MB)
테스트 12 〉	실패 (0.10ms, 53.3MB)
테스트 13 〉	실패 (0.06ms, 52.4MB)
테스트 14 〉	실패 (0.06ms, 52.1MB)
테스트 15 〉	통과 (0.05ms, 52.5MB)
테스트 16 〉	통과 (0.03ms, 53.5MB)
테스트 17 〉	통과 (0.08ms, 52MB)
테스트 18 〉	실패 (0.06ms, 52MB)
테스트 19 〉	실패 (0.07ms, 52.1MB)
테스트 20 〉	통과 (0.06ms, 53.1MB)
테스트 21 〉	통과 (0.05ms, 52.5MB)
테스트 22 〉	통과 (0.07ms, 52.1MB)
테스트 23 〉	실패 (0.05ms, 52MB)
테스트 24 〉	실패 (0.07ms, 51.6MB)
테스트 25 〉	실패 (0.05ms, 52.6MB)
테스트 26 〉	실패 (0.08ms, 53MB)
테스트 27 〉	통과 (0.06ms, 53.4MB)
테스트 28 〉	실패 (0.05ms, 52MB)
채점 결과
정확성: 28.6
합계: 28.6 / 100.0
 */
public class W_CamouflageFailed {

	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}
	
    public static int solution(String[][] clothes) {
    	final int length = clothes.length;
    	Map<String, Integer> types = new HashMap<>();
    	for(int i=0; i<length; i++) {
    		String type = clothes[i][1];
    		if(types.get(type) == null) {
    			types.put(type, 1);
    		}else {
    			types.put(type, types.get(type)+1);
    		}
    	}
    	
    	int mul = 1;
    	for(String key : types.keySet()) {
    		mul *= types.get(key);
    	}
    	
    	if(types.size() == 1) {
    		return length;
    	}
    	
        return mul + length;
    }

}
