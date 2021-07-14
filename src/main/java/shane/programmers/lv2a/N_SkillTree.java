package shane.programmers.lv2a;

public class N_SkillTree {

	public static void main(String[] args) {
//		System.out.println(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
		System.out.println(solution("CBD",new String[]{"AECB"}));
//		System.out.println(solution("REA",new String[]{"POA"}) == 0 );
	}
	
    static public int solution(String skill, String[] skill_trees) {
        int count = 0;
        for(String str : skill_trees)
        	count += isPossible(skill,str);
        return count;
    }
    
    static int isPossible(String skill, String tree) {
    	for(int i=0; i<skill.length(); i++) {
    		for(int j= i-1 ; j>=0; j--) {
    			if(tree.indexOf(skill.charAt(i)) != -1 && tree.indexOf(skill.charAt(j)) == -1) {
    				return 0;
    			}
    		}
    		for(int j=i+1; j<skill.length(); j++) {
    			if(tree.indexOf(skill.charAt(j))!=-1 && (tree.indexOf(skill.charAt(i)) > tree.indexOf(skill.charAt(j)))) {
    				return 0;
    			}
    		}
    	}
    	return 1;
    }

}
