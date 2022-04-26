package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

public class Q1108DefangingAnIPAddress {

    public static void main(String[] args) {
        Assertions.assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
    }

    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

}
