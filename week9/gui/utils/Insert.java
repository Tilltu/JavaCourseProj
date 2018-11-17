package gui.utils;

import java.util.LinkedList;

public class Insert {
    public void insert(LinkedList<Account> list, int account_number, String name, String id_number,
                       double balance, String password, String sex) {
        Account account = new Account(account_number, name, id_number, balance, password, sex);
        list.add(account);
    }

    public void insert(LinkedList<Account> list, String name, String id_number,
                       double balance, String password, String sex) {
        Account account = new Account(list.get(list.size()).account_num + 1, name, id_number, balance, password, sex);
        list.add(account);
    }
    public void insert(LinkedList<Account> list, Account account) {
        list.add(account);
    }

}
