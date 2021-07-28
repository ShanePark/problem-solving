package shane.programmers.lv1;


import java.util.Arrays;

/*수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.*/
public class PersonWhoCouldNotComplete_try1_InsertionSort {

	public static void main(String[] args) {
		String[] participant={"leo", "kiki", "eden"};
		String[] completion={"eden", "kiki"};
/////////////////////////////////////////////////////////////////////////////		
		
		 String answer="";
			
			for(int i=1; i<participant.length; i++){
				String temp=participant[i];
				int j;
				for(j=i-1; j>=0; j--){
					if(temp.compareTo(participant[j]) < 0)
						participant[j+1] = participant[j];
					else break;
								
				}
				participant[j+1] = temp;
			}
			
			for(int i=1; i<completion.length; i++){
				String temp=completion[i];
				int j;
				for(j=i-1; j>=0; j--){
					if(temp.compareTo(completion[j]) < 0)
						completion[j+1] = completion[j];
					else break;
								
				}
				completion[j+1] = temp;
			}		
			
			for( int i=0; i<completion.length; i++){
				if(i==completion.length-1 && participant[i].equals(completion[i]))
					answer = participant[i+1];
				if(!participant[i].equals(completion[i])){
					answer = participant[i];
					break;
				}
				
			}
		
		
		
		
		
		
		
////////////////////////////////////////////////////////////////////////////
		System.out.println(Arrays.toString(participant));
		System.out.println(Arrays.toString(completion));
		System.out.println(answer);

	}
}
