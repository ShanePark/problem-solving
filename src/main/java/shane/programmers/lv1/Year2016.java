package shane.programmers.lv1;


public class Year2016 {

	public static void main(String[] args) {
		int a=5, b=24;
		//==================================
		
        String answer = "";
        String[] days ={"FRI","SAT","SUN","MON","TUE","WED","THU"};
        switch(a){
        case  1: answer = days[(b-1)%7]; break;
        case  2: answer = days[(31+(b-1))%7]; break;
        case  3: answer = days[(31+29+(b-1))%7]; break;
        case  4: answer = days[(31+29+31+(b-1))%7]; break;
        case  5: answer = days[(31+29+31+30+(b-1))%7]; break;
        case  6: answer = days[(31+29+31+30+31+(b-1))%7]; break;
        case  7: answer = days[(31+29+31+30+31+30+(b-1))%7]; break;
        case  8: answer = days[(31+29+31+30+31+30+31+(b-1))%7]; break;
        case  9: answer = days[(31+29+31+30+31+30+31+31+(b-1))%7]; break;
        case 10: answer = days[(31+29+31+30+31+30+31+31+30+(b-1))%7]; break;
        case 11: answer = days[(31+29+31+30+31+30+31+31+30+31+(b-1))%7]; break;
        case 12: answer = days[(31+29+31+30+31+30+31+31+30+31+30+(b-1))%7]; break;

        
        }
        		
        		//return answer;
        System.out.println(answer);
	} 

}
