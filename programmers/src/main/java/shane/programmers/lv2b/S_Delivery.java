package shane.programmers.lv2b;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (2.51ms, 52.4MB)
테스트 2 〉	통과 (55.99ms, 59.6MB)
테스트 3 〉	통과 (2.58ms, 52.5MB)
테스트 4 〉	통과 (3.38ms, 52.8MB)
테스트 5 〉	통과 (3.58ms, 52.5MB)
테스트 6 〉	통과 (1.38ms, 52.5MB)
테스트 7 〉	통과 (1.79ms, 52.1MB)
테스트 8 〉	통과 (2.80ms, 53.8MB)
테스트 9 〉	통과 (2.16ms, 53MB)
테스트 10 〉	통과 (2.34ms, 52.1MB)
테스트 11 〉	통과 (2.29ms, 53MB)
테스트 12 〉	통과 (40.45ms, 60.4MB)
테스트 13 〉	통과 (18.16ms, 56.6MB)
테스트 14 〉	통과 (41.51ms, 54.5MB)
테스트 15 〉	통과 (58.75ms, 61.4MB)
테스트 16 〉	통과 (24.40ms, 59.4MB)
테스트 17 〉	실패 (시간 초과)
테스트 18 〉	통과 (24.68ms, 53.6MB)
테스트 19 〉	통과 (37.99ms, 59.6MB)
테스트 20 〉	통과 (668.49ms, 115MB)
테스트 21 〉	통과 (48.72ms, 61.2MB)
테스트 22 〉	통과 (32.41ms, 55.2MB)
테스트 23 〉	통과 (7408.69ms, 384MB)
테스트 24 〉	실패 (시간 초과)
테스트 25 〉	통과 (65.02ms, 69.1MB)
테스트 26 〉	통과 (67.10ms, 57.9MB)
테스트 27 〉	실패 (시간 초과)
테스트 28 〉	통과 (129.00ms, 68.9MB)
테스트 29 〉	실패 (시간 초과)
테스트 30 〉	통과 (63.80ms, 68MB)
테스트 31 〉	실패 (시간 초과)
테스트 32 〉	실패 (시간 초과)
채점 결과
정확성: 81.3
합계: 81.3 / 100.0
 *
 */
public class S_Delivery {

	public static void main(String[] args) {
		System.out.println(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}} ,3));
		System.out.println(solution(6,new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}} ,4));

	}
	
    public static int solution(int N, int[][] road, int K) {
        Map<String, Integer> map = new HashMap<>();
        final int roadSize = road.length;
        for(int i=0; i<roadSize; i++) {
        	int[] roadInfo = road[i];
        	int town1 = Math.min(roadInfo[0], roadInfo[1]);
        	int town2 = Math.max(roadInfo[0], roadInfo[1]);
        	String data = String.format("%03d%03d", town1, town2);
        	int distance = roadInfo[2];
        	if(map.containsKey(data)) {
        		distance = Math.min(map.get(data), distance);
        	}
        	map.put(data, distance);
        }
        
        Map<String, Map<String, Integer>> roadMap = new HashMap<>();
        for(String key : map.keySet()) {
        	String town1 = key.substring(0,3);
        	String town2 = key.substring(3,6);
        	int distance = map.get(key);
        	
        	if(roadMap.get(town1) == null) {
        		Map<String, Integer> distanceMap = new HashMap<>();
        		roadMap.put(town1, distanceMap);
        	}
        	if(roadMap.get(town2) == null) {
        		Map<String, Integer> distanceMap = new HashMap<>();
        		roadMap.put(town2, distanceMap);
        	}
        	roadMap.get(town1).put(town2, distance);
        	roadMap.get(town2).put(town1, distance);
        }
        
        Set<String> visited = new HashSet<>();
        visited.add(String.format("%03d", 1));
        Map<String,Integer> firstConnected = roadMap.get(String.format("%03d", 1));
        
		recursive(roadMap, visited, firstConnected, K);
        return visited.size();
    }
    
    public static void recursive(Map<String, Map<String, Integer>> roadMap, Set<String> visited, Map<String,Integer> firstConnected, int K) {
    	if(firstConnected == null) {
    		return;
    	}
    	for(String key : firstConnected.keySet()) {
    		int distance = firstConnected.get(key);
    		if(distance <= K) {
    			visited.add(key);
    			recursive(roadMap, visited, roadMap.get(key), K-distance);
    		}
    	}
    }

}

