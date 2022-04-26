package shane.programmers.lv3;

import com.tistory.shanepark.STool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiLevelToothBruthSales {

    public static void main(String[] args) {
        STool.printArray(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        Map<String, Member> map = new HashMap<>();

        for (String s : enroll) {
            map.put(s, new Member(s));
        }

        for (int i = 0; i < referral.length; i++) {
            String child = enroll[i];
            String parent = referral[i];
            Member childMember = map.get(child);
            if (!"-".equals(parent)) {
                Member parentMember = map.get(parent);
                childMember.parent = parentMember;
                parentMember.children.add(childMember);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerStr = seller[i];
            Member m = map.get(sellerStr);
            m.sell(amount[i] * 100);
        }

        int[] result = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            Member m = map.get(enroll[i]);
            result[i] = m.money;
        }

        return result;
    }

    static class Member {
        String name;
        Member parent;
        List<Member> children = new ArrayList<>();
        int money = 0;

        public Member(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    ", parent=" + (parent != null ? parent.name : "-") +
                    ", childCount=" + children.size() +
                    ", money =" + money +
                    '}';
        }

        public void sell(int amount) {
            int commission = amount / 10;
            if (parent != null && commission > 0) {
                parent.sell(commission);
            }
            this.money += amount - commission;
        }

    }

}
