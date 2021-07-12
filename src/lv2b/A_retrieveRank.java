package lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shane
 * 테스트 1 〉	통과 (3.53ms, 52.9MB)
테스트 2 〉	통과 (5.63ms, 52.8MB)
테스트 3 〉	통과 (9.23ms, 53MB)
테스트 4 〉	통과 (47.20ms, 56.7MB)
테스트 5 〉	통과 (60.08ms, 57.7MB)
테스트 6 〉	통과 (52.56ms, 57.1MB)
테스트 7 〉	통과 (80.49ms, 60.2MB)
테스트 8 〉	통과 (116.34ms, 65.6MB)
테스트 9 〉	통과 (83.25ms, 62.1MB)
테스트 10 〉	통과 (67.10ms, 61.5MB)
테스트 11 〉	통과 (62.85ms, 57.6MB)
테스트 12 〉	통과 (76.85ms, 57.5MB)
테스트 13 〉	통과 (70.69ms, 60.6MB)
테스트 14 〉	통과 (92.46ms, 60MB)
테스트 15 〉	통과 (91.92ms, 59.7MB)
테스트 16 〉	통과 (51.21ms, 57.3MB)
테스트 17 〉	통과 (62.67ms, 57.2MB)
테스트 18 〉	통과 (104.13ms, 61.2MB)
 *	Passed Accuracy but failed on efficiency
 */
public class A_retrieveRank {
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] result = solution(info, query);
		System.out.println(Arrays.toString(result));

	}
	
    public static int[] solution(String[] info, String[] query) {
    	
    	final String[] languages = {"cpp", "java", "python"};
    	final String[] positions = {"backend", "frontend"};
    	final String[] exps = {"junior", "senior"};
    	final String[] soulFoods = {"chicken", "pizza"};
    	
    	class Applicant{
        	int language;
        	int position;
        	int exp;
        	int soulFood;
        	int score;
        	
        	@Override
			public String toString() {
				return "Applicant [language=" + language + ", position=" + position + ", exp=" + exp + ", soulFood=" + soulFood
						+ ", score=" + score + "]";
			}

        	
        	public Applicant(String info) {
        		String[] data = info.split(" ");
        		this.language = Arrays.binarySearch(languages,data[0]);
        		this.position = Arrays.binarySearch(positions,data[1]);
        		this.exp = Arrays.binarySearch(exps,data[2]);
        		this.soulFood = Arrays.binarySearch(soulFoods,data[3]);
        		this.score = Integer.parseInt(data[4]);
        	}
        	
        }
    	
    	List<Applicant> list = new ArrayList<>();
    	for(String personalInfo : info) {
    		Applicant applicant = new Applicant(personalInfo);
    		list.add(applicant);
    	}
    	
    	final int length = query.length;
    	int[] answer = new int[length];
    	for(int i=0; i<length; i++) {
    		// copy list to filter
    		List<Applicant> candidates = new ArrayList<>();
    		candidates.addAll(list);
    		
    		String[] queryData = query[i].split(" and ");
    		
    		// filter with language
    		if(!"-".equals(queryData[0])) {
    			int language = Arrays.binarySearch(languages,queryData[0]);
    			candidates.removeIf(app -> (app.language != language));
    		}
    		
    		// filter with position
    		if(!"-".equals(queryData[1])) {
    			int position = Arrays.binarySearch(positions,queryData[1]);
    			candidates.removeIf(app -> (app.position != position));
    		}
    		
    		// filter with exp
    		if(!"-".equals(queryData[2])) {
    			int exp = Arrays.binarySearch(exps,queryData[2]);
    			candidates.removeIf(app -> (app.exp != exp));
    		}
    		
    		String[] soulFoodAndScore = queryData[3].split(" ");
    		String sf = soulFoodAndScore[0];
    		int score = Integer.parseInt(soulFoodAndScore[1]);
    		
    		// filter with soulFood
    		if(!"-".equals(sf)) {
    			int soulFood = Arrays.binarySearch(soulFoods,sf);
    			candidates.removeIf(app -> (app.soulFood != soulFood));
    		}
    		
    		// filter with score
    		candidates.removeIf(app -> (app.score < score));
    		
    		answer[i] = candidates.size();
    		
    	}
        
        
        return answer;
    }
    


}
