package shane.programmers.lv3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A_Network2 {
	
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
		System.out.println(solution(6, new int[][] {{1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}}));
	}	
	
    public static int solution(int n, int[][] computers) {
    	
        Map<Integer, Integer> networkMap = new HashMap<>();

        for(int i=0; i<n; i++) {
        	Integer network = networkMap.get(i);
        	if(network == null) {
        		network = i;
        	}
        	networkMap.put(i, network);
        	
        	for(int j=0; j<n; j++) {
        		if(computers[i][j] == 1 && i!=j) {
        			Integer connectedNetwork = networkMap.get(j);
        			if(connectedNetwork == null) {
        				networkMap.put(j, network);
        			}else {
        				// 기존 network 이관
        				move(networkMap, network, connectedNetwork);
        				network = connectedNetwork;
        			}
        		}
        	}
        }
        
        Set<Integer> networks = new HashSet<>();
        for(int i=0; i<n; i++) {
        	networks.add(networkMap.get(i));
        }
        
        return networks.size();
    }
    
    static void move(Map<Integer,Integer> networkMap, Integer from, Integer to) {
    	for(Integer key : networkMap.keySet()) {
    		if(networkMap.get(key) == from) {
    			networkMap.put(key, to);
    		}
    	}
    }
	
  

}


