package shane.programmers.lv3;

import java.util.*;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	실패 (0.52ms, 52.7MB)
테스트 2 〉	실패 (0.66ms, 52MB)
테스트 3 〉	통과 (0.66ms, 52.3MB)
테스트 4 〉	통과 (0.74ms, 51.8MB)
채점 결과
정확성: 50.0
합계: 50.0 / 100.0
 */
public class DfsBfsTravelRoute {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
		System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}})));
	}
	
    public static String[] solution(String[][] tickets) {
    	final int ticketCount = tickets.length;
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
    	
    	String[] answer = new String[ticketCount+1];
    	String airport = "ICN";
    	answer[0] = airport;
    	while(list.size() > 0) {
    		int index = binarySearch(list, airport,0,list.size()-1);
//    		System.out.println(list);
//    		System.out.println(airport);
//    		System.out.println(index);
			airport = list.get(index).to;
			answer[ticketCount+1-list.size()] = airport; 
			list.remove(index);
    	}
        
        return answer;
    }
    
    public static int binarySearch(List<Ticket> list, String airport, int left, int right) {
    	if(left == right-1 || left >= right) {
    		return list.get(left).from.equals(airport)? left : right;
    	}
		int middle = (right + left) / 2;
		String from = list.get(middle).from;
		if(from.equals(airport)) {
			while(middle>=1 && list.get(middle-1).from.equals(airport)) {
				middle--;
			}
			return middle;
		}else {
			if(from.compareTo(airport)<0) {
				return binarySearch(list, airport, middle, right);
			}else {
				return binarySearch(list, airport, left, middle);
			}
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
