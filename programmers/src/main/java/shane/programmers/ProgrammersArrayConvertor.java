package shane.programmers;

public class ProgrammersArrayConvertor {

	public static void main(String[] args) {
		String input = 
				"[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]";
		String output = input.replaceAll("\\[", "{").replaceAll("\\]", "}");
		System.out.println(output);
	}

}
