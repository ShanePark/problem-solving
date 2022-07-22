package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class 불량사용자 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"})).isEqualTo(2);
        assertThat(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})).isEqualTo(2);
        assertThat(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"})).isEqualTo(3);
    }

    Set<String> set;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        bt(user_id, new boolean[user_id.length], banned_id, 0);
        return set.size();
    }

    private void bt(String[] user_id, boolean[] visited, String[] banned_id, int i) {
        if (i == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < visited.length; j++) {
                if (visited[j]) {
                    sb.append(j);
                }
            }
            set.add(sb.toString());
            return;
        }
        String bannedId = banned_id[i];
        for (int j = 0; j < user_id.length; j++) {
            String user = user_id[j];
            if (!visited[j] && possible(user, bannedId)) {
                visited[j] = true;
                bt(user_id, visited, banned_id, i + 1);
                visited[j] = false;
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
