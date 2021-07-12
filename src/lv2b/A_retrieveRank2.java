package lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shane
 *	테스트 1 〉	통과 (3.50ms, 53MB)
테스트 2 〉	통과 (1.92ms, 55.5MB)
테스트 3 〉	통과 (10.67ms, 53.4MB)
테스트 4 〉	통과 (52.19ms, 56.6MB)
테스트 5 〉	통과 (75.63ms, 66.2MB)
테스트 6 〉	통과 (92.43ms, 70.6MB)
테스트 7 〉	통과 (87.11ms, 71.9MB)
테스트 8 〉	통과 (169.83ms, 76.6MB)
테스트 9 〉	통과 (184.39ms, 76.1MB)
테스트 10 〉	통과 (185.73ms, 76.1MB)
테스트 11 〉	통과 (82.89ms, 64.6MB)
테스트 12 〉	통과 (94.34ms, 70.8MB)
테스트 13 〉	통과 (73.26ms, 69MB)
테스트 14 〉	통과 (184.14ms, 75.4MB)
테스트 15 〉	통과 (170.88ms, 75.3MB)
테스트 16 〉	통과 (65.66ms, 65.8MB)
테스트 17 〉	통과 (121.78ms, 73.7MB)
테스트 18 〉	통과 (163.05ms, 75.5MB)
채점 결과
정확성: 40.0
효율성: 0.0
합계: 40.0 / 100.0
 */
public class A_retrieveRank2 {
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] result = solution(info, query);
		System.out.println(Arrays.toString(result));

	}
	
    public static int[] solution(String[] info, String[] query) {
    	
    	class Applicant{
        	String language;
        	String position;
        	String exp;
        	String soulFood;
        	int score;
        	
        	@Override
			public String toString() {
				return "Applicant [language=" + language + ", position=" + position + ", exp=" + exp + ", soulFood=" + soulFood
						+ ", score=" + score + "]";
			}

        	
        	public Applicant(String info) {
        		String[] data = info.split(" ");
        		this.language = data[0];
        		this.position = data[1];
        		this.exp = data[2];
        		this.soulFood = data[3];
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
    		
    		String[] queryData = query[i].split(" and ");
    		
    		int count = 0;
    		for(Applicant applicant : list) {
    			// filter with language
    			if(!"-".equals(queryData[0]) && !queryData[0].equals(applicant.language) ) {
    				continue;
    			}
    			// filter with position
				if(!"-".equals(queryData[1]) && !queryData[1].equals(applicant.position) ) {
    				continue;
    			}
    			// filter with exp
    			if(!"-".equals(queryData[2]) && !queryData[2].equals(applicant.exp) ) {
    				continue;
    			}
    			String[] soulFoodAndScore = queryData[3].split(" ");
    			String sf = soulFoodAndScore[0];
    			int score = Integer.parseInt(soulFoodAndScore[1]);
    			
    			// filter with soulFood
    			if(!"-".equals(sf) && !sf.equals(applicant.soulFood) ) {
    				continue;
    			}
    			
    			if(applicant.score < score) {
    				continue;
    			}
    			
    			count++;
    			
    		}
    		
    		answer[i] = count;
    		
    	}
        
        
        return answer;
    }
    


}
