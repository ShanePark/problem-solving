package shane.programmers.lv3;

import java.util.*;

public class DfsBfsTravelRoute2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}})));
	}
	
    public static String[] solution(String[][] tickets) {
    	final int ticketCount = tickets.length;
    	String[] answer = new String[ticketCount+1];
    	
    	List<Ticket> list = new ArrayList<>();
    	for(int i=0; i<ticketCount; i++) {
    		Ticket ticket = new Ticket(tickets[i]);
    		list.add(ticket);
    	}
    	
    	list.sort(new Comparator<Ticket>() {
    		@Override
    		public int compare(Ticket o1, Ticket o2) {
    			return o1.from.equals(o2.from) ? o1.to.compareTo(o2.to) : o1.from.compareTo(o2.from);
    		}
    	});
    	
    	Queue<Node> q = new LinkedList<>();
    	answer[0] = "ICN";
    	q.add(new Node("ICN", 0, answer, new boolean[ticketCount]));
    	
    	while(!q.isEmpty()) {
    		Node cur = q.poll();
//    		System.out.println(cur);
    		if(cur.depth == ticketCount) {
    			return cur.answer;
    		}
    		for(int i=0; i<ticketCount; i++) {
    			if(!cur.visited[i] && cur.to.equals(list.get(i).from)) {
    				String[] answerArr = Arrays.copyOf(cur.answer, ticketCount+1);
    				answerArr[cur.depth+1] = list.get(i).to; 
    				boolean[] visited = Arrays.copyOf(cur.visited, ticketCount);
    				visited[i] = true;
    				q.add(new Node(list.get(i).to, cur.depth+1, answerArr, visited));
    			}
    		}
    	}
    	
        return null;
    }
    
    static class Node{
    	String to;
    	int depth;
    	String[] answer;
    	boolean[] visited;
    	public Node(String to, int depth, String[] answer, boolean[] visited) {
    		this.to = to;
    		this.depth = depth;
    		this.answer = answer;
    		this.visited = visited;
    	}
		@Override
		public String toString() {
			return "Node [to=" + to + ", depth=" + depth + ", answer=" + Arrays.toString(answer) + ", visited="
					+ Arrays.toString(visited) + "]";
		}
		
    	
    }
    
    static class Ticket{
    	String from;
    	String to;
    	Ticket(String[] ticket) {
    		this.from = ticket[0];
    		this.to = ticket[1];
    	}
		@Override
		public String toString() {
			return "Ticket [from=" + from + ", to=" + to + "]";
		}
    	
    }

}
