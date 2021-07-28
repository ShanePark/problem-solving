package shane.study.dfs;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
	public static void main(String[] args) {
		solution("01234567");
	}
	
    public static void solution(String numbers) {

    	// 만들 수 있는 모든 경우의 Integer들을 모을 Set
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
    		dfs(arr, output, visited, 0, i, numbers, set);
    	}
    	
    	System.out.println(set);
    	System.out.println(set.size());
    }
    
    static void dfs(int[] arr, int[] output, boolean[] visited, int depth, int length, String numbers, Set<Integer> set) {
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
    				dfs(arr, output, visited, depth+1, length, numbers, set);
    				visited[i] = false;
    			}
    		}
    	}
    }
}
