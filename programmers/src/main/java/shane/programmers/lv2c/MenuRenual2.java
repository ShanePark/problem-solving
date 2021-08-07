package shane.programmers.lv2c;

import java.util.*;

public class MenuRenual2 {

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
        		if(order.length() < n)
        			continue;
        		Set<String> set = new HashSet<>();
        		char[] charArr = order.toCharArray();
        		Arrays.sort(charArr);
        		dfs(charArr, new char[n], new boolean[charArr.length], 0, set, -1);
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
    
    static void dfs(char[] arr, char[] output, boolean[] visited, int depth, Set<String> set, int lastIndex ) {
    	if(depth == output.length) {
    		// output 배열을 str로 만들어 set에 등록한다.
    		Arrays.sort(output);
    		String str = String.valueOf(output);
    		set.add(str);
    	}else {
    		for(int i=lastIndex+1; i<arr.length; i++) {
    			if(visited[i] == false) {
    				visited[i] = true;
    				char[] temp = Arrays.copyOf(output, output.length);
    				temp[depth] = arr[i];
    				dfs(arr, temp, visited, depth+1, set, i);
    				visited[i] = false;
    			}
    		}
    	}
    }

}
