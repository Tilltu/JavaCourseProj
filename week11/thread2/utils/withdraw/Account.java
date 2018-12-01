package thread2.utils.withdraw;

import thread2.test.MoneyWithdrawTest;

public class Account {
    double money;
    static volatile int withdraw_times = 0;

    public Account(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public synchronized void withdraw(double m) {
        while ((money - m) <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        withdraw_times++;
        MoneyWithdrawTest.area.append(Thread.currentThread().getName() + " came to " +
                                      "withdraw the money : \n");
        MoneyWithdrawTest.area.append("Money Before Taken:   " + money + "\n" +
                                      "Money      Taken     : " + m + "\n" +
                                      "Money After  Taken:   " + (money-=m) + "\n" +
                                      "Withdraw   Times     : " + withdraw_times + "\n" +
                                      "******************************************\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        notifyAll();
    }
}
