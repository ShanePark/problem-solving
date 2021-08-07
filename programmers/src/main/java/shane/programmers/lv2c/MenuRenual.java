package shane.programmers.lv2c;

import java.util.*;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (3.94ms, 70.2MB)
테스트 2 〉	통과 (1.86ms, 57.1MB)
테스트 3 〉	통과 (1.86ms, 57.2MB)
테스트 4 〉	통과 (2.86ms, 67.6MB)
테스트 5 〉	통과 (3.85ms, 73.2MB)
테스트 6 〉	통과 (9.90ms, 57.9MB)
테스트 7 〉	통과 (5.87ms, 58.8MB)
테스트 8 〉	통과 (84.16ms, 90.1MB)
테스트 9 〉	통과 (5080.05ms, 356MB)
테스트 10 〉	통과 (72.68ms, 75.3MB)
테스트 11 〉	통과 (27.96ms, 68.9MB)
테스트 12 〉	통과 (37.94ms, 67.4MB)
테스트 13 〉	통과 (2711.20ms, 358MB)
테스트 14 〉	통과 (5763.57ms, 356MB)
테스트 15 〉	통과 (2870.24ms, 359MB)
테스트 16 〉	통과 (591.69ms, 328MB)
테스트 17 〉	통과 (8237.92ms, 355MB)
테스트 18 〉	실패 (시간 초과)
테스트 19 〉	통과 (5754.22ms, 356MB)
테스트 20 〉	실패 (시간 초과)
채점 결과
정확성: 90.0
합계: 90.0 / 100.0
 */
public class MenuRenual {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4})));
		System.out.println(Arrays.toString(solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,5})));
		System.out.println(Arrays.toString(solution(new String[] {"XYZ", "XWY-", "WXA"}, new int[] {2,3,4})));
	}
	
    public static String[] solution(String[] orders, int[] course) {
    	List<String> list = new ArrayList<>();
        for(int n : course) {
        	Map<String, Integer> countMap = new HashMap<>();
        	for(String order : orders) {
        		Set<String> set = new HashSet<>();
        		char[] charArr = order.toCharArray();
        		dfs(charArr, new char[n], new boolean[charArr.length], 0, set);
        		for(String str : set) {
        			if(countMap.containsKey(str)) {
        				countMap.put(str, countMap.get(str)+1);
        			}else {
        				countMap.put(str, 1);
        			}
        		}
        	}
        	int max = 2;
        	for(String key : countMap.keySet()) {
        		max = Math.max(max, countMap.get(key));
        	}
        	for(String key : countMap.keySet()) {
        		if(countMap.get(key) == max) {
        			list.add(key);
        		}
        	}
        }
        String[] answer = new String[list.size()];
        int i = 0;
        for(String str : list) {
        	answer[i++] = str;
        }
        Arrays.sort(answer);
        return answer;
    }
    
    static void dfs(char[] arr, char[] output, boolean[] visited, int depth, Set<String> set ) {
    	if(depth == output.length) {
    		// output 배열을 str로 만들어 set에 등록한다.
    		Arrays.sort(output);
    		String str = String.valueOf(output);
    		set.add(str);
    	}else {
    		for(int i=0; i<arr.length; i++) {
    			if(visited[i] == false) {
    				visited[i] = true;
    				char[] temp = Arrays.copyOf(output, output.length);
    				temp[depth] = arr[i];
    				dfs(arr, temp, visited, depth+1, set);
    				visited[i] = false;
    			}
    		}
    	}
    }

}
