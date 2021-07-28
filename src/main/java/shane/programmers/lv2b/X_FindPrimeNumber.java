package shane.programmers.lv2b;

import java.util.HashSet;
import java.util.Set;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.60ms, 52MB)
테스트 2 〉	실패 (7.23ms, 53MB)
테스트 3 〉	통과 (0.16ms, 51.9MB)
테스트 4 〉	통과 (7.24ms, 53.8MB)
테스트 5 〉	통과 (26.15ms, 60.5MB)
테스트 6 〉	통과 (0.15ms, 52.3MB)
테스트 7 〉	통과 (0.44ms, 51.6MB)
테스트 8 〉	통과 (26.09ms, 60.4MB)
테스트 9 〉	통과 (0.22ms, 52.4MB)
테스트 10 〉	실패 (13.78ms, 53.5MB)
테스트 11 〉	실패 (1.88ms, 53MB)
테스트 12 〉	통과 (1.56ms, 52.7MB)
채점 결과
정확성: 75.0
합계: 75.0 / 100.0
 */
public class X_FindPrimeNumber {

	public static void main(String[] args) {
		System.out.println(solution("17"));
	}
	
    public static int solution(String numbers) {

    	// 만들 질 수 있는 모든 경우의 Integer들을 모을 Set
    	Set<Integer> set = new HashSet<>();
    	
    	// 0부터 length-1 까지의 숫자 배열을 만든다.
    	final int length = numbers.length();
    	int[] arr = new int[length];
    	for(int i=0; i<length; i++) {
    		arr[i] = i;
    	}
    	
    	// 만들 수 있는 모든 길이의 순열을 만든다.
    	boolean[] visited = new boolean[length];
    	for(int i=1; i<=length; i++) {
    		int[] output = new int[i];
    		perm(arr, output, visited, 0, i, numbers, set);
    	}
    	int answer = 0;
    	for(Integer number : set) {
    		if(isPrime(number)) {
    			answer++;
    		}
    	}
        return answer;
    }
    
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int length, String numbers, Set<Integer> set) {
    	if(depth == length) {
    		StringBuffer sb = new StringBuffer();
    		for(int i : output) {
    			sb.append(numbers.charAt(i));
    		}
    		set.add(Integer.parseInt(sb.toString()));
    	}else {
    		for(int i=0; i<numbers.length(); i++) {
    			if(visited[i] != true) {
    				visited[i] = true;
    				output[depth] = arr[i];
    				perm(arr, output, visited, depth+1, length, numbers, set);
    				visited[i] = false;
    			}
    		}
    	}
    }
    
    static public boolean isPrime(int number) {
    	if(number<2)
    		return false;
    	for(int i=2; i<Math.sqrt(number); i++) {
    		if(number % i == 0) {
    			return false;
    		}
    	}
    	return true;
    }
    
}

