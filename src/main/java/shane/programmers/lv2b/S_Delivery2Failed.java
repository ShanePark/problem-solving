package shane.programmers.lv2b;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (2.79ms, 53MB)
테스트 2 〉	통과 (30.16ms, 61.3MB)
테스트 3 〉	통과 (2.61ms, 52.1MB)
테스트 4 〉	통과 (3.42ms, 52.6MB)
테스트 5 〉	통과 (2.97ms, 53.2MB)
테스트 6 〉	통과 (1.45ms, 52.8MB)
테스트 7 〉	통과 (1.96ms, 52.5MB)
테스트 8 〉	통과 (2.15ms, 52.2MB)
테스트 9 〉	통과 (1.92ms, 53MB)
테스트 10 〉	통과 (2.26ms, 52.7MB)
테스트 11 〉	통과 (2.28ms, 53.2MB)
테스트 12 〉	통과 (39.60ms, 58MB)
테스트 13 〉	통과 (22.63ms, 59MB)
테스트 14 〉	통과 (36.48ms, 55.8MB)
테스트 15 〉	통과 (52.06ms, 61.3MB)
테스트 16 〉	통과 (19.63ms, 58.8MB)
테스트 17 〉	실패 (시간 초과)
테스트 18 〉	통과 (16.28ms, 54.7MB)
테스트 19 〉	통과 (45.76ms, 67.1MB)
테스트 20 〉	통과 (435.48ms, 82.4MB)
테스트 21 〉	통과 (58.85ms, 60MB)
테스트 22 〉	통과 (41.40ms, 54.6MB)
테스트 23 〉	통과 (4614.46ms, 395MB)
테스트 24 〉	실패 (시간 초과)
테스트 25 〉	통과 (90.40ms, 71.8MB)
테스트 26 〉	통과 (64.70ms, 67.2MB)
테스트 27 〉	실패 (시간 초과)
테스트 28 〉	통과 (136.89ms, 84.7MB)
테스트 29 〉	실패 (시간 초과)
테스트 30 〉	통과 (64.05ms, 59.9MB)
테스트 31 〉	실패 (시간 초과)
테스트 32 〉	실패 (시간 초과)
채점 결과
정확성: 81.3
합계: 81.3 / 100.0
 */
public class S_Delivery2Failed {

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
        
        Set<String> towns = new HashSet<>();
        towns.add("001");
        
        recursive(towns, roadMap, "001", K);
        
        return towns.size();
    }
    
    public static void recursive(Set<String> towns, Map<String, Map<String, Integer>> roadMap, String town, int K) {
    	Map<String, Integer> map = roadMap.get(town);
    	for(String key : map.keySet()) {
    		int distance = map.get(key);
    		if(distance <= K) {
    			towns.add(key);
    			if(K- distance > 0) {
    				recursive(towns, roadMap, key, K-distance);
    			}
    		}
    	}
    }
    
        

}

