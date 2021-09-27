package shane.programmers;

public class ProgrammersArrayConvertor {

	public static void main(String[] args) {
		String input = 
				"[[60, 50], [30, 70], [60, 30], [80, 40]]";
		
		System.out.println(arrayConverter(input));
	}

	private static String arrayConverter(String str) {
		return str.replaceAll("\\[", "{").replaceAll("\\]", "}");
	}

}
