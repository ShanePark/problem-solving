package shane.programmers.lv0;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 로그인_성공 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"meosseugi", "1234"}, Ps.strArray("[[\"rardss\", \"123\"], [\"yyoom\", \"1234\"], [\"meosseugi\", \"1234\"]]"))).isEqualTo("login");
        assertThat(solution(new String[]{"programmer01", "15789"}, Ps.strArray("[[\"programmer02\", \"111111\"], [\"programmer00\", \"134\"], [\"programmer01\", \"1145\"]]"))).isEqualTo("wrong pw");
        assertThat(solution(new String[]{"rabbit04", "98761"}, Ps.strArray("[[\"jaja11\", \"98761\"], [\"krong0313\", \"29440\"], [\"rabbit00\", \"111333\"]]"))).isEqualTo("fail");
    }

    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String pw = id_pw[1];
        for (String[] member : db) {
            String dbId = member[0];
            String dbPass = member[1];
            if (id.equals(dbId)) {
                return dbPass.equals(pw) ? "login" : "wrong pw";
            }
        }
        return "fail";
    }
}
