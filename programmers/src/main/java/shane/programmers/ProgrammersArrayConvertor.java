package shane.programmers;

public class ProgrammersArrayConvertor {

	public static void main(String[] args) {
		String input = 
				"[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]";
		
		System.out.println(arrayConverter(input));
	}

	private static String arrayConverter(String str) {
		return str.replaceAll("\\[", "{").replaceAll("\\]", "}");
	}

}
