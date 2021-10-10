package shane.programmers.lv3;

import java.util.HashSet;
import java.util.Set;

public class BadUsers {
    public static void main(String[] args) {

//        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"})==2);
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
//        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        Set<String>[] sets = new Set[banned_id.length];
       for(int i=0; i< banned_id.length; i++){
           String bad = banned_id[i];
           sets[i] = new HashSet<>();
           for(String user : user_id) {
                if(check(bad, user)){
                    sets[i].add(user);
                }
           }
       }

       int result = 1;
       for(Set set : sets) {
           System.out.println(set);
       }

       return result;

    }

    private static boolean check(String bad, String user) {
        if(bad.length() != user.length())
            return false;
        for(int i=0; i<bad.length(); i++) {
            if(bad.charAt(i) != '*' && bad.charAt(i) != user.charAt(i))
                return false;
        }
        return true;
    }

}
