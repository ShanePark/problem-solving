package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.function.IntConsumer;

public class Q1195FizzBuzzMultithreaded {

    @Test
    public void test() {
        new FizzBuzz(15);
    }
}

class FizzBuzz {
    int n;
    int cur = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    synchronized public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (cur <= n) {
            if (cur % 15 != 0) {
                wait();
                continue;
            }
            printFizzBuzz.run();
            cur++;
            notifyAll();
        }

    }

    // printFizz.run() outputs "fizz".
    synchronized public void fizz(Runnable printFizz) throws InterruptedException {
        while (cur <= n) {
            if (cur % 3 != 0 || cur % 5 == 0) {
                wait();
                continue;
            }
            printFizz.run();
            cur++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    synchronized public void buzz(Runnable printBuzz) throws InterruptedException {
        while (cur <= n) {
            if (cur % 3 == 0 || cur % 5 != 0) {
                wait();
                continue;
            }
            printBuzz.run();
            cur++;
            notifyAll();
        }
    }


    // printNumber.accept(x) outputs "x", where x is an integer.
    synchronized public void number(IntConsumer printNumber) throws InterruptedException {
        while (cur <= n) {
            if (cur % 3 == 0 || cur % 5 == 0) {
                wait();
                continue;
            }
            printNumber.accept(cur++);
            notifyAll();
        }
    }
}
