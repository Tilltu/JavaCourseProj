package thread2.utils.withdraw;

import thread2.test.MoneyWithdrawTest;

import java.util.Random;

public class MoneyTaker implements Runnable {
    Account account;
    Random random;

    public MoneyTaker(Account a) {
        random = new Random();
        account = a;
    }

    @Override
    public void run() {
        while (true) {
            account.withdraw(random.nextInt(20000));
        }
    }
}
