package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class 불량사용자2 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"})).isEqualTo(2);
        assertThat(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})).isEqualTo(2);
        assertThat(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"})).isEqualTo(3);
    }

    Set<Integer> set;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        bt(user_id, 0, banned_id, 0);
        return set.size();
    }

    private void bt(String[] user_id, int visited, String[] banned_id, int i) {
        if (i == banned_id.length) {
            set.add(visited);
            return;
        }

        String bannedId = banned_id[i];
        for (int j = 0; j < user_id.length; j++) {
            String user = user_id[j];
            if (((visited | 1 << j) != visited) && possible(user, bannedId)) {
                bt(user_id, visited | 1 << j, banned_id, i + 1);
            }
        }
    }

    private boolean possible(String user, String bannedId) {
        if (user.length() != bannedId.length())
            return false;
        for (int i = 0; i < user.length(); i++) {
            char c = bannedId.charAt(i);
            if (user.charAt(i) != c && c != '*') {
                return false;
            }
        }
        return true;
    }
}
