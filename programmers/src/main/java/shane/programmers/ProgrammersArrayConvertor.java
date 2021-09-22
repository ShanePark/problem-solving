package shane.programmers;

public class ProgrammersArrayConvertor {

	public static void main(String[] args) {
		String input = 
				"[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]";
		
		System.out.println(arrayConverter(input));
	}

	private static String arrayConverter(String str) {
		return str.replaceAll("\\[", "{").replaceAll("\\]", "}");
	}

}
