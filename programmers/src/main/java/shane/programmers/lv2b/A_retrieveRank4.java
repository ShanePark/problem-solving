package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shane
 */
public class A_retrieveRank4 {
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"javabackendjuniorpizza 100","pythonfrontendseniorchicken 200","cpp-seniorpizza 250","-backendsenior- 150","---chicken 100","---- 150"};
		int[] result = solution(info, query);
		System.out.println(Arrays.toString(result));

	}
	
    public static int[] solution(String[] info, String[] query) {
    	
    	Map<String, List<Integer>> dictionary = new HashMap<>();
    	
    	for(String applicant : info) {
    		String[] data = applicant.split(" ");
    		String lan = data[0];
    		String position = data[1];
    		String career = data[2];
    		String soulFood = data[3];
    		int score = Integer.parseInt(data[4]);
    		
    		process(String.format("%s%s%s%s", lan, position, career, soulFood), score, dictionary);
    		process(String.format("%s%s%s", lan, position, career), score, dictionary);
    		process(String.format("%s%s%s", lan, position, soulFood), score, dictionary);
    		process(String.format("%s%s", lan, position), score, dictionary);
    		process(String.format("%s%s%s", lan, career, soulFood), score, dictionary);
    		process(String.format("%s%s", lan, career), score, dictionary);
    		process(String.format("%s%s", lan, soulFood), score, dictionary);
    		process(String.format("%s", lan), score, dictionary);
    		process(String.format("%s%s%s", position, career, soulFood), score, dictionary);
    		process(String.format("%s%s", position, career), score, dictionary);
    		process(String.format("%s%s", position, soulFood), score, dictionary);
    		process(String.format("%s", position), score, dictionary);
    		process(String.format("%s%s", career, soulFood), score, dictionary);
    		process(String.format("%s", career), score, dictionary);
    		process(String.format("%s", soulFood), score, dictionary);
    		process(String.format("null"), score, dictionary);
    	}
    	
    	// sort all the dictionaries
    	for(String key : dictionary.keySet()) {
    		List<Integer> list = dictionary.get(key);
    		list.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
    	}
    	
    	final int length = query.length;
    	int[] answer = new int[length];
    	for(int i=0; i<length; i++) {
    		String q = query[i];
    		int index = q.lastIndexOf(" ");
    		String search = q.substring(0, index);
    		search = search.replaceAll(" ", "").replaceAll("-", "").replaceAll("and", "");
    		if(search.isEmpty()) {
    			search = "null";
    		}
    		int min = Integer.parseInt(q.substring(index+1));
    		List<Integer> list = dictionary.get(search);
    		if(list == null) {
    			answer[i] = 0;
    		}else {
    			int binarySearch = binarySearch(list, min);
    			answer[i] = list.size() - binarySearch;
    		}
    	}
    	
    	return answer;
    	
    }
    
    public static void process (String preparedQuery, int score, Map<String, List<Integer>> dictionary) {
    	List<Integer> list = dictionary.get(preparedQuery);
    	if(list == null) {
    		list = new ArrayList<Integer>();
    		dictionary.put(preparedQuery, list);
    	}
    	list.add(score);
    }
    
    static int binarySearch(List<Integer>list, int number) {
    	int min = 0;
    	int max = list.size();
    	int mid = 0;
    	while (min < max) {
    		mid = (min + max) /2;
    		if(number <= list.get(mid)) {
    			max = mid;
    		}else {
    			min = mid + 1;
    		}
    	}
    	return min;
    }
    
    

}









