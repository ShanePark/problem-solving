package shane.programmers.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class DfsBfsWordConversion2 {

	static class Node {
	    String word;
	    int depth;
	
	    public Node(String word, int depth) {
	        this.word = word;
	        this.depth = depth;
	    }
	}

	public static void main(String[] args) {
		System.out.println(solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
	}
	
	 public static int solution(String begin, String target, String[] words) {
	        final int n = words.length;

	        Queue<Node> q = new LinkedList<>();

	        boolean[] visit = new boolean[n];
	        q.add(new Node(begin, 0));

	        while(!q.isEmpty()) {
	            Node cur = q.poll();
	            if (cur.word.equals(target)) {
	            	return cur.depth;
	            }

	            for (int i=0; i<n; i++) {
	                if (!visit[i] && oneDiff(cur.word, words[i])) {
	                    visit[i] = true;
	                    q.add(new Node(words[i], cur.depth + 1));
	                }
	            }
	        }
	        
	        return 0;
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
