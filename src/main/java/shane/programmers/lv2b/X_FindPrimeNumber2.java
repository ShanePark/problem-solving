package shane.programmers.lv2b;

import java.util.HashSet;
import java.util.Set;

public class X_FindPrimeNumber2 {

	public static void main(String[] args) {
		System.out.println(solution("17"));
//		System.out.println(solution("011"));
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
    	if(number == 2)
    		return true;
    	if(number<2 || number%2==0)
    		return false;
    	for(int i=3; i<=Math.sqrt(number); i+=2) {
    		if(number % i == 0) {
    			return false;
    		}
    	}
    	return true;
    }
    
}

