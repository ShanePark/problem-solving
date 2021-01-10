package lv1;


public class PressKeyPad {

	public static void main(String[] args) {
		int[] numbers = {0,1,0,2,8,7,6,4,0,9,6};
		String hand = "right";
		System.out.println(solution(numbers,hand));

	}

	static public String solution(int[] numbers, String hand) {
		StringBuffer sb = new StringBuffer();
		String lFinger = "*";
		String rFinger = "#";
		int lDistance,rDistance;
		final int SIZE = numbers.length;

		for(int i=0; i<SIZE; i++) {
			if(numbers[i]%3 == 1) {
				sb.append("L");
				lFinger = numbers[i]+"";
			}else if(numbers[i]%3 == 0 && numbers[i]!=0) {
				sb.append("R");
				rFinger = numbers[i]+"";
			}else{
				lDistance=distance(numbers[i],lFinger);
				rDistance=distance(numbers[i],rFinger);
				if(lDistance == rDistance) {
					if(hand.equals("right")) {
						sb.append("R");
						rFinger = numbers[i]+"";
					}else{
						sb.append("L");
						lFinger = numbers[i]+"";
					}
				}else if(lDistance>rDistance) {
					sb.append("R");
					rFinger = numbers[i]+"";
				}else {
					sb.append("L");
					lFinger = numbers[i]+"";
				}
			}
		}

		return sb.toString();
	}
	static int distance(int key, String finger) {
		if((key+"").equals(finger))
			return 0;
		switch(key) {
		case 2:{
			switch(finger) {
			case "1":
			case "5":
			case "3":return 1;
			case "4":
			case "6":
			case "8":return 2;
			case "7":
			case "9":
			case "0":return 3;
			case "*":
			case "#":return 4;
			}
		}
		case 5:{
			switch(finger) {
			case "2":
			case "4":
			case "6":
			case "8":return 1;
			case "1":
			case "3":
			case "7":
			case "9":
			case "0":return 2;
			case "*":
			case "#":return 3;
			}	
		}
		case 8:{
			switch(finger) {
			case "5":
			case "7":
			case "9":
			case "0":return 1;
			case "2":
			case "4":
			case "6":
			case "*":
			case "#":return 2;
			case "1":
			case "3":return 3;
			}	
		}
		case 0:{
			switch(finger) {
			case "8":
			case "*":
			case "#":return 1;
			case "5":
			case "7":
			case "9":return 2;
			case "2":
			case "4":
			case "6":return 3;
			case "1":
			case "3":return 4;
			}	
		}
		default :
			return 0;


		}

	}

}
