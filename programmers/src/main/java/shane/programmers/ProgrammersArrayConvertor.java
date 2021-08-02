package shane.programmers;

public class ProgrammersArrayConvertor {

	public static void main(String[] args) {
		String input = 
				"[[1,1,100,97]]";
		String output = input.replaceAll("\\[", "{").replaceAll("\\]", "}");
		System.out.println(output);
	}

}
