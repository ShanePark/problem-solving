package shane.programmers;

public class ProgrammersArrayConvertor {

	public static void main(String[] args) {
		String input = 
				"[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]";
		
		System.out.println(arrayConverter(input));
	}

	private static String arrayConverter(String str) {
		return str.replaceAll("\\[", "{").replaceAll("\\]", "}");
	}

}
