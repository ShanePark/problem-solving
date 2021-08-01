package shane.programmers.lv2c;

import java.util.LinkedList;
import java.util.Queue;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.21ms, 53.2MB)
테스트 2 〉	통과 (0.20ms, 52.8MB)
테스트 3 〉	통과 (0.22ms, 53.1MB)
테스트 4 〉	통과 (0.30ms, 54.2MB)
테스트 5 〉	통과 (0.16ms, 52.2MB)
테스트 6 〉	통과 (0.16ms, 52.2MB)
테스트 7 〉	통과 (0.29ms, 52.2MB)
테스트 8 〉	통과 (0.21ms, 52.3MB)
테스트 9 〉	통과 (0.29ms, 54MB)
테스트 10 〉	통과 (1.35ms, 53.8MB)
테스트 11 〉	실패 (89.53ms, 83.3MB)
테스트 12 〉	통과 (0.67ms, 52.1MB)
테스트 13 〉	통과 (1.28ms, 53.3MB)
테스트 14 〉	통과 (1.44ms, 53.7MB)
테스트 15 〉	실패 (2.47ms, 52.3MB)
테스트 16 〉	통과 (2.99ms, 52.7MB)
테스트 17 〉	통과 (10.78ms, 53.6MB)
테스트 18 〉	실패 (5.08ms, 54.5MB)
테스트 19 〉	실패 (4.03ms, 52.8MB)
테스트 20 〉	실패 (5.92ms, 53.4MB)
채점 결과
정확성: 75.0
합계: 75.0 / 100.0
 */
public class Cache {

	public static void main(String[] args) {
//		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"} ));
//		System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"} ));
		System.out.println(solution(0, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"} ));
	}
	
    public static int solution(int cacheSize, String[] cities) {
    	Queue<String> cache = new LinkedList<>();
    	
    	int answer = 0;
    	for(String str : cities) {
    		if(cache.contains(str.toUpperCase())) {
    			answer++;
    		}else {
    			answer += 5;
    			cache.offer(str.toUpperCase());
    			if(cache.size() > cacheSize) {
    				cache.poll();
    			}
    		}
    	}
        return answer;
    }

}
