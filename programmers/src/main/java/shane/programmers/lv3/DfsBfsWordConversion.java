package shane.programmers.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class DfsBfsWordConversion {
	static int result = 0;

	public static void main(String[] args) {
		System.out.println(solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
	}
	
    public static int solution(String begin, String target, String[] words) {
    	final int length = words.length;
    	boolean[] visited = new boolean[length];
    	Queue<String> queue = new LinkedList<>();
    	queue.add(begin);
    	bfs(queue, begin, target, visited, words, length, 0);
    	
        return result;
    }
    
    public static void bfs(Queue<String> queue, String begin, String target, boolean[] visited, String[] words, int length, int depth) {
    	if(result != 0) {
    		return;
    	}
    	
    	if(begin.equals(target)) {
    		result = depth;
    		return;
    	}
    	while(!queue.isEmpty() && depth<length) {
    		String str = queue.poll();
    		for(int i=0; i<length; i++) {
    			if(visited[i] == false && oneDiff(str, words[i])) {
    				visited[i] = true;
    				str = words[i];
    				queue.add(str);
    				bfs(queue, str, target, visited, words, length, depth+1);
    				queue.remove(str);
    				visited[i] = false;
    			}
    		}
    	}
    }
    
    public static boolean oneDiff(String str1, String str2){
    	int diff = 0;
    	final int length = str1.length();
    	for(int i=0; i<length; i++) {
    		if(str1.charAt(i) != str2.charAt(i)) {
    			diff++;
    		}
    	}
    	
    	return diff == 1;
    }

}
