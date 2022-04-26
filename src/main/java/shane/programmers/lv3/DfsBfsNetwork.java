package shane.programmers.lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.39ms, 52.3MB)
테스트 2 〉	통과 (0.29ms, 53MB)
테스트 3 〉	실패 (메모리 초과)
테스트 4 〉	실패 (메모리 초과)
테스트 5 〉	통과 (0.28ms, 52.6MB)
테스트 6 〉	실패 (메모리 초과)
테스트 7 〉	통과 (0.62ms, 56.1MB)
테스트 8 〉	실패 (메모리 초과)
테스트 9 〉	실패 (메모리 초과)
테스트 10 〉	실패 (메모리 초과)
테스트 11 〉	실패 (메모리 초과)
테스트 12 〉	실패 (메모리 초과)
테스트 13 〉	실패 (메모리 초과)
채점 결과
정확성: 30.8
합계: 30.8 / 100.0
 *
 */
public class DfsBfsNetwork {
	
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
		System.out.println(solution(6, new int[][] {{1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}}));
	}	
	
    public static int solution(int n, int[][] computers) {
    	
        Map<Integer, Network> networkMap = new HashMap<>();

        for(int i=0; i<n; i++) {
        	Network network = networkMap.get(i);
        	if(network == null) {
        		network = new Network(i);
        	}
        	networkMap.put(i, network);
        	
        	for(int j=0; j<n; j++) {
        		if(computers[i][j] == 1 && i!=j) {
        			Network connectedNetwork = networkMap.get(j);
        			if(connectedNetwork == null) {
        				networkMap.put(j, network);
        				network.computers.add(j);
        			}else {
        				// network를 모두 connectedNetwork로 이관
        				int[] oldList = new int[network.computers.size()];
        				for(int k=0; k<network.computers.size(); k++) {
        					oldList[k] = network.computers.get(k);
        				}
        				for(int key : oldList) {
        					networkMap.put(key, connectedNetwork);
        					connectedNetwork.computers.add(key);
        				}
        				network = connectedNetwork;
        			}
        		}
        	}
        }
        
        Set<Network> networks = new HashSet<>();
        for(int i=0; i<n; i++) {
        	networks.add(networkMap.get(i));
        }
        
        return networks.size();
    }
	
  

}

class Network{
	int networkNumber;
	List<Integer> computers;
	
	Network(int networkNumber){
		this.networkNumber = networkNumber;
		computers = new ArrayList<>();
		computers.add(networkNumber);
	}

	@Override
	public String toString() {
		return "Network [networkNumber=" + networkNumber + ", computers=" + computers + "]";
	}
	
	
}

