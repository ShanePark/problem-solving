package shane.leetcode.easy;

import org.junit.Assert;

public class Q1108DefangingAnIPAddress {

    public static void main(String[] args) {
        Assert.assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
    }

    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

}
