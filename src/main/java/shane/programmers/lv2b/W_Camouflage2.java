package shane.programmers.lv2b;

import java.util.HashMap;
import java.util.Map;

public class W_Camouflage2 {

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
    		mul *= (types.get(key) +1 );
    	}
    	
    	
        return mul -1;
    }

}
