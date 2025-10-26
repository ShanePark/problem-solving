package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 98
 * ms
 * Beats
 * 55.42%
 */
public class Q2043SimpleBankSystem {

    @Test
    public void test() {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        assertThat(bank.withdraw(3, 10)).isTrue();
        assertThat(bank.transfer(5, 1, 20)).isTrue();
        assertThat(bank.deposit(5, 20)).isTrue();
        assertThat(bank.transfer(3, 4, 15)).isFalse();
        assertThat(bank.withdraw(10, 50)).isFalse();
    }

    class Bank {

        final long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            account1--;
            account2--;
            if (balance.length <= account1)
                return false;
            if (balance.length <= account2)
                return false;
            if (balance[account1] < money)
                return false;
            balance[account1] -= money;
            balance[account2] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            account--;
            if (balance.length <= account)
                return false;
            balance[account] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            account--;
            if (balance.length <= account)
                return false;
            if (balance[account] < money)
                return false;
            balance[account] -= money;
            return true;
        }
    }

}
