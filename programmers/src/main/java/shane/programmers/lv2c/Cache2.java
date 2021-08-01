package shane.programmers.lv2c;

import java.util.LinkedList;
import java.util.Queue;

public class Cache2 {

	public static void main(String[] args) {
		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"} ));
		System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"} ));
		System.out.println(solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"} ));
	}
	
    public static int solution(int cacheSize, String[] cities) {
    	Queue<String> cache = new LinkedList<>();
    	
    	int answer = 0;
    	for(String str : cities) {
    		if(cache.contains(str.toUpperCase())) {
    			// cache hit
    			cache.remove(str.toUpperCase());
    			cache.offer(str.toUpperCase());
    			answer++;
    		}else {
    			// cache miss
    			cache.offer(str.toUpperCase());
    			if(cache.size() > cacheSize) {
    				cache.poll();
    			}
    			answer += 5;
    		}
    	}
        return answer;
    }

}
