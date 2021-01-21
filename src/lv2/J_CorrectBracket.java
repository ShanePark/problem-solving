package lv2;
// review : passed on my first try
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class J_CorrectBracket {

	public static void main(String[] args) {
		String[] strings = {"()()","(())()",")()(","(()("};
		for(String str : strings)
			System.out.println(solution(str));
	}

	static boolean solution(String s) {
		char[] chars = s.toCharArray();
		LinkedList<Boolean> stack = new LinkedList<>();

		for(char c : chars) {
			if(c == '(')
				stack.push(true);
			else if(c == ')') {
				try {
					stack.pop();
				} catch (NoSuchElementException e) {
					return false;
				}

			}
		}
		if(stack.size() >0)
			return false;
		return true;
	}

}
