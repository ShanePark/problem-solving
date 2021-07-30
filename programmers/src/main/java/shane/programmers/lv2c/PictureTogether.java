package shane.programmers.lv2c;

import java.util.ArrayList;
import java.util.List;

public class PictureTogether {
	static int count;
	static final char[] people = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

	public static void main(String[] args) {
		System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
		System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"}));
	}
	
    public static int solution(int n, String[] data) {
    	count = 0;
    	
    	char[] output = new char[people.length];
    	boolean[] visited = new boolean[people.length];
    	
    	List<Condition> conditions = new ArrayList<>();
    	for(String str : data) {
    		Condition condition = new Condition(str);
    		conditions.add(condition);
    	}
    	
    	dfs(output, visited, 0, conditions);
    	
        return count;
    }
    
    static void dfs(char[] output, boolean[] visited, int depth, List<Condition> conditions) {
    	
    	if(depth == people.length) {
    		for(Condition condition : conditions) {
    			if(!check(output, condition)) {
    				return;
    			}
    		}
    		count++;
    		return;
    	}
    	
    	for(int i=0; i<people.length; i++) {
    		if(visited[i] == false) {
    			visited[i] = true;
    			output[depth] = people[i];
    			dfs(output, visited, depth+1, conditions);
    			visited[i] = false;
    		}
    	}
    	
    	
    }
    
    static boolean check(char[] output, Condition condition) {
    	int index1 = -1;
    	int index2 = -1;
    	for(int i=0; i<output.length; i++) {
    		char c = output[i];
    		if(condition.person1 == c) {
    			index1 = i;
    		}else if(condition.person2 == c) {
    			index2 = i;
    		}
    		if(index1>=0 && index2 >= 0) {
    			break;
    		}
    	}
    	
    	int distance = Math.abs(index1 - index2)-1;
    	if(condition.condition < 0) {
    		return distance < condition.distance;
    	}else if(condition.condition == 0) {
    		return distance == condition.distance;
    	}else {
    		return distance > condition.distance;
    	}
    	
    }
    
    static class Condition{
    	char person1;
    	char person2;
    	/**
    	 * case > : 1
    	 * case = : 0
    	 * case < : -1
    	 */
    	int condition;
    	int distance;
    	
    	Condition(String data){
    		char p1 = data.charAt(0);
    		char p2 = data.charAt(2);
    		char condition = data.charAt(3);
    		char distance = data.charAt(4);
    		person1 = (char)Math.min(p1, p2);
    		person2 = (char)Math.max(p1, p2);
    		this.distance = distance - '0';
    		this.condition = condition=='>' ? 1 : condition =='=' ? 0 : -1;
    	}

		@Override
		public String toString() {
			return "Condition [person1=" + person1 + ", person2=" + person2 + ", distance=" + distance + "]";
		}
    	
    }

}
