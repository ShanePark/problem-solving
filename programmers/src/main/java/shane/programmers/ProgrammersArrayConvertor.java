package shane.programmers;

public class ProgrammersArrayConvertor {

	public static void main(String[] args) {
		String input = 
				"[[\"ICN\", \"BBB\"],[\"ICN\", \"CCC\"],[\"BBB\", \"CCC\"],[\"CCC\", \"BBB\"],[\"CCC\", \"ICN\"]]";
		String output = input.replaceAll("\\[", "{").replaceAll("\\]", "}");
		System.out.println(output);
	}

}
