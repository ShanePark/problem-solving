package shane.programmers.lv1;

public class Dartgame {

	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
		System.out.println(solution("10D#10t#1T*"));
	}
	
    static public int solution(String dartResult) {
    	
    	class Dart{
    		int number;
    		int sdt;
    		char option=' ';
    		Dart(String result){
    			if(result.charAt(1)=='0') {
    				number = 10;
    				switch(result.charAt(2)) {
    				case 'S': sdt = 1; break;
    				case 'D': sdt = 2; break;
    				case 'T': sdt = 3; break;
    				}
    				if(result.length() == 4)
    					option = result.charAt(3);
    			}
    			else{
    				number=Integer.parseInt(result.charAt(0)+"");
    				switch(result.charAt(1)) {
    				case 'S': sdt = 1; break;
    				case 'D': sdt = 2; break;
    				case 'T': sdt = 3; break;
    				}
    				if(result.length() == 3)
    					option = result.charAt(2);
    			}

    		}
    		@Override
			public String toString() {
				return "Dart [number=" + number + ", sdt=" + sdt + ", option=" + option + ", score="+ score() + "]";
			}
			int score() {
    			if(option == ' ')
    				return (int)Math.pow(number, sdt);
    			else if(option == '*')
    				return (int)Math.pow(number, sdt)*2;
    			else
    				return -(int)Math.pow(number, sdt);
    		}
    	}
    	
    	int numberIndex2, numberIndex3;
    	
    	int i=1;
    	if(dartResult.charAt(1) =='0')
    		i++;
    	while(!( '0' <= dartResult.charAt(i) && dartResult.charAt(i) <= '9')) {
    		i++;
    	}
    	if(dartResult.charAt(i)=='1' && dartResult.charAt(i+1)=='0') { 
    		numberIndex2 = i;
    		i++;
    	}else numberIndex2=i;
    	i++;
    	
    	while(!( '0' <= dartResult.charAt(i) && dartResult.charAt(i) <= '9')) {
    		i++;
    	}
    	numberIndex3 = i;
    	
    	String[] results = new String[3];
    	results[0] = dartResult.substring(0,numberIndex2);
    	results[1] = dartResult.substring(numberIndex2,numberIndex3);
    	results[2] = dartResult.substring(numberIndex3);
    	Dart dart1 = new Dart(results[0]);
    	Dart dart2 = new Dart(results[1]);
    	Dart dart3 = new Dart(results[2]);
    	int result = dart1.score();
    	if(dart2.option == '*')
    		result *= 2;
    	if(dart3.option == '*')
    		result += dart2.score()*2;
    	else result += dart2.score();
    	
    	return result + dart3.score();
    	
    }
    
    

}
