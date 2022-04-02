package shane.programmers.weekly;

public class Week1CalcDeficient3 {

	public static void main(String[] args) {
		Week1CalcDeficient3 solution = new Week1CalcDeficient3();
		System.out.println(solution.solution(3, 20, 4));
	}
	
    public long solution(int price, int money, int count) {
    	
    	long totalPrice = (long)(count + 1) * count * price / 2;
    	return totalPrice > money ? totalPrice - money : 0;
    	
    }

}
