package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N_MenuRenewal {
	
	

	public static void main(String[] args) {
		N_MenuRenewal solution = new N_MenuRenewal();
		System.out.println(Arrays.toString(solution.solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4})));
	}
	
    public String[] solution(String[] orders, int[] course) {
    	Map<Integer, Map<String, Integer>> dataMap = new HashMap<>();
    	for(String order : orders) {
    		addData(order, dataMap);
    	}
    	
    	List<String> list = new ArrayList<>();
    	for(int length : course) {
    		Map<String, Integer> map = dataMap.get(length);
    		List<String> maxCombList = getMaxComb(map, length);
    		if(maxCombList != null) {
    			for(String str : maxCombList) {
    				list.add(str);
    			}
    		}
    	}
    	
    	final int size = list.size();
    	String[] answer = new String[size];
    	for(int i=0; i<size; i++ ) {
    		answer[i] = list.get(i);
    	}
    	Arrays.sort(answer);
    	
        return answer;
    }
    
    public void addData(String order, Map<Integer, Map<String, Integer>> dataMap) {
    	
    }
    
    public List<String> getMaxComb(Map<String, Integer> map, int length){
    	List<String> maxList = new ArrayList<>();
    	int max = 2;
    	if(map == null)
    		return null;
    	for(String str : map.keySet()) {
    		int count = map.get(str);
    		if(count > max) {
    			maxList = new ArrayList<>();
    			maxList.add(str);
    		}else if(count == max) {
    			maxList.add(str);
    		}
    	}
    	return maxList;
    }

}





