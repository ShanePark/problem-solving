package shane.study.dfs;

public class Dice {

	public static void main(String[] args) {
		Dice dice = new Dice();
		System.out.println(dice.play());
		System.out.println(dice.play());

	}
	
	public int play(){
		return (int) ((Math.random() * 6) + 1);
	}

}
